package com.bluefarid.cloud.weatherservice.util;

import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisUtil {
    private final String WEATHER_BASE_KEY = "weather";

    @Value("${redis.expire-time}")
    private Integer redisExpiryTime;

    private final RedisTemplate<String, WeatherAPIResponse> redisTemplate;

    public void save(String key, WeatherAPIResponse value) {
        String keyResult = WEATHER_BASE_KEY.concat("-".concat(key));
        redisTemplate.opsForValue().set(keyResult, value);
        redisTemplate.expire(key, redisExpiryTime, TimeUnit.SECONDS);
    }

    public WeatherAPIResponse getValue(String key) {
       WeatherAPIResponse weatherAPIResponse = redisTemplate.opsForValue().get(WEATHER_BASE_KEY.concat("-".concat(key)));
       if (Objects.nonNull(weatherAPIResponse))
           return weatherAPIResponse.setCached(true);
       return null;
    }
}
