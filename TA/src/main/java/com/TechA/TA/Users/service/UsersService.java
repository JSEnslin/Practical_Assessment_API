package com.TechA.TA.Users.service;

import com.TechA.TA.Users.model.Users;

import java.util.List;

public interface UsersService {
    Users saveUsers(Users users);
    List<Users>getAllUsers();
    Users getUsersById(long id);
    Users updateUsers(Users users,long id);
    void deleteUsers(long id);
}



