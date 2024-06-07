package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinancePack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPack;
    String packName;
    String packDescription;
    String eligibilityCriteria ;
    String packDocs;
    String treatmentTime;
    Float varPercentage;
    Float expectedReturn;
    Long demandNumber;

    @OneToMany(mappedBy = "financePack" ,cascade = CascadeType.ALL)
    Set<Allowance> allowances ;

}
