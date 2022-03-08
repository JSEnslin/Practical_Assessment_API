package com.TechA.TA.Users.repository;

import com.TechA.TA.Users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsersRepository extends JpaRepository<Users,Long> {
}
