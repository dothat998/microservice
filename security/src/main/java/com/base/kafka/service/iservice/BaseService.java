package com.base.kafka.service.iservice;


import com.base.kafka.dto.BaseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BaseService {
    <T extends BaseDto> List<T> findAll();

    <T extends BaseDto> T saveOrUpdate(HttpServletRequest request, Object object);

    <T extends BaseDto> T findById(HttpServletRequest request, Long id);

    Boolean delete(HttpServletRequest request, Long id);
}
