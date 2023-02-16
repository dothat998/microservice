package com.spring.repository.impl;

import com.spring.dto.UserDto;
import com.spring.repository.BaseRepository;
import com.spring.request.UserRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl extends BaseRepository{
    private final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplateNormal() {
        return namedParameterJdbcTemplate;
    }
    public List<UserDto> searchList(UserRequest dto) {
        StringBuilder sqlBuilder = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();
        sqlBuilder.append("  SELECT ");
        sqlBuilder.append("     name name, ");
        sqlBuilder.append("     username username, ");
        sqlBuilder.append("     email email ");
        sqlBuilder.append(" FROM user ");
        sqlBuilder.append(" WHERE 1 =1  ");
        if (dto != null) {
            if (StringUtils.isNotBlank(dto.getName())) {
                sqlBuilder.append(" AND name = :name   ");
                parameters.put("name", dto.getName());
            }
            if (StringUtils.isNotBlank(dto.getUserName())) {
                sqlBuilder.append(" AND username = :username   ");
                parameters.put("username", dto.getUserName());
            }
            if (StringUtils.isNotBlank(dto.getEmail())) {
                sqlBuilder.append(" AND email =:email  ");
                parameters.put("email", dto.getEmail());
            }
        }
        return getNamedParameterJdbcTemplateNormal().query(sqlBuilder.toString(),
                parameters, BeanPropertyRowMapper.newInstance(UserDto.class));
//        return getListDataTableBySqlQuery(sqlBuilder.toString(),parameters,dto.getCurrentPage(), dto.getPageSize(),UserDto.class,"id","id");
//        Kieu tra ve la list
    }
}
