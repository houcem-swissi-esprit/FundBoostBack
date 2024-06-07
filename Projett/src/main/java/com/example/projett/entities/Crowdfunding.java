package com.example.projett.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Crowdfunding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idCrowdfunding;
    String description;
    String title;
    Float raisedAmount;
    Date fundingDate;

    @ManyToOne
    AidApplication aidApplications;
}
