package com.TechA.TA.Applicant.service.serviceImpl;

import com.TechA.TA.Applicant.model.Applicant;
import com.TechA.TA.Applicant.repo.ApplicantRepo;
import com.TechA.TA.Applicant.service.ApplicantService;
import com.TechA.TA.Users.exception.ResourceNotFoundException;

import com.TechA.TA.Users.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private ApplicantRepo applicantRepo;
    private   UsersRepository usersRepository;

        public ApplicantServiceImpl(ApplicantRepo applicantRepo, UsersRepository usersRepository) {
            super();
            this.applicantRepo = applicantRepo;
            this.usersRepository = usersRepository;
        }

        public Applicant saveApplicant(Applicant applicant) {
            return applicantRepo.save(applicant);

        }

        @Override
        public List<Applicant> getAllApplicant() {
            return applicantRepo.findAll();
        }

        @Override
        public Applicant getApplicantById(long id) {

            return applicantRepo.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Applicant", "Id", id));
        }

        public Applicant updateApplicant(Applicant applicant, long id) {

            //below will check if Applicant with given Id exists in DB
            Applicant existingApplicant = applicantRepo.findById(id).orElseThrow(
                    ()-> new ResourceNotFoundException("Applicant","Id", id));


            //update existing Applicant
            existingApplicant.setApplicant_Id(applicant.getApplicant_Id());
            existingApplicant.setUserName_Id(applicant.getUserName_Id());
            existingApplicant.setUserName(applicant.getUserName());

            //save updated data
            applicantRepo.save(existingApplicant);
            return existingApplicant;
        }

        @Override
        public void deleteApplicant(long id) {
            //first check if Applicant exists in DB
            applicantRepo.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Applicant","Id",id));

            //delete Applicant data using Id
           applicantRepo.deleteById(id);
        }
    }


