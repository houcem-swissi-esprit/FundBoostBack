package com.example.projett.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FundingTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull User user;

    @NonNull Double amount;
    @NonNull Date date;
}
