package com.api.infousersjob.query_jpa.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.infousersjob.models.UsersModel;

public interface IUsersRepository extends JpaRepository<UsersModel, Long> {

    // Retorna todo los usuarios
    @Query("SELECT u FROM UsersModel u INNER JOIN FETCH u.salary")
    ArrayList<UsersModel> getUsers();
}
