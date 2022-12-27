package com.pcoder.marsroverapiapp.service;

import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverApiService {
    private static final String API_KEY = "H9jPVMMWjV1MjSTuWVFcedK0Y5hegoyBumV67NuL";

    public MarsRoverApiResponse getRoverData(String rover, Integer sol) {
        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/"+rover+"/photos?sol="+sol+"&api_key="+API_KEY,MarsRoverApiResponse.class);
        return response.getBody();
    }
}
