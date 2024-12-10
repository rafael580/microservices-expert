package br.com.rafael.user_service_api.servicies;

import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.mapper.UserMapper;
import br.com.rafael.user_service_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import models.responses.UserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserResponse findById(final  String id){
        return  userMapper.fromEntity( userRepository.findById(id).orElse(null));
    }

}
