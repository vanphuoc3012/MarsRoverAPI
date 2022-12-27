package com.pcoder.marsroverapiapp.controller;

import com.pcoder.marsroverapiapp.dto.FormDTO;
import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import com.pcoder.marsroverapiapp.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService service;

    @GetMapping("/")
    public String homePage(ModelMap model,
                           FormDTO formDTO) {
        if(formDTO.getRoverName() == null) formDTO.setRoverName("curiosity");
        if(formDTO.getSol() == null || formDTO.getSol() == 0) formDTO.setSol(1);


        model.put("formDTO", formDTO);

        MarsRoverApiResponse roverData = service.getRoverData(formDTO.getRoverName(), formDTO.getSol());
        model.put("roverData", roverData.getPhotos());
        return "home";
    }
}
