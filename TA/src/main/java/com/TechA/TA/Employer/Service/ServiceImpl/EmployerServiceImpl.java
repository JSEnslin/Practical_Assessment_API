package com.TechA.TA.Employer.Service.ServiceImpl;

import com.TechA.TA.Employer.Model.Employer;
import com.TechA.TA.Employer.Repo.EmployerRepo;
import com.TechA.TA.Employer.Service.EmployerService;
import com.TechA.TA.Users.exception.ResourceNotFoundException;
import com.TechA.TA.Users.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerServiceImpl implements EmployerService {

    private EmployerRepo employerRepo;
    private   UsersRepository usersRepository;


    public EmployerServiceImpl(EmployerRepo employerRepo, UsersRepository usersRepository) {
        super();
        this.employerRepo = employerRepo;
        this.usersRepository = usersRepository;
    }

    public Employer saveEmployer(Employer employer) {
        return employerRepo.save(employer);

    }

    @Override
    public List<Employer> getAllEmployer() {
        return employerRepo.findAll();
    }

    @Override
    public Employer getEmployerById(long id) {

        return employerRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employer", "Id", id));
    }

    public Employer updateEmployer(Employer employer, long id) {

        //below will check if User with given Id exists in DB
       Employer existingEmployer = employerRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employer","Id", id));


        //update existing User
        existingEmployer.setEmployer_Id(employer.getEmployer_Id());
        //existingEmployer.setUserNameId(employer.getUserNameId());
        existingEmployer.setUserName(employer.getUserName());
        existingEmployer.setCompanyName(employer.getCompanyName());
        //save updated data
        employerRepo.save(existingEmployer);
        return existingEmployer;
    }

    @Override
    public void deleteEmployer(long id) {
        //first check if User exists in DB
        employerRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employer","Id",id));

        //delete users data using Id
        employerRepo.deleteById(id);
    }
}
