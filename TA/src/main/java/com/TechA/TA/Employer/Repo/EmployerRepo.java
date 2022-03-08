package com.TechA.TA.Employer.Repo;

import com.TechA.TA.Employer.Model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer,Long> {
}
