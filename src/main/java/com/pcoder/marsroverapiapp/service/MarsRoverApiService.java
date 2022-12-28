package com.pcoder.marsroverapiapp.service;

import com.pcoder.marsroverapiapp.dto.FormDTO;
import com.pcoder.marsroverapiapp.entity.MarsCamera;
import com.pcoder.marsroverapiapp.entity.MarsPhoto;
import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import com.pcoder.marsroverapiapp.repository.MarsCameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MarsRoverApiService {
    private static final String API_KEY = "H9jPVMMWjV1MjSTuWVFcedK0Y5hegoyBumV67NuL";

    @Autowired
    private MarsCameraRepository marsCameraRepository;

    public Set<MarsPhoto> getRoverData(FormDTO formDTO) {
        RestTemplate rt = new RestTemplate();

        String rover = formDTO.getRoverName();
        int sol = formDTO.getSol();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/"+rover+"/photos?sol="+sol+"&api_key="+API_KEY,MarsRoverApiResponse.class);

        List<MarsPhoto> photos = response.getBody().getPhotos();
        Set<MarsPhoto> collectPhotos = photos.stream()
                .filter(marsPhoto -> formDTO.getCameras().contains(marsPhoto.getCamera().getName()))
                .collect(Collectors.toSet());

        return collectPhotos;
    }

    public List<MarsCamera> cameraList() {
        return (List<MarsCamera>) marsCameraRepository.findAll();
    }
}
