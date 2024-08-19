package com.billypunisher.desafio.dto.location;

import com.billypunisher.desafio.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseWithXYDto extends LocationResponseDto {

    private Integer x;
    private Integer y;

    public LocationResponseWithXYDto(Location entity) {
        super.id = entity.getId();
        super.name = entity.getName();
        this.x = entity.getX();
        this.y = entity.getY();

    }


}
