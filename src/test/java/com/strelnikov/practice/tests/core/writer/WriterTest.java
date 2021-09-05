package com.strelnikov.practice.tests.core.writer;

import com.strelnikov.practice.core.writer.Writer;
import com.strelnikov.practice.core.writer.impl.WriterPoiImpl;
import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.tests.core.TestConstant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WriterTest {
    private final Writer writer = new WriterPoiImpl(TestConstant.TEST_FOLDER);

    @Test
    public void createSheetTest() {
        writer.createSheet("Test1");
        writer.saveFile();
    }

    @Test
    public void baseDataWriteTest() {
        List<AccelerometerDataDto> dataList = new ArrayList<>();
        dataList.add(AccelerometerDataDto.builder()
                .build());
        dataList.add(AccelerometerDataDto.builder()
                .time(0.008)
                .xValue(1.00)
                .yValue(1.0)
                .zValue(1.0)
                .build());
        writer.createSheet("TestBaseWriter");
        writer.writeBaseData(dataList);
        writer.saveFile();
    }
}
