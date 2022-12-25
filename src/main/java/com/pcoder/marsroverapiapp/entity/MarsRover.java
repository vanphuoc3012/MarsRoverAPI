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
public class MarsRover {

    private Long id;

    private String name;

    @JsonProperty("landing_date")
    private String landingDate;

    @JsonProperty("launch_date")
    private String launchDate;

    private String status;

    @Override
    public String toString() {
        return "MarsRover{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landingDate=" + landingDate +
                ", launchDate=" + launchDate +
                ", status='" + status + '\'' +
                '}';
    }
}
