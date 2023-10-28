package com.bluefarid.cloud.weatherservice.config;

import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate<String, WeatherAPIResponse> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, WeatherAPIResponse> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
}
