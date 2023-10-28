package com.bluefarid.cloud.weatherservice.response.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationDto implements Serializable {
    private String name;
    private String country;
    private String lat;
    private String lon;
}
