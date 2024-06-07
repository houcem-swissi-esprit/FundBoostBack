package com.example.projett.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    @NonNull Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    @NonNull User investor;

    @NonNull Double amount;
    @NonNull Double sharePercentage;
}
