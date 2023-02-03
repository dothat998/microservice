package com.spring.service.impl;

import com.sib.co.exception.NotFoundExceptionCustom;
import com.sib.co.utils.MapperUtils;
import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import com.spring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static ArrayList<UserModel> user = new ArrayList<UserModel>();

    static {
        user.add(new UserModel(1,"Nguyen Do That","dothat@gmail.com","0968758298","abc.img","123456"));
        user.add(new UserModel(2,"Nguyen Do That2","dothat@gmail.com","0968758298","abc.img","123456"));
        user.add(new UserModel(3,"Nguyen Do That3","dothat@gmail.com","0968758298","abc.img","123456"));
    }

    @Override
    public List<UserDto> getListUser() {
        return user.stream().map(obj -> MapperUtils.mapperEntAndDto(obj, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getListUserId(int id) {
        for (UserModel userModel : user){
            if (userModel.getId() == id){
                return MapperUtils.mapperEntAndDto(userModel, UserDto.class);
            }
        }
        throw new NotFoundExceptionCustom("Khong tim thay id");
    }

    @Override
    public List<UserDto> search(String name) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserModel userM : user){
            if (userM.getName().contains(name)){
                userDtoList.add(MapperUtils.mapperEntAndDto(userM, UserDto.class));
                return userDtoList;
            }
        }
        return null;
    }
}