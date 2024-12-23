package br.com.rafael.user_service_api.controllers.impl;

import br.com.rafael.user_service_api.controllers.UserController;
import br.com.rafael.user_service_api.servicies.UserService;
import lombok.RequiredArgsConstructor;
import models.requests.CreateUserRequest;
import models.requests.UpdateUserRequest;
import models.responses.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class UserControllerImpl  implements UserController {

    private final UserService userService;


    @Override
    public ResponseEntity<UserResponse> findById(String id) {

        return ResponseEntity.ok().body(userService.findById(id));

    }

    @Override
    public ResponseEntity<Void> saveUser(final CreateUserRequest createUserRequest) {
        userService.save(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAll() {
        return  ResponseEntity.ok().body( userService.findAll());
    }

    @Override
    public ResponseEntity<UserResponse> update(String id, UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok().body( userService.update(id,updateUserRequest));
    }


}
