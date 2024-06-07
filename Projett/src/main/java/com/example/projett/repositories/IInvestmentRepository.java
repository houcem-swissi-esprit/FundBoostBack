package com.example.projett.repositories;

import com.example.projett.entities.Campaign;
import com.example.projett.entities.Investment;

//import org.springframework.boot.autoconfigure.security.SecurityProperties;
import com.example.projett.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface IInvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByInvestor(User investor);
    List<Investment> findByCampaign(Campaign campaign);
}
