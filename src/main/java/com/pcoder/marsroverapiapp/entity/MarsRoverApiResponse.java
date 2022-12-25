package com.pcoder.marsroverapiapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarsRoverApiResponse {
    private List<MarsPhoto> photos = new ArrayList<>();

    @Override
    public String toString() {
        return "MarsRoverApiResponse{" +
                "photos=" + photos +
                '}';
    }
}
