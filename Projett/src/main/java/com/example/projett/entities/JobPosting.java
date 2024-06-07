package com.example.projett.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class JobPosting implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idJob;
    String jobTitle;
    String skillsRequired;
    String experienceRequired;
    String educationRequired;
    String salaryRanged;

    @OneToMany(mappedBy = "jobPosting")
    Set<JobApplication> jobApplications;
}
