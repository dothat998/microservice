package com.spring.service.impl;

import com.sib.co.dto.Datatable;
import com.sib.co.exception.NotFoundExceptionCustom;
import com.sib.co.utils.MapperUtils;
import com.spring.dto.UserDto;
import com.spring.exception.ResourceNotFoundException;
import com.spring.model.UserModel;
import com.spring.repository.UserRepository;
import com.spring.repository.impl.UserRepositoryImpl;
import com.spring.request.UserRequest;
import com.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service("userService")
public class UserServiceImpl implements UserService {


    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public static final String HASH_KEY = "user";
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private RedisTemplate redisTemplate;
    private static ArrayList<UserModel> user = new ArrayList<UserModel>();


    /*
     * @author: ThatND
     * @since: 7/2/2023 2:52 PM
     * @description:
     * @update:
     *
     * */

    @Override
    public Page<UserDto> getListUser(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(
                Sort.Order.desc("id")));
        Page<UserModel> modelPage = userRepository.findAll(pageable);

        Page<UserModel> userModels = userRepository.findAll(pageable);
        Page<UserDto> entities = modelPage.map(UserDto::fromEntity);
        redisTemplate.opsForValue().set("userModels", entities);
        return entities;
    }

    @Override
    public UserDto getListUserId(int id) {
        String key = "user_" + id;
        final ValueOperations<String, UserDto> operations = redisTemplate.opsForValue();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            final UserDto post = operations.get(key);
            log.debug("=========  User find by cache : cache post >> " + post.toString());
            return post;
        }
        final Optional<UserModel> userModel = userRepository.findById((long) id);
        final Optional<UserDto> userDto = Optional.ofNullable(MapperUtils.mapperEntAndDto(userModel, UserDto.class));
        if (userDto.isPresent()) {
            operations.set(key, userDto.get(), 30, TimeUnit.SECONDS);
            log.debug("==========    User Find By SQL DB  " + userDto.get().toString());
            return userDto.get();
        } else {
            throw new NotFoundExceptionCustom("Id not found "+id);
        }
    }

    @Override
    public Datatable search(UserRequest request, HttpServletRequest httpServletRequest) {
        logger.debug("Start PostOfficesServiceImpl.search() ");
        List<UserDto> userDtoList = userRepositoryImpl.searchList(request);
        return searchPage(userDtoList, request.getCurrentPage(), request.getPageSize());
    }


    @Override
    public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existByUserName(String name) {
        return userRepository.existsByUsername(name);
    }

    @Override
    public Boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public void deleteUser(Long id) {
        final String key = "emp_" + id;
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            log.info("EmployeeServiceImpl.deletePost() : cache delete ID >> " + id);
        }
        final Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private Datatable searchPage(List<?> lst, Integer currentPage, Integer pageSize) {
        Datatable datatable = new Datatable();
        List<Object> lstResult = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lst)) {
            datatable.setTotalRecords(lst.size());
            if (currentPage != null && pageSize != null) {
                int count = lst.size();
                if (count % pageSize == 0) {
                    datatable.setTotalPages(count / pageSize);
                } else {
                    datatable.setTotalPages((count / pageSize) + 1);
                }
                if (currentPage > 0 && currentPage <= datatable.getTotalPages()) {
                    int rowStart = (currentPage - 1) * pageSize;
                    int pageSizeTotal = rowStart + pageSize;
                    if (count >= pageSizeTotal) {
                        for (int i = rowStart; i < pageSizeTotal; i++) {
                            lstResult.add(lst.get(i));
                        }
                    } else {
                        for (int i = rowStart; i < count; i++) {
                            lstResult.add(lst.get(i));
                        }
                    }
                }
                datatable.setData(lstResult);
            }
            lst.clear();
        }
        return datatable;
    }

}