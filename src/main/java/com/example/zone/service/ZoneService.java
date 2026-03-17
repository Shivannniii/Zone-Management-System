package com.example.zone.service;

import com.example.zone.entity.Zone;
import com.example.zone.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repo;

    public Zone addZone(Zone zone) {
        zone.setCreatedAt(LocalDateTime.now());
        zone.setUpdatedAt(LocalDateTime.now());
        return repo.save(zone);
    }

    public List<Zone> getAllZones() {
        return repo.findAll();
    }

    public Zone updateZone(int id, Zone newZone) {
        Zone zone = repo.findById(id).orElseThrow();
        zone.setZoneName(newZone.getZoneName());
        zone.setBrandId(newZone.getBrandId());
        zone.setActive(newZone.isActive());
        zone.setUpdatedAt(LocalDateTime.now());
        return repo.save(zone);
    }

    public void deleteZone(int id) {
        repo.deleteById(id);
    }
}