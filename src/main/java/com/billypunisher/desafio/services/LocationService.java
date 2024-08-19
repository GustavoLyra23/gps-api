package com.billypunisher.desafio.services;

import com.billypunisher.desafio.dto.LocationResponseDto;
import com.billypunisher.desafio.entities.Location;
import com.billypunisher.desafio.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public Page<LocationResponseDto> findLocations(Integer x, Integer y, Integer distance, Pageable pageable) {
        Page<Location> locations = locationRepository.findAllLocations(x, y, distance, pageable);
        return locations.map(LocationResponseDto::new);

    }
}

