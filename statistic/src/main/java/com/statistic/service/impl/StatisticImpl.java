package com.statistic.service.impl;

import com.statistic.entity.Statistic;
import com.statistic.repository.StatisticRepository;
import com.statistic.request.StatisticRequest;
import com.statistic.service.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class StatisticImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void add(StatisticRequest statisticRequest) {
        Statistic statistic = modelMapper.map(statisticRequest, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticRequest> getAll() {
        List<StatisticRequest> statisticRequests = new ArrayList<>();
        StatisticRequest request = new StatisticRequest();

        List<Statistic> all = statisticRepository.findAll();
        all.forEach(statisticResponse -> {
            statisticRequests.add(modelMapper.map(statisticResponse,StatisticRequest.class));
        });


        return statisticRequests;
    }
}
