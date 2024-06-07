package com.example.projett.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Dividends implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idDividend;
    Float dividendAmount;
    LocalDate dividendDate;
    @Enumerated(EnumType.STRING)
    DividendType dividendType;

    @ManyToOne
    Shares shares;
}
