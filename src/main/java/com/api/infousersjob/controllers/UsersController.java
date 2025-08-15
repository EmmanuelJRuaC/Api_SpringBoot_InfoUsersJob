package com.api.infousersjob.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.infousersjob.models.UsersModel;
import com.api.infousersjob.query_dao.dao.UsersDAO;
import com.api.infousersjob.query_jpa.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private UsersService usersService;

    // =================
    // Metodos: GET
    // =================

    // Metodo para obtener toda la lista de usuarios (DAO)
    @GetMapping("/getusers/dao")
    public ResponseEntity<?> getUsers() throws SQLException {
        ArrayList<UsersModel> users = usersDAO.getUsers();

        if (users.isEmpty()) {
        return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(Map.of("Mensaje", "No se encontraron usuarios"));
        }

        return ResponseEntity.ok(users);
    }

    // Metodo para obtener toda la lista de usuarios (JPA)
    @GetMapping("/getusers/jpa")
    public ResponseEntity<?> getUsersjpa() throws SQLException {
        ArrayList<UsersModel> users = usersService.getUsers();

        if (users.isEmpty()) {
        return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(Map.of("Mensaje", "No se encontraron usuarios"));
        }

        return ResponseEntity.ok(users);
    }
}