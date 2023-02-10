package com.base.kafka.service.iservice;

import com.base.kafka.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends BaseService, UserDetailsService {
    List<UserDto> selectUserByCode(Integer code);

    List<UserDto> search(HttpServletRequest request, UserDto dto);
}
