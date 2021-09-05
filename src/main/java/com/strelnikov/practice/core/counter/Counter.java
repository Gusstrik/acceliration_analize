package com.strelnikov.practice.core.counter;

import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.dto.CountedDataDto;

import java.util.List;

public interface Counter {
    List<CountedDataDto> count(List<AccelerometerDataDto> dataList);
}
