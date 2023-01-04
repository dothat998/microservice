package com.statistic.controller;

import com.statistic.request.StatisticRequest;
import com.statistic.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Thong ke viec Them sua xoa nguoi dung
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    Logger logger = LoggerFactory.getLogger(StatisticController.class);
    @Autowired
    StatisticService statisticService;

    @PostMapping
    public StatisticRequest add(@RequestBody StatisticRequest request){
        logger.debug("Add statistic {}",request);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
         statisticService.add(request);
        return request;
    }

    @GetMapping
    public List<StatisticRequest> getAll(){
        logger.debug("get all Statistic");
        return statisticService.getAll();
    }
}
