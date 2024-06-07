package com.example.projett.controllers;

import com.example.projett.entities.Investment;
import com.example.projett.entities.User;
import com.example.projett.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investments")
public class InvestmentRestController {
    @Autowired
    private InvestmentService investmentService;

    @PostMapping("/invest")
    public ResponseEntity<Investment> investInCampaign(@RequestBody Investment investment) {
        Investment newInvestment = investmentService.investInCampaign(investment);
        return ResponseEntity.ok(newInvestment);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<Investment>> getInvestmentsByInvestor(@PathVariable Long investorId) {
        User investor = new User();
        investor.setIdUser(investorId);
        List<Investment> investments = investmentService.getInvestmentsByInvestor(investor);
        return ResponseEntity.ok(investments);
    }


    @PostMapping("/sell/{investmentId}")
    public ResponseEntity<Investment> sellShares(@PathVariable Long investmentId, @RequestParam Double percentageToSell) {
        Investment updatedInvestment = investmentService.sellShares(investmentId, percentageToSell);
        return ResponseEntity.ok(updatedInvestment);
    }

    @PostMapping("/buy/{investmentId}")
    public ResponseEntity<Investment> buyShares(@PathVariable Long investmentId, @RequestParam Long buyerId, @RequestParam Double percentageToBuy) {
        User buyer = new User();
        buyer.setIdUser(buyerId);
        Investment newInvestment = investmentService.buyShares(investmentId, buyer, percentageToBuy);
        return ResponseEntity.ok(newInvestment);
    }
}
