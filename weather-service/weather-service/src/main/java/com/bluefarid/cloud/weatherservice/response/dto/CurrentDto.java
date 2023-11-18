package com.bluefarid.cloud.weatherservice.response.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurrentDto implements Serializable {
    private String temp_c;
    private String temp_f;
}
