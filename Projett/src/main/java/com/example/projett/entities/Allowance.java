package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Allowance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAllowance;
    String allowanceName;
    String allowanceAmount;
    Long allowancePeriod;
    @ManyToOne
    FinancePack financePack;
    @OneToOne(mappedBy = "allowance" , cascade = CascadeType.ALL)
    Track tracks;



}
