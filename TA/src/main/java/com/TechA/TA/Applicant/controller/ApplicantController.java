package com.TechA.TA.Applicant.controller;

import com.TechA.TA.Applicant.model.Applicant;
import com.TechA.TA.Applicant.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//http://localhost:8080/api/applicant

    @RestController
    @RequestMapping("/api/applicant")
    public class ApplicantController {

        private ApplicantService applicantService;


        public ApplicantController(ApplicantService applicantService) {
            super();
            this.applicantService = applicantService;
        }

        //create applicant REST API
        //http://localhost:8080/api/applicant
        @PostMapping
        public ResponseEntity<Applicant> saveApplicant(@RequestBody Applicant applicant) {
            return new ResponseEntity<Applicant>(applicantService.saveApplicant(applicant), HttpStatus.CREATED);

        }
        //create  get all applicant REST API
        //http://localhost:8080/api/applicant
        @GetMapping
        public List<Applicant> getAllApplicant() {
            return applicantService.getAllApplicant();

        }

        //get applicant by ID REST API
        //http://localhost:8080/api/applicant/1
        @GetMapping("{id}")
        public ResponseEntity<Applicant> getApplicantById(@PathVariable("id") long applicant_id) {
            return new ResponseEntity<Applicant>(applicantService.getApplicantById(applicant_id), HttpStatus.OK);
        }

        //update applicant REST API
        //http://localhost:8080/api/applicant/1
        @PutMapping("{id}")
        public ResponseEntity<Applicant> updateApplicant(@PathVariable("id") long applicant_id
                ,@RequestBody Applicant applicant){
            return  new ResponseEntity<Applicant>(applicantService.updateApplicant(applicant,applicant_id), HttpStatus.OK);

        }
        //delete applicant REST API
        //http://localhost:8080/api/applicant/1
        @DeleteMapping("{id}")
        public  ResponseEntity<String> deleteApplicant(@PathVariable("id") long applicant_id){
            applicantService.deleteApplicant(applicant_id);

            return  new ResponseEntity<String>("Applicant deleted successfully!", HttpStatus.OK);

        }

    }
