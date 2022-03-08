package com.TechA.TA.Employer.Controller;


import com.TechA.TA.Employer.Model.Employer;
import com.TechA.TA.Employer.Service.EmployerService;
import com.TechA.TA.Users.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    //http://localhost:8080/api/employer

    @RestController
    @RequestMapping("/api/employer")
    public class EmployerController {

        private EmployerService employerService;
        private   UsersRepository usersRepository;

        public EmployerController(EmployerService employerService, UsersRepository usersRepository, UsersRepository usersRepository1) {
            super();
            this.employerService = employerService;

            this.usersRepository = usersRepository1;
        }

        //create employer REST API
        //http://localhost:8080/api/employer
        @PostMapping
        public ResponseEntity<Employer> saveEmployer(@RequestBody Employer employer) {
            return new ResponseEntity<Employer>(employerService.saveEmployer(employer), HttpStatus.CREATED);

        }
        //create  get all employer REST API
        //http://localhost:8080/api/employer
        @GetMapping
        public List<Employer> getAllEmployer() {
            return employerService.getAllEmployer();

        }

        //get employer by ID REST API
        //http://localhost:8080/api/employer/1
        @GetMapping("{id}")
        public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long employer_id) {
            return new ResponseEntity<Employer>(employerService.getEmployerById(employer_id), HttpStatus.OK);
        }

        //update employer REST API
        //http://localhost:8080/api/employer/1
        @PutMapping("{id}")
        public ResponseEntity<Employer> updateEmployer(@PathVariable("id") long employer_id
                ,@RequestBody Employer employer){
            return  new ResponseEntity<Employer>(employerService.updateEmployer(employer, employer_id), HttpStatus.OK);

        }
        //delete employer REST API
        //http://localhost:8080/api/employer/1
        @DeleteMapping("{id}")
        public  ResponseEntity<String> deleteEmployer(@PathVariable("id") long employer_id){
            employerService.deleteEmployer(employer_id);

            return  new ResponseEntity<String>("Applicant deleted successfully!", HttpStatus.OK);

        }

    }
