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
public class JobApplication implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idApplication;
    String cvListening;
    LocalDate applicationDate;
    @Enumerated(EnumType.STRING)
    ApplicationStatus applicationStatus;

    @ManyToOne
    JobPosting jobPosting;

}
