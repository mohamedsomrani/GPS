package com.exercice.GPS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exercice.GPS.Dto.CheckProximityRequest;
import com.exercice.GPS.Entity.GPSPosition;
import com.exercice.GPS.Repository.GPSPositionRepository;
import com.exercice.GPS.Service.GPSPositionService;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class GPSPositionController {

    @Autowired
    private GPSPositionRepository positionRepository;
    
    private final GPSPositionService gpsPositionService;

    @Autowired
    public GPSPositionController(GPSPositionService gpsPositionService) {
        this.gpsPositionService = gpsPositionService;
    }

    // Create a new GPS position
    @PostMapping
    public ResponseEntity<GPSPosition> createPosition(@RequestBody GPSPosition position) {
        GPSPosition savedPosition = positionRepository.save(position);
        return ResponseEntity.ok(savedPosition);
    }

    // List all GPS positions
    @GetMapping
    public ResponseEntity<List<GPSPosition>> listPositions() {
        List<GPSPosition> positions = positionRepository.findAll();
        return ResponseEntity.ok(positions);
    }

    // Delete a GPS position by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
        positionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/checkProximity")
    public boolean checkProximity(@RequestBody CheckProximityRequest request) {
        GPSPosition position1 = request.getPosition1();
        GPSPosition position2 = request.getPosition2();

        return gpsPositionService.isWithin10Km(position1, position2);
    }
}
