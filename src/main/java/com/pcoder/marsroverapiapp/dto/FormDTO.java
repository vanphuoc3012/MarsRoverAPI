package com.pcoder.marsroverapiapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {

    private String roverName;

    private Integer sol;

    private List<String> cameras;

    public void setCamerasByRover(String roverName) {

    }

}
