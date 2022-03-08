package com.TechA.TA.JobListing.Service;

import com.TechA.TA.JobListing.Model.JobListings;


import java.util.List;

public interface JobListService {
    JobListings saveJobListing(JobListings jobListing);
    List<JobListings> getAllJobListing();
    JobListings getJobListingById(long id);
    JobListings updateJobListing(JobListings jobListing,long id);
    void deleteJobListing(long listing_id);
}

