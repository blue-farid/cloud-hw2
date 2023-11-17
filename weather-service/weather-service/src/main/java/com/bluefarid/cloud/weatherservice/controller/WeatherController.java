package com.bluefarid.cloud.weatherservice.controller;

import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import com.bluefarid.cloud.weatherservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@Slf4j
public class WeatherController {
    private final WeatherService service;

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @GetMapping
    public ResponseEntity<WeatherAPIResponse> checkWeather(String latAndLong) {
        log.info("REDIS HOST: {}", redisHost);
        return ResponseEntity.ok(service.checkWeather(latAndLong));
    }

}
