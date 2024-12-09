package br.com.rafael.user_service_api.controllers;


import br.com.rafael.user_service_api.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/users")
public interface UserController {

    @GetMapping("/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable(name = "idUS") String id);

}
