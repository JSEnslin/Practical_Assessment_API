package com.TechA.TA.JobListing.controller;

import com.TechA.TA.JobListing.Model.JobListings;
import com.TechA.TA.JobListing.Service.JobListService;
import com.TechA.TA.Users.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/listing

@RestController
@RequestMapping("/api/listing")
public class JobListingController {

    private JobListService jobListingService;
    private UsersRepository usersRepository;

    public JobListingController(JobListService jobListingService, UsersRepository usersRepository) {
        super();
        this.jobListingService = jobListingService;
        this.usersRepository = usersRepository;
    }

    //create listing REST API
    //http://localhost:8080/api/listing
    @PostMapping
    public ResponseEntity<JobListings> saveJobListing(@RequestBody JobListings jobListing) {
        return new ResponseEntity<JobListings>(jobListingService.saveJobListing(jobListing), HttpStatus.CREATED);

    }
    //create  get all listing REST API
    //http://localhost:8080/api/listing
    @GetMapping
    public List<JobListings> getAllUsers() {
        return jobListingService.getAllJobListing();

    }

    //get listing by ID REST API
    //http://localhost:8080/api/listing/1
    @GetMapping("{id}")
    public ResponseEntity<JobListings> getJobListingById(@PathVariable("id") long listing_id) {
        return new ResponseEntity<JobListings>(jobListingService.getJobListingById(listing_id), HttpStatus.OK);
    }

    //update listing REST API
    //http://localhost:8080/api/listing/1
    @PutMapping("{id}")
    public ResponseEntity<JobListings> updateUsers(@PathVariable("id") long listing_id
            ,@RequestBody JobListings jobListings){
        return  new ResponseEntity<JobListings>(jobListingService.updateJobListing(jobListings,listing_id), HttpStatus.OK);

    }
    //delete listing REST API
    //http://localhost:8080/api/listing/1
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteJobListing(@PathVariable("id") long listing_id){
        jobListingService.deleteJobListing(listing_id);

        return  new ResponseEntity<String>("Listing deleted successfully!", HttpStatus.OK);

    }

}