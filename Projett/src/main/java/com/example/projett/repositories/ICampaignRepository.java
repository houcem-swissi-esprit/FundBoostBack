package com.example.projett.repositories;

import com.example.projett.entities.Campaign;
import com.example.projett.entities.FundingType;
import com.example.projett.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ICampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByCreator(User creator);
    List<Campaign> findByFundingType(FundingType fundingType);
}
