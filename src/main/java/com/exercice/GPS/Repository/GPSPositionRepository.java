package com.exercice.GPS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercice.GPS.Entity.GPSPosition;

public interface GPSPositionRepository extends JpaRepository<GPSPosition, Long> {
	
}

