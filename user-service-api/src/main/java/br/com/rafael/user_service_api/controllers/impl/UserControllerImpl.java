package br.com.rafael.user_service_api.controllers.impl;

import br.com.rafael.user_service_api.controllers.UserController;
import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.servicies.UserService;
import models.enums.ProfileEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserControllerImpl  implements UserController {


    @Autowired
    private  UserService userService;




    @Override
    public ResponseEntity<User> findById(String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }



}
