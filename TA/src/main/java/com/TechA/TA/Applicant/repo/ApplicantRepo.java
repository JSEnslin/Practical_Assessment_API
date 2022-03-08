package com.TechA.TA.Applicant.repo;

import com.TechA.TA.Applicant.model.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepo extends JpaRepository<Applicant,Long> {
}
