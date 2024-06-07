package com.example.projett.services;

import com.example.projett.entities.Campaign;
import com.example.projett.entities.Investment;
import com.example.projett.entities.User;
import com.example.projett.repositories.IInvestmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InvestmentService {
    @Autowired
    private IInvestmentRepository investmentRepository;

    public Investment investInCampaign(Investment investment) {
        return investmentRepository.save(investment);
    }


    public List<Investment> getInvestmentsByInvestor(User investor) {
        return investmentRepository.findByInvestor(investor);
    }

    public List<Investment> getInvestmentsByCampaign(Campaign campaign) {
        return investmentRepository.findByCampaign(campaign);
    }

    @Transactional
    public Investment sellShares(Long investmentId, Double percentageToSell) {
        Investment investment = investmentRepository.findById(investmentId)
                .orElseThrow(() -> new RuntimeException("Investment not found"));
        if (investment.getSharePercentage() < percentageToSell) {
            throw new RuntimeException("Not enough shares to sell");
        }
        investment.setSharePercentage(investment.getSharePercentage() - percentageToSell);
        return investmentRepository.save(investment);
    }

    @Transactional
    public Investment buyShares(Long investmentId, User buyer, Double percentageToBuy) {
        Investment investment = investmentRepository.findById(investmentId)
                .orElseThrow(() -> new RuntimeException("Investment not found"));
        if (investment.getSharePercentage() < percentageToBuy) {
            throw new RuntimeException("Not enough shares to buy");
        }
        investment.setSharePercentage(investment.getSharePercentage() - percentageToBuy);

        Investment newInvestment = new Investment();
        newInvestment.setCampaign(investment.getCampaign());
        newInvestment.setInvestor(buyer);
        newInvestment.setAmount(percentageToBuy * investment.getAmount() / investment.getSharePercentage());
        newInvestment.setSharePercentage(percentageToBuy);

        investmentRepository.save(investment);
        return investmentRepository.save(newInvestment);
    }
}
