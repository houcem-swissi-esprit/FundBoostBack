package com.example.projett.services;

import com.example.projett.entities.Campaign;
import com.example.projett.entities.CampaignStatus;
import com.example.projett.entities.FundingType;
import com.example.projett.entities.User;
import com.example.projett.repositories.ICampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class CampaignService {
    @Autowired
    private ICampaignRepository campaignRepository;

    public Campaign createCampaign(Campaign campaign) {
        campaign.setStatus(CampaignStatus.PENDING); // Default status
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getCampaignsByCreator(User creator) {
        return campaignRepository.findByCreator(creator);
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign updateCampaignStatus(Long campaignId, CampaignStatus status) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        campaign.setStatus(status);
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getCampaignsByFundingType(FundingType fundingType) {
        return campaignRepository.findByFundingType(fundingType);
    }
}
