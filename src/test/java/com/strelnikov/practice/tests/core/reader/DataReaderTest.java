package com.strelnikov.practice.tests.core.reader;

import com.strelnikov.practice.core.reader.DataReader;
import com.strelnikov.practice.core.reader.impl.DataReaderImpl;
import com.strelnikov.practice.dto.AccelerometerDataDto;
import com.strelnikov.practice.tests.core.TestConstant;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;


public class DataReaderTest {
    private final String TEST_FILE_PATH = TestConstant.TEST_FOLDER + "/145-4_lac.csv";
    private final DataReader dataReader = new DataReaderImpl();

    @Test
    public void getFileListTest() {
        List<File> files = dataReader.getFiles(TestConstant.TEST_FOLDER);
        System.out.println(files);
        Assert.assertEquals(files.size(), 6);
    }

    @Test
    public void getAccelerometerDataTest(){
        File file = new File(TEST_FILE_PATH);
        List<AccelerometerDataDto> list = dataReader.readValues(file);
        Assert.assertEquals(list.get(1).getTime(),0.008,0);
    }
}
