package com.pcoder.marsroverapiapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MarsRover {

    @Id
    private Long id;

    private String name;

    @JsonProperty("landing_date")
    private Date landingDate;

    @JsonProperty("launch_date")
    private Date launchDate;

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
