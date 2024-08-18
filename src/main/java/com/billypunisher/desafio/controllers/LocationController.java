package com.billypunisher.desafio.controllers;


import com.billypunisher.desafio.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping
    public ResponseEntity<Void> getLocationsFromPosition(@RequestParam Integer x, @RequestParam Integer y) {

//        locationService.findLocations(x, y);

        return null;
    }


}
