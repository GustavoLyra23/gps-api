package com.billypunisher.desafio.controllers;


import com.billypunisher.desafio.dto.LocationResponseDto;
import com.billypunisher.desafio.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping(value = "/v1/{distance}")
    public ResponseEntity<Page<LocationResponseDto>> getLocationsFromPosition(Pageable pageable, @RequestParam Integer x,
                                                                              @RequestParam Integer y,
                                                                              @PathVariable("distance") Integer distance) {
        var page = locationService.findLocations(x, y, distance, pageable);
        return ResponseEntity.ok().body(page);
    }


}
