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
public class Shares implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idShares;
    Float sharePrice;
    String shareDescription;

    @ManyToOne
    Investiment investiments;

    @OneToMany(mappedBy = "shares")
    Set<Dividends> dividends;
}
