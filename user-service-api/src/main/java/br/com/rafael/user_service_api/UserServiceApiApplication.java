package br.com.rafael.user_service_api;

import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.repositories.UserRepository;
import models.enums.ProfileEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Set;

@SpringBootApplication
public class UserServiceApiApplication {


	@Autowired
	private UserRepository userRepository;



	public static void main(String[] args) {
		SpringApplication.run(UserServiceApiApplication.class, args);
	}

}
