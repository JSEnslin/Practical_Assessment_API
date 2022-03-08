package com.TechA.TA.JobListing.Repo;

import com.TechA.TA.JobListing.Model.JobListings;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JobListRepository extends JpaRepository<JobListings,Long> {


}

