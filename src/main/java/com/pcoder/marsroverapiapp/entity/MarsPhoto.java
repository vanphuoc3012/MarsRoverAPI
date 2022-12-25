package com.pcoder.marsroverapiapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarsPhoto {

    private Long id;

    private Integer sol;

    private MarsCamera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private String earthDate;

    private MarsRover rover;

    @Override
    public String toString() {
        return "MarsPhoto{" +
                "id=" + id +
                ", sol=" + sol +
                ", camera=" + camera +
                ", imgSrc='" + imgSrc + '\'' +
                ", earthDate=" + earthDate +
                ", rover=" + rover +
                '}';
    }
}
