package com.billypunisher.desafio.repositories;

import com.billypunisher.desafio.entities.Location;
import com.billypunisher.desafio.projections.LocationProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l.name as name, l.id as id FROM Location l WHERE SQRT(POWER(l.x - :refX, 2) + POWER(l.y - :refY, 2)) <= :maxDistance")
    Page<LocationProjection> findAllFromDistance(@Param("refX") Integer refX,
                                                 @Param("refY") Integer refY,
                                                 @Param("maxDistance") Integer maxDistance,
                                                 Pageable pageable);

    @Query("SELECT l.name as name, l.id as id FROM Location l")
    Page<LocationProjection> findAllLocations(Pageable pageable);


}
