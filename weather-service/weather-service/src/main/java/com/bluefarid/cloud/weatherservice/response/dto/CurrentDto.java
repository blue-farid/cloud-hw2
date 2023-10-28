package com.bluefarid.cloud.weatherservice.response.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurrentDto implements Serializable {
    private String tempC;
    private String tempF;
}
