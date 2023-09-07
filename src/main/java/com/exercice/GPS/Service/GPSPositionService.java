package com.exercice.GPS.Service;

import org.springframework.stereotype.Service;

import com.exercice.GPS.Entity.GPSPosition;

@Service
public class GPSPositionService {
	
	public boolean isWithin10Km(GPSPosition position1, GPSPosition position2) {
	    double radius = 6371; // Earth's radius in kilometers
	    double lat1 = Math.toRadians(position1.getLatitude());
	    double lon1 = Math.toRadians(position1.getLongitude());
	    double lat2 = Math.toRadians(position2.getLatitude());
	    double lon2 = Math.toRadians(position2.getLongitude());

	    double dLat = lat2 - lat1;
	    double dLon = lon2 - lon1;

	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
	            + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    double distance = radius * c;

	    return distance <= 10; // Check if the distance is within 10 km.
	}


}
