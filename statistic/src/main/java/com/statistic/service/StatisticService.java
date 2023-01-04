package com.statistic.service;

import com.statistic.request.StatisticRequest;

import java.util.List;

public interface StatisticService {
    void add(StatisticRequest request);
    List<StatisticRequest> getAll();

}


