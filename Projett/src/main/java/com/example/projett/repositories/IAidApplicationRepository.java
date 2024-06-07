package com.example.projett.repositories;

import com.example.projett.entities.AidApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAidApplicationRepository extends JpaRepository<AidApplication,Long> {
}
