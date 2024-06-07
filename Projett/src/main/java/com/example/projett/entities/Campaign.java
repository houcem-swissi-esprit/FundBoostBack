package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    Double targetAmount;
    Double currentAmount;
    Date startDate;
    Date endDate;

    @Enumerated(EnumType.STRING)
    CampaignStatus status;

    @Enumerated(EnumType.STRING)
    FundingType fundingType;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    User creator;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<Investment> investments;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<Donation> donations;

}
