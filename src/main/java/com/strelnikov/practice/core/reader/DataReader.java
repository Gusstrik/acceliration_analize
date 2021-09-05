package com.strelnikov.practice.core.reader;

import com.strelnikov.practice.dto.AccelerometerDataDto;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public interface DataReader {
    List<AccelerometerDataDto> readValues(File file);

    default List<File> getFiles(String folderPath){
        File file = new File(folderPath);
        return Arrays.asList(file.listFiles());
    }
}
