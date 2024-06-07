package com.example.projett.controllers;

import com.example.projett.entities.Donation;
import com.example.projett.entities.User;
import com.example.projett.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationRestController {
    @Autowired
    private DonationService donationService;

    @PostMapping("/donate")
    public ResponseEntity<Donation> donateToCampaign(@RequestBody Donation donation) {
        Donation newDonation = donationService.donateToCampaign(donation);
        return ResponseEntity.ok(newDonation);
    }

    @GetMapping("/donator/{donatorId}")
    public ResponseEntity<List<Donation>> getDonationsByDonator(@PathVariable Long donatorId) {
        User donator = new User();
        donator.setIdUser(donatorId);
        List<Donation> donations = donationService.getDonationsByDonator(donator);
        return ResponseEntity.ok(donations);
    }
}
