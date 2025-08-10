package com.api.infousersjob;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
public class InfoUsersJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoUsersJobApplication.class, args);
	}

	// Redireccionamiento al controlador "UsersControllers"
	@RequestMapping("/")
	public void redirigir(HttpServletResponse response) throws IOException {
		response.sendRedirect("/users/getusers");
	}
}
