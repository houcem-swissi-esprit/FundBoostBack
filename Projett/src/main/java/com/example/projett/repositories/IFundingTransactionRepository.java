package com.example.projett.repositories;

import com.example.projett.entities.FundingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFundingTransactionRepository extends JpaRepository<FundingTransaction, Long> {
}