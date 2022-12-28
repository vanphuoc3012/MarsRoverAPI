package com.pcoder.marsroverapiapp.controller;

import com.pcoder.marsroverapiapp.dto.FormDTO;
import com.pcoder.marsroverapiapp.entity.MarsCamera;
import com.pcoder.marsroverapiapp.entity.MarsPhoto;
import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import com.pcoder.marsroverapiapp.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService service;

    @GetMapping("/")
    public String homePage(ModelMap model,
                           FormDTO formDTO) {
        if(formDTO.getRoverName() == null) formDTO.setRoverName("curiosity");
        if(formDTO.getSol() == null || formDTO.getSol() == 0) formDTO.setSol(1);

        List<MarsCamera> listMarsCamera = service.cameraList();
        model.put("listMarsCamera", listMarsCamera);

        if(formDTO.getCameras().isEmpty()) formDTO.setCameras(listMarsCamera.stream().map(marsCamera -> marsCamera.getName()).collect(Collectors.toList()));

        model.put("formDTO", formDTO);

        Set<MarsPhoto> roverData = service.getRoverData(formDTO);
        model.put("roverData", roverData);

        if(roverData.isEmpty()) model.put("message", "No photos found");

        return "home";
    }
}
