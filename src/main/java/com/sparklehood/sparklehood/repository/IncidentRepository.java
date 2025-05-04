package com.sparklehood.sparklehood.repository;


import com.sparklehood.sparklehood.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
