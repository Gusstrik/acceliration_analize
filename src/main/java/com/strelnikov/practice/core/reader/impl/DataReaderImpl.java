package com.strelnikov.practice.core.reader.impl;

import com.strelnikov.practice.core.reader.DataReader;
import com.strelnikov.practice.dto.AccelerometerDataDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataReaderImpl implements DataReader {
    @Override
    public List<AccelerometerDataDto> readValues(File file) {
        List<AccelerometerDataDto> dataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!Character.isDigit(line.charAt(0)))
                    line = reader.readLine();
                String[] readLine = line.replace(",", ".").split(";");
                dataList.add(AccelerometerDataDto.builder()
                        .time(Double.parseDouble(readLine[0]))
                        .xValue(Double.parseDouble(readLine[1]))
                        .yValue(Double.parseDouble(readLine[2]))
                        .zValue(Double.parseDouble(readLine[3]))
                        .build());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't find file");
        } catch (IOException e) {
            System.err.println("Error while readin file. " + e.getMessage());
        }

        return dataList;
    }
}
