package com.TechA.TA.Users.controller;

import com.TechA.TA.Users.model.Users;
import com.TechA.TA.Users.service.UsersService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/users

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UsersService usersService;


    public UsersController(UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    //create users REST API
    //http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
        return new ResponseEntity<Users>(usersService.saveUsers(users), HttpStatus.CREATED);

    }
    //create  get all users REST API
    //http://localhost:8080/api/users
    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();

    }

    //get user by ID REST API
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<Users> getUsersByID(@PathVariable("id") long userName_id) {
        return new ResponseEntity<Users>(usersService.getUsersById(userName_id), HttpStatus.OK);
    }

    //update user REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable("id") long user_name_id
                                            ,@RequestBody Users users){
        return  new ResponseEntity<Users>(usersService.updateUsers(users,user_name_id), HttpStatus.OK);

    }
    //delete user REST API
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteUsers(@PathVariable("id") long userName_id){
        usersService.deleteUsers(userName_id);

        return  new ResponseEntity<String>("Users deleted successfully!", HttpStatus.OK);

    }

}