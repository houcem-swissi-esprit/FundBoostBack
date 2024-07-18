package com.example.projett.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    Set<Campaign> campaigns ;

    @JsonIgnore
    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    Set<Investment> investments ;

    @JsonIgnore
    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    Set<Donation> donations ;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<FundingTransaction> transactions ;
}


