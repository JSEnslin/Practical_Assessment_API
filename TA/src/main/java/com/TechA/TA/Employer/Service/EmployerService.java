package com.TechA.TA.Employer.Service;

import com.TechA.TA.Employer.Model.Employer;

import java.util.List;

public interface EmployerService {
    Employer saveEmployer(Employer employer);
    List<Employer> getAllEmployer();
    Employer getEmployerById(long id);
    Employer updateEmployer(Employer employer,long id);
    void deleteEmployer(long id);
}
