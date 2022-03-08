package com.TechA.TA.MapRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantIdRepo extends CrudRepository<ApplicantIdRepo,Long> {
}
