package com.ysk.service.impl;

import com.ysk.entity.Statistics;
import com.ysk.mapper.StatisticsMapper;
import com.ysk.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public List<Statistics> statisticsStoreInvent() {
        return statisticsMapper.statisticsStoreInvent();
    }
}
