package br.com.rafael.user_service_api.servicies;

import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public User findById(final  String id){
        return userRepository.findById(id).orElse(null);
    }

}
