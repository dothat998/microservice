package com.base.kafka.service;

import com.base.kafka.dto.BaseDto;
import com.base.kafka.dto.UserDto;
import com.base.kafka.entity.User;
import com.base.kafka.repository.UserRepository;
import com.base.kafka.service.iservice.UserService;
import com.base.kafka.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    @Override
    public <T extends BaseDto> List<T> findAll() {
        return null;
    }

    @Override
    public UserDto saveOrUpdate(HttpServletRequest request, Object object) {
        UserDto userDto = (UserDto) object;
        User user;
        if (userDto != null) {
            //lưu thêm mới
            if (AppUtil.NVL(userDto.getId()) == 0L) {
                user = AppUtil.mapperEntAndDto(userDto, User.class);
                user.setCreatedDate(new Date());
                user.setUpdatedDate(new Date());
                user.setIsAdminAccount(false);
                user.setCode(0);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            //update
            else {
                user = userRepository.findById(userDto.getId()).orElse(null);

                if (user != null) {
                    User dataUser = AppUtil.mapperEntAndDto(userDto, User.class);
                    dataUser.setId(user.getId());
                    dataUser.setUpdatedDate(new Date());
                    user = dataUser;
                }

            }
            return AppUtil.mapperEntAndDto(userRepository.save(user), UserDto.class);

        }
        return null;
    }

    @Override
    public <T extends BaseDto> T findById(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public Boolean delete(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public List<UserDto> selectUserByCode(Integer code) {
        return null;
    }

    @Override
    public List<UserDto> search(HttpServletRequest request, UserDto dto) {
        return null;
    }
}
