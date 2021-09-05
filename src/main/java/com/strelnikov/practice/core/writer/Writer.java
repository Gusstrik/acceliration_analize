package com.strelnikov.practice.core.writer;

import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.dto.CountedDataDto;

import java.util.List;

public interface Writer {

    void createSheet(String sheetName);

    void writeBaseData(List<AccelerometerDataDto> dataList);

    void writeCountedData(List<CountedDataDto> dataList);

    void saveFile();
}
