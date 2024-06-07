package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDetails;
    String coverageConditions;
    @Enumerated(EnumType.STRING)
    CoverageType coverageType;
    @Enumerated(EnumType.STRING)
    CoverageNeeds coverageNeeds;
    Long durationStay ;
    String destination;
    String coveragePeriod;
    Float vehiculeValue;
    String circulationDate;
    Long accidentNumber;
    @Enumerated(EnumType.STRING)
    Power power ;
    String driversLicense;
    Boolean chronicIllnesses;
    Boolean tobacooUser;
    @Enumerated(EnumType.STRING)
    Diet diet;
    String prescription;
    String legalBName;
    String startupLabel;
    Boolean hriskActivity;
    Float businessEstimatedV;
    Float surface;
    Float argactivityIncome;
    @OneToOne
    Insurancepack insurancepack;



}
