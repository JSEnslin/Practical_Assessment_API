package com.TechA.TA.Applicant.service;

import com.TechA.TA.Applicant.model.Applicant;
import com.TechA.TA.Users.model.Users;

import java.util.List;

public interface ApplicantService {
    Applicant saveApplicant(Applicant applicant);
    List<Applicant> getAllApplicant();
    Applicant getApplicantById(long id);
    Applicant updateApplicant(Applicant applicant,long id);
    void deleteApplicant(long id);
}

