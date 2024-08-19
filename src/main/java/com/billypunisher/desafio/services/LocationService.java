package com.billypunisher.desafio.services;

import com.billypunisher.desafio.dto.location.LocationRequestDto;
import com.billypunisher.desafio.dto.location.LocationResponseDto;
import com.billypunisher.desafio.dto.location.LocationResponseWithXYDto;
import com.billypunisher.desafio.entities.Location;
import com.billypunisher.desafio.projections.LocationProjection;
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
    public Page<LocationResponseDto> findFromDistance(Integer x, Integer y, Integer distance, Pageable pageable) {
        Page<LocationProjection> locations = locationRepository.findAllFromDistance(x, y, distance, pageable);
        return locations.map(LocationResponseDto::new);

    }

    @Transactional(readOnly = true)
    public Page<LocationResponseDto> findAll(Pageable pageable) {
        Page<LocationProjection> locations = locationRepository.findAllLocations(pageable);
        return locations.map(LocationResponseDto::new);
    }


    @Transactional()
    public LocationResponseWithXYDto insert(LocationRequestDto locationRequestDto) {
        Location location = new Location();
        location.setName(locationRequestDto.getName());
        location.setX(locationRequestDto.getX());
        location.setY(locationRequestDto.getY());
        location = locationRepository.save(location);
        return new LocationResponseWithXYDto(location);
    }
}

