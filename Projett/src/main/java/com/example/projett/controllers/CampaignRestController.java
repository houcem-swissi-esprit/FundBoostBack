package com.example.projett.controllers;

import com.example.projett.entities.Campaign;
import com.example.projett.entities.CampaignStatus;
import com.example.projett.entities.FundingType;
import com.example.projett.entities.User;
import com.example.projett.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/campaigns")
public class CampaignRestController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/create")
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
        Campaign createdCampaign = campaignService.createCampaign(campaign);
        return ResponseEntity.ok(createdCampaign);
    }

    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<List<Campaign>> getCampaignsByCreator(@PathVariable Long creatorId) {
        User creator = new User();
        creator.setIdUser(creatorId);
        List<Campaign> campaigns = campaignService.getCampaignsByCreator(creator);
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }

    @PutMapping("/{campaignId}/status")
    public ResponseEntity<Campaign> updateCampaignStatus(@PathVariable Long campaignId, @RequestParam CampaignStatus status) {
        Campaign updatedCampaign = campaignService.updateCampaignStatus(campaignId, status);
        return ResponseEntity.ok(updatedCampaign);
    }

    @GetMapping("/fundingType/{fundingType}")
    public ResponseEntity<List<Campaign>> getCampaignsByFundingType(@PathVariable FundingType fundingType) {
        List<Campaign> campaigns = campaignService.getCampaignsByFundingType(fundingType);
        return ResponseEntity.ok(campaigns);
    }
}
