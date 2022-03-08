package com.TechA.TA.JobListing.Service.ServiceImpl;

import com.TechA.TA.JobListing.Model.JobListings;
import com.TechA.TA.JobListing.Repo.JobListRepository;
import com.TechA.TA.JobListing.Service.JobListService;
import com.TechA.TA.Users.exception.ResourceNotFoundException;

import com.TechA.TA.Users.repository.UsersRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public class JobListServiceImpl implements JobListService {

    private JobListRepository jobListRepository;
    private UsersRepository usersRepository;

    public JobListServiceImpl(JobListRepository jobListRepository, UsersRepository usersRepository) {
        super();
        this.jobListRepository = jobListRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public JobListings saveJobListing(JobListings jobListings) {
        return jobListRepository.save(jobListings);

    }

    @Override
    public List<JobListings> getAllJobListing() {
        return jobListRepository.findAll();
    }

    @Override
    public JobListings getJobListingById(long id) {

        return jobListRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Job Listing", "Id", id));
    }

    @Override
    public JobListings updateJobListing(JobListings jobListings, long id) {

        //below will check if listing with given Id exists in DB
        JobListings existingJobListing = jobListRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Job Listing","Id", id));


        //update existing listing
        existingJobListing.setListing_id(jobListings.getListing_id());
        existingJobListing.setJobTitle(jobListings.getJobTitle());
        existingJobListing.setEmployerName(jobListings.getEmployerName());
        existingJobListing.setStatus(jobListings.getStatus());
        existingJobListing.setVacancies(jobListings.getVacancies());
        existingJobListing.setStartDate(jobListings.getStartDate());
        existingJobListing.setApplication_id(jobListings.getApplication_id());

        //save updated data
        jobListRepository.save(existingJobListing);
        return existingJobListing;
    }

    @Override
    public void deleteJobListing(long id) {
        //first check if listing exists in DB
       jobListRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Job Listing","Id",id));

        //delete listing data using Id
        jobListRepository.deleteById(id);
    }

    }

