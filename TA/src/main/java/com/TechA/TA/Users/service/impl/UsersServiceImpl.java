package com.TechA.TA.Users.service.impl;


import com.TechA.TA.Applicant.repo.ApplicantRepo;
import com.TechA.TA.Employer.Repo.EmployerRepo;
import com.TechA.TA.JobListing.Repo.JobListRepository;
import com.TechA.TA.Users.repository.UsersRepository;
import com.TechA.TA.Users.exception.ResourceNotFoundException;
import com.TechA.TA.Users.model.Users;
import com.TechA.TA.Users.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

//create and save users
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private EmployerRepo employerRepo;
    private ApplicantRepo applicantRepo;
    private JobListRepository jobListRepository;


    public UsersServiceImpl(UsersRepository usersRepository, EmployerRepo employerRepo, ApplicantRepo applicantRepo, JobListRepository jobListRepository) {
        super();
        this.usersRepository = usersRepository;
        this.employerRepo = employerRepo;
        this.applicantRepo = applicantRepo;
        this.jobListRepository = jobListRepository;
    }

    @Override
    public Users saveUsers(Users users) {
            return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUsersById(long id) {

        return usersRepository.findById(id).orElseThrow(() ->
             new ResourceNotFoundException("Users", "Id", id));
    }

    @Override
    public Users updateUsers(Users users, long id) {

        //below will check if User with given Id exists in DB
        Users existingUsers = usersRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Users","Id", id));


        //update existing User
        existingUsers.setUserName_Id(users.getUserName_Id());
        existingUsers.setUserName(users.getUserName());
        existingUsers.setFirstName(users.getFirstName());
        existingUsers.setLastName(users.getLastName());
        existingUsers.setEmail(users.getEmail());
        existingUsers.setContactNumber(users.getContactNumber());

        //save updated data
        usersRepository.save(existingUsers);
        return existingUsers;
    }

    @Override
    public void deleteUsers(long id) {
        //first check if User exists in DB
        usersRepository.findById(id).orElseThrow(() ->
                                new ResourceNotFoundException("Users","Id",id));

        //delete users data using Id
        usersRepository.deleteById(id);
    }
}
