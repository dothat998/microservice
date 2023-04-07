package com.spring.service.impl;
import com.sib.co.exception.NotFoundExceptionCustom;
import com.sib.co.utils.MapperUtils;
import com.spring.dto.Datatable;
import com.spring.dto.UserDto;
import com.spring.exception.ResourceNotFoundException;
import com.spring.model.UserModel;
import com.spring.repository.UserRepository;
import com.spring.repository.impl.UserRepositoryImpl;
import com.spring.request.UserRequest;
import com.spring.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    public static final String HASH_KEY = "user";
    @Autowired(
            required = true
    )
    UserRepository userRepository;
    @Autowired
    UserRepositoryImpl userRepositoryImpl;
    @Autowired
    private RedisTemplate redisTemplate;
    private static ArrayList<UserModel> user = new ArrayList();

    public Page<UserDto> getListUser(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(new Sort.Order[]{Order.desc("id")}));
        Page<UserModel> modelPage = this.userRepository.findAll(pageable);
        this.userRepository.findAll(pageable);
        Page<UserDto> entities = modelPage.map(UserDto::fromEntity);
        this.redisTemplate.opsForValue().set("userModels", entities);
        return entities;
    }

    @Transactional
    public List<UserDto> sheduling(UserRequest userRequest, HttpServletRequest request, boolean schedule) {
        List<UserDto> userDtoList = this.userRepositoryImpl.searchList(userRequest);
        if (null != userDtoList) {
            this.logger.info("van con data trong list");
        }

        return userDtoList;
    }


    //redis cache
    public UserDto getListUserId(int id) {
        String key = "user_" + id;
        ValueOperations<String, UserDto> operations = this.redisTemplate.opsForValue();
        boolean hasKey = this.redisTemplate.hasKey(key);
        if (hasKey) {
            UserDto post = (UserDto)operations.get(key);
            this.logger.debug("=========  User find by cache : cache post >> " + post.toString());
            return post;
        } else {
            Optional<UserModel> userModel = this.userRepository.findById((long)id);
            Optional<UserDto> userDto = Optional.ofNullable(MapperUtils.mapperEntAndDto(userModel, UserDto.class));
            if (userDto.isPresent()) {
                operations.set(key, userDto.get(), 30L, TimeUnit.SECONDS);
                log.debug("==========    User Find By SQL DB  " + ((UserDto)userDto.get()).toString());
                return (UserDto)userDto.get();
            } else {
                throw new NotFoundExceptionCustom("Id not found " + id);
            }
        }
    }

    public Datatable search(UserRequest request, HttpServletRequest httpServletRequest) {
        this.logger.debug("Start PostOfficesServiceImpl.search() ");
        List<UserDto> userDtoList = this.userRepositoryImpl.searchList(request);
        return this.searchPage(userDtoList, request.getCurrentPage(), request.getPageSize());
    }

    public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }

    public Boolean existByUserName(String name) {
        return this.userRepository.existsByUsername(name);
    }

    public Boolean existByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public UserModel save(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    public void deleteUser(Long id) {
        String key = "emp_" + id;
        boolean hasKey = this.redisTemplate.hasKey(key);
        if (hasKey) {
            this.redisTemplate.delete(key);
            log.info("EmployeeServiceImpl.deletePost() : cache delete ID >> " + id);
        }

        Optional<UserModel> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            this.userRepository.delete(user.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private Datatable searchPage(List<?> lst, Integer currentPage, Integer pageSize) {
        Datatable datatable = new Datatable();
        List<Object> lstResult = new ArrayList();
        if (CollectionUtils.isNotEmpty(lst)) {
            datatable.setTotalRecords(lst.size());
            if (currentPage != null && pageSize != null) {
                int count = lst.size();
                if (count % pageSize == 0) {
                    datatable.setTotalPages(count / pageSize);
                } else {
                    datatable.setTotalPages(count / pageSize + 1);
                }

                if (currentPage > 0 && currentPage <= datatable.getTotalPages()) {
                    int rowStart = (currentPage - 1) * pageSize;
                    int pageSizeTotal = rowStart + pageSize;
                    int i;
                    if (count >= pageSizeTotal) {
                        for(i = rowStart; i < pageSizeTotal; ++i) {
                            lstResult.add(lst.get(i));
                        }
                    } else {
                        for(i = rowStart; i < count; ++i) {
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

    public UserServiceImpl() {
    }
}
