package com.example.projett.repositories;

import com.example.projett.entities.Donation;
import com.example.projett.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonator(User donator);
}
