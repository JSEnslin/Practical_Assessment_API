package com.TechA.TA.JobListing.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "jobListing")
@NoArgsConstructor
public class JobListings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listing_id;

    @Column(name = "employer_name", nullable = false)
    private String employerName;

    @Column(name = "job_Title", nullable = false)
    private String jobTitle;

    @Column(name = "starting_date", nullable = false)
    private String startDate;

    @Column(name = "no_vacancies", nullable = false)
    private Integer vacancies;

    @Column(name = "submit_status",nullable = false)
    private Boolean status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long application_id;

    @GeneratedValue( strategy = GenerationType.AUTO)
   private long userName_Id;


}