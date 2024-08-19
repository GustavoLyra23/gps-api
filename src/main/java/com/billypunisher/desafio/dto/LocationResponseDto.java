package com.billypunisher.desafio.dto;

import com.billypunisher.desafio.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDto {

    private String name;


    public LocationResponseDto(Location location) {
        name = location.getName();
    }


}
