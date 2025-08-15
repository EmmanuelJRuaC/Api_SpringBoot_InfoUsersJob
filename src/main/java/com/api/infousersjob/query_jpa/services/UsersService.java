
package com.api.infousersjob.query_jpa.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.infousersjob.models.UsersModel;
import com.api.infousersjob.query_jpa.repository.IUsersRepository;

@Service
public class UsersService {
    
    private final IUsersRepository usersRepository;

    public UsersService(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public ArrayList<UsersModel> getUsers() {
        return usersRepository.getUsers();
    }
}