package com.pcoder.marsroverapiapp;

import com.pcoder.marsroverapiapp.entity.MarsPhoto;
import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MarsRoverApiTest {

    @Test
    public void smallTest() {
        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY",MarsRoverApiResponse.class);
        System.out.println(response.getBody());
    }

    @Test
    public void getPhotoWithMultipleCamera() {
        String cam1 = "FHAZ";
        String cam2 = "RHAZ";
        String cam3 = "MAST";

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=H9jPVMMWjV1MjSTuWVFcedK0Y5hegoyBumV67NuL";

        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(url,MarsRoverApiResponse.class);

        MarsRoverApiResponse marsRoverApiResponse = response.getBody();
        List<MarsPhoto> photos = marsRoverApiResponse.getPhotos();

        Set<MarsPhoto> collectPhotos = photos.stream()
                .filter(marsPhoto -> List.of(cam1, cam2, cam3).contains(marsPhoto.getCamera().getName()))
                .collect(Collectors.toSet());

        collectPhotos.forEach(marsPhoto -> System.out.println(marsPhoto.getCamera().getName()));
    }
}
