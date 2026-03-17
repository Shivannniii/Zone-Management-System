package com.example.zone.controller;

import com.example.zone.entity.Zone;
import com.example.zone.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneService service;

    @PostMapping
    public Zone addZone(@RequestBody Zone zone) {
        return service.addZone(zone);
    }

    @GetMapping
    public List<Zone> getZones() {
        return service.getAllZones();
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
        return service.updateZone(id, zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable int id) {
        service.deleteZone(id);
    }
}