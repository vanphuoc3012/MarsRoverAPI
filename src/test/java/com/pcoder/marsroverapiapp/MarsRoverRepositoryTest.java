package com.pcoder.marsroverapiapp;

import com.pcoder.marsroverapiapp.entity.MarsCamera;
import com.pcoder.marsroverapiapp.entity.MarsRover;
import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import com.pcoder.marsroverapiapp.repository.MarsCameraRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.pcoder.marsroverapiapp.repository.MarsRoverRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class MarsRoverRepositoryTest {

    @Autowired
    private MarsRoverRepository marsRoverRepository;

    @Autowired
    private MarsCameraRepository marsCameraRepository;

    @Test
    public void testSaveRover() {
        RestTemplate rt = new RestTemplate();

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=H9jPVMMWjV1MjSTuWVFcedK0Y5hegoyBumV67NuL";
        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(url,MarsRoverApiResponse.class);
        MarsRoverApiResponse marsRoverApiResponse = response.getBody();
        MarsRover rover = marsRoverApiResponse.getPhotos().get(1).getRover();

        marsRoverRepository.save(rover);

        Assertions.assertThat(marsRoverRepository.findById(rover.getId())).isNotNull();
    }

    @Test
    public void testSaveCamera() {
        RestTemplate rt = new RestTemplate();

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/spirit/photos?sol=1000&api_key=H9jPVMMWjV1MjSTuWVFcedK0Y5hegoyBumV67NuL";
        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(url,MarsRoverApiResponse.class);
        MarsRoverApiResponse marsRoverApiResponse = response.getBody();

        Set<MarsCamera> marsCameraSet = marsRoverApiResponse.getPhotos().stream()
                .map(photo -> photo.getCamera())
                .collect(Collectors.toSet());

        marsCameraRepository.saveAll(marsCameraSet);

        Assertions.assertThat(marsCameraRepository.findAll()).hasSizeGreaterThan(1);
    }
}
