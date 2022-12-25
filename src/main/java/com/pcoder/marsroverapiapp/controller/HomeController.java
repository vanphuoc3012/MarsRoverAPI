package com.pcoder.marsroverapiapp.controller;

import com.pcoder.marsroverapiapp.entity.MarsRoverApiResponse;
import com.pcoder.marsroverapiapp.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService service;

    @GetMapping("/")
    public String homePage(ModelMap model) {

        MarsRoverApiResponse roverData = service.getRoverData();
        model.put("roverData", roverData.getPhotos());
        return "home";
    }
}
