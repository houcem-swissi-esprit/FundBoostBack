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
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_profile;
    String region;
    Long phone_number;
    String job;
    MaritalStatus maritalStatus;
    String first_name;
    String last_name;
    LocalDate birth_date;
    @Enumerated(EnumType.STRING)
    Gender gender;
}


