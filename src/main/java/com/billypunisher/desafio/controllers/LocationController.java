package com.billypunisher.desafio.controllers;


import com.billypunisher.desafio.dto.location.LocationRequestDto;
import com.billypunisher.desafio.dto.location.LocationResponseDto;
import com.billypunisher.desafio.dto.location.LocationResponseWithXYDto;
import com.billypunisher.desafio.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping(value = "/v1/{distance}")
    public ResponseEntity<Page<LocationResponseDto>> getLocationsFromPosition(Pageable pageable, @RequestParam Integer x, @RequestParam Integer y, @PathVariable("distance") Integer distance) {
        var page = locationService.findFromDistance(x, y, distance, pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping
    public ResponseEntity<Page<LocationResponseDto>> getLocations(Pageable pageable) {
        var locations = locationService.findAll(pageable);
        return ResponseEntity.ok().body(locations);
    }

    @PostMapping
    public ResponseEntity<LocationResponseWithXYDto> insertLocation(@Valid @RequestBody LocationRequestDto locationRequestDto) {
        var locationDto = locationService.insert(locationRequestDto);
        return ResponseEntity.ok().body(locationDto);
    }

}
