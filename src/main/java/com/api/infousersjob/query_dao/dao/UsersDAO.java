package com.api.infousersjob.query_dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.infousersjob.models.SalariesModel;
import com.api.infousersjob.models.UsersModel;
import com.api.infousersjob.query_dao.factory.ConnectionFactory;

@Service
public class UsersDAO {

    // Retorna todo los usuarios
    @Transactional(readOnly = true)
    public ArrayList<UsersModel> getUsers() throws SQLException {
        ArrayList<UsersModel> users = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection()) {
            final String QUERY = 
                   "SELECT u.id AS user_id, u.first_name, u.last_name, u.gender, u.address, u.city, u.phone, "
                 + "s.id AS salary_id, s.salary "
                 + "FROM users u "
                 + "INNER JOIN salaries s ON u.id = s.user_id ";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            try (statement) {
                statement.executeQuery();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        UsersModel user = new UsersModel();
                        user.setId(resultSet.getLong("user_id"));
                        user.setFirst_name(resultSet.getString("first_name"));
                        user.setLast_name(resultSet.getString("last_name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setAddress(resultSet.getString("address"));
                        user.setCity(resultSet.getString("city"));
                        user.setPhone(resultSet.getLong("phone"));

                        SalariesModel salary = new SalariesModel();
                        salary.setId(resultSet.getLong("salary_id"));
                        salary.setSalary(resultSet.getDouble("salary"));
                        
                        user.setSalary(salary);

                        users.add(user);
                    }
                }
            }
            return users;
        }
    }
}