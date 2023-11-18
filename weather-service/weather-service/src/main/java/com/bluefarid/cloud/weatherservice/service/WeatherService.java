package com.bluefarid.cloud.weatherservice.service;

import com.bluefarid.cloud.weatherservice.gateway.WeatherAPIGateway;
import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import com.bluefarid.cloud.weatherservice.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherAPIGateway gateway;
    private final RedisUtil redisUtil;

    @SneakyThrows
    public WeatherAPIResponse checkWeather(String latAndLong) {
        WeatherAPIResponse weatherAPIResponse = redisUtil.getValue(latAndLong);
        if (Objects.isNull(weatherAPIResponse))
            weatherAPIResponse = gateway.weatherAPIResponse(latAndLong);
        redisUtil.save(latAndLong, weatherAPIResponse);
        return weatherAPIResponse;
    }

}
