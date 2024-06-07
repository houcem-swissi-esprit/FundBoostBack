package com.example.projett.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Investiment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idInvestiment;
    Long sharesNumber;
    Float invistementAmount;
    LocalDate invistementDate;

    @OneToMany(mappedBy = "investiments")
    Set<Shares> shares;
}
