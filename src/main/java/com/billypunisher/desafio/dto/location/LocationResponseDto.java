package com.billypunisher.desafio.dto.location;

import com.billypunisher.desafio.projections.LocationProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDto {

    protected Long id;
    protected String name;

    //Constructor with mapper from entity to Dto
    public LocationResponseDto(LocationProjection projection) {
        id = projection.getId();
        name = projection.getName();
    }
}
