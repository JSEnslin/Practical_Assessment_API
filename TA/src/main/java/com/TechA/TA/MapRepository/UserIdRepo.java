package com.TechA.TA.MapRepository;

import com.TechA.TA.Users.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdRepo extends CrudRepository <Users, Long> {
}
