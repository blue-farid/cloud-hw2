package com.bluefarid.cloud.weatherservice.response;

import com.bluefarid.cloud.weatherservice.response.dto.CurrentDto;
import com.bluefarid.cloud.weatherservice.response.dto.LocationDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WeatherAPIResponse implements Serializable {
    private LocationDto location;
    private CurrentDto current;
    private boolean cached;
}
