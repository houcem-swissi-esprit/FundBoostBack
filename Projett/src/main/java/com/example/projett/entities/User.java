package com.example.projett.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class User implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idUser;
    String email;
    String password;
    Role role ;
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    Set<Campaign> campaigns ;

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    Set<Investment> investments ;

    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    Set<Donation> donations ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<FundingTransaction> transactions ;
}


