package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAccount;
    Long accountNumber;
    Float balance;
    String openingDate;

    @OneToOne
    AccountApplication accountApplication;

    @OneToMany(mappedBy = "accounts")
    Set <Transaction> transactions;
}
