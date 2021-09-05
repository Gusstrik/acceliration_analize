package com.strelnikov.practice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccelerometerDataDto {
    private double time;
    private double xValue;
    private double yValue;
    private double zValue;
}
