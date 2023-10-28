package com.bluefarid.cloud.weatherservice.controller;

import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import com.bluefarid.cloud.weatherservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService service;

    @GetMapping
    public ResponseEntity<WeatherAPIResponse> checkWeather(String latAndLong) {
        return ResponseEntity.ok(service.checkWeather(latAndLong));
    }

}
