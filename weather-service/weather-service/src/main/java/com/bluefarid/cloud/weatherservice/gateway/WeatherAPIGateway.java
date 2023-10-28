package com.bluefarid.cloud.weatherservice.gateway;

import com.bluefarid.cloud.weatherservice.response.WeatherAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherAPIGateway {
    @Value("${token.weather-api}")
    private String token;

    @Value("${header.host.weather-api}")
    private String hostHeader;

    @Value("${header.token.weather-api}")
    private String tokenHeader;

    @Value("${host.rapid-api}")
    private String mainHost;

    @Value("${host.weather-api}")
    private String host;

    private final RestTemplate restTemplate;

    public WeatherAPIResponse weatherAPIResponse(String latAndLong) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(tokenHeader, token);
        httpHeaders.add(hostHeader, host);
        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
        return restTemplate.exchange(mainHost.concat("?q=").concat(latAndLong), HttpMethod.GET, entity, WeatherAPIResponse.class).getBody();
    }
}
