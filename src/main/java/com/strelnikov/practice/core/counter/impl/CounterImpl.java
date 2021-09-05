package com.strelnikov.practice.core.counter.impl;

import com.strelnikov.practice.core.counter.Counter;
import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.dto.CountedDataDto;

import java.util.ArrayList;
import java.util.List;

public class CounterImpl implements Counter {
    @Override
    public List<CountedDataDto> count(List<AccelerometerDataDto> dataList) {
        List<CountedDataDto> resultList = new ArrayList<>();
        resultList.add(new CountedDataDto());
        for (int i = 1; i < dataList.size(); i++) {
            CountedDataDto countedDataDto = new CountedDataDto();
            AccelerometerDataDto dataDto = dataList.get(i);
            AccelerometerDataDto previousDataDto = dataList.get(i - 1);
            countedDataDto.setDeltaTime(dataDto.getTime() - previousDataDto.getTime());
            countedDataDto.setSpeed(resultList.get(i - 1).getSpeed() + dataDto.getYValue() * countedDataDto.getDeltaTime());
            countedDataDto.setDistance(countedDataDto.getSpeed() * countedDataDto.getDeltaTime());
            resultList.add(countedDataDto);
        }
        return resultList;
    }
}
