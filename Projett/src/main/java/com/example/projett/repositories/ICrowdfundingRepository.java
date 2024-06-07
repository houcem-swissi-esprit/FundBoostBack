package com.example.projett.repositories;

import com.example.projett.entities.Crowdfunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrowdfundingRepository extends JpaRepository<Crowdfunding,Long> {
}
