package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class AidApplication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idAid;
    String aidPurpose;
    Float desiredAmount;
    LocalDate aidDate;
    String proof;
    @Enumerated(EnumType.STRING)
    AidStatus aidStatus;
    @Enumerated(EnumType.STRING)
    CrowdfundingType crwodfundingType;

    @OneToMany(mappedBy = "aidApplications")
    Set<Crowdfunding> crowdfundings;


}
