package com.example.projett.services;

import com.example.projett.entities.Donation;
import com.example.projett.entities.User;
import com.example.projett.repositories.IDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    private IDonationRepository donationRepository;

    public Donation donateToCampaign(Donation donation) {
        return donationRepository.save(donation);
    }

    public List<Donation> getDonationsByDonator(User donator) {
        return donationRepository.findByDonator(donator);
    }
}
