package com.TechA.TA.MapRepository;

import com.TechA.TA.Employer.Model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpUseIdRepo extends CrudRepository<Employer,Long> {
}
