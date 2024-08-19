package com.billypunisher.desafio.dto.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequestDto {

    @NotBlank(message = "name can'be blank")
    private String name;

    @Positive(message = "x position must be positive")
    private Integer x;

    @Positive(message = "y position must be positive")
    private Integer y;

}
