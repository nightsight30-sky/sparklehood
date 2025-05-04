package com.sparklehood.sparklehood.controller;

import com.sparklehood.sparklehood.model.Incident;
import com.sparklehood.sparklehood.repository.IncidentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentRepository repository;

    public IncidentController(IncidentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createIncident(@RequestBody Incident incident) {
        if (incident.getTitle() == null || incident.getSeverity() == null) {
            return ResponseEntity.badRequest().body("Missing required fields.");
        }

        if (!List.of("Low", "Medium", "High").contains(incident.getSeverity())) {
            return ResponseEntity.badRequest().body("Severity must be Low, Medium, or High.");
        }

        Incident saved = repository.save(incident);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidentById(@PathVariable Long id) {
        Optional<Incident> incident = repository.findById(id);

        return incident
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incident not found"));
    }
}
