package com.strelnikov.practice.core.writer.impl;

import com.strelnikov.practice.core.writer.Writer;
import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.dto.CountedDataDto;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriterPoiImpl implements Writer {
    private Workbook workbook;
    private Sheet sheet;
    private String fileName;

    public WriterPoiImpl(String folderPath) {
        fileName = folderPath + "/results.xls";
        workbook = new HSSFWorkbook();
    }

    @Override
    public void createSheet(String sheetName) {
        sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Time");
        row.createCell(1).setCellValue("X value");
        row.createCell(2).setCellValue("Y value");
        row.createCell(3).setCellValue("Z value");
        row.createCell(4).setCellValue("time delta");
        row.createCell(5).setCellValue("speed");
        row.createCell(6).setCellValue("distance");
        row.createCell(8).setCellValue("total distance");
    }

    @Override
    public void writeBaseData(List<AccelerometerDataDto> dataList) {
        for (int i=0;i<dataList.size();i++){
            Row row = sheet.createRow(i+1);
            AccelerometerDataDto dataDto = dataList.get(i);
            row.createCell(0).setCellValue(dataDto.getTime());
            row.createCell(1).setCellValue(dataDto.getXValue());
            row.createCell(2).setCellValue(dataDto.getYValue());
            row.createCell(3).setCellValue(dataDto.getZValue());
        }
    }

    @Override
    public void writeCountedData(List<CountedDataDto> dataList) {
        double totalDistance = 0.0;
        for (int i=0;i<dataList.size();i++){
            Row row = sheet.createRow(i+1);
            CountedDataDto dataDto = dataList.get(i);
            row.createCell(4).setCellValue(dataDto.getDeltaTime());
            row.createCell(5).setCellValue(dataDto.getSpeed());
            row.createCell(6).setCellValue(dataDto.getDistance());
            totalDistance += dataDto.getDistance();
        }
        sheet.getRow(1).createCell(9).setCellValue(totalDistance);
    }

    @Override
    public void saveFile() {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)){
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            System.err.println("Can't write a file");
        } catch (IOException e) {
            System.err.println("Can't create file");
        }
    }
}
