package br.com.rafael.user_service_api.servicies;

import br.com.rafael.user_service_api.controllers.exceptios.StandardError;
import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.mapper.UserMapper;
import br.com.rafael.user_service_api.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import models.exceptions.ResourceNotFoundException;
import models.requests.CreateUserRequest;
import models.requests.UpdateUserRequest;
import models.responses.UserResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    public UserResponse findById(final  String id){
        return  userMapper.fromEntity(
                userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                        "Object not found. Id: " + id + ", Type: " + UserResponse.class.getSimpleName()
                )));
    }

    public void save(CreateUserRequest createUserRequest) {

    verifyIfEmailAlreadyExists(createUserRequest.email(),null);
    userRepository.save(
            userMapper.fromRequest(createUserRequest)
                    .withPassword(encoder.encode(createUserRequest.password()))
    );

    }


    public List<UserResponse> findAll(){
        return userRepository.findAll()
                .stream().map(user -> userMapper.fromEntity(user))
                .collect(Collectors.toList());
    }


    public UserResponse update(final String id,final UpdateUserRequest updateUserRequest) {
        User entity =    find(id);
        verifyIfEmailAlreadyExists(updateUserRequest.email(),id);
        final var newEntity =  userRepository.save( userMapper.update(updateUserRequest,entity)
                .withPassword(updateUserRequest.password() != null ? encoder.encode(updateUserRequest.password()) : entity.getPassword() )
        );
        return userMapper.fromEntity(newEntity);
    }


    private void verifyIfEmailAlreadyExists(final String email,final String id){

        userRepository.findByEmail(email).filter(user -> !user.getId().equals(id))
                .ifPresent(user -> {
                    throw new DataIntegrityViolationException("E-mail ["+  email +"] already exists");
                });

    }

    private User find(final  String id){
        return
                userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                        "Object not found. Id: " + id + ", Type: " + UserResponse.class.getSimpleName()
                ));
    }


}
