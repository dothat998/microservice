package com.spring.service.impl;

import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserRepository userRepository;

    private static ArrayList<UserModel> user = new ArrayList<UserModel>();


    /*
     * @author: ThatND
     * @since: 7/2/2023 2:52 PM
     * @description:
     * @update:
     *
     * */

    @Override
    public List<UserDto> getListUser() {
//        return user.stream().map(obj -> MapperUtils.mapperEntAndDto(obj, UserDto.class))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public UserDto getListUserId(int id) {
//        for (UserModel userModel : user){
//            if (userModel.getId() == id){
//                return MapperUtils.mapperEntAndDto(userModel, UserDto.class);
//            }
//        }
//        throw new NotFoundExceptionCustom("Khong tim thay id");
        return null;
    }

    @Override
    public List<UserDto> search(String name) {
//        List<UserDto> userDtoList = new ArrayList<>();
//        for (UserModel userM : user) {
//            if (userM.getName().contains(name)) {
//                userDtoList.add(MapperUtils.mapperEntAndDto(userM, UserDto.class));
//                return userDtoList;
//            }
//        }
        return null;
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
}