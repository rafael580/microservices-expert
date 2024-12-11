package br.com.rafael.user_service_api.servicies;

import br.com.rafael.user_service_api.entities.User;
import br.com.rafael.user_service_api.mapper.UserMapper;
import br.com.rafael.user_service_api.repositories.UserRepository;
import models.responses.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private BCryptPasswordEncoder encoder;

    @Test
    void whenCallFindByIdWithIdValidThenReturnUserResponse(){

        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(new User()));
        Mockito.when(mapper.fromEntity(any(User.class))).thenReturn( Mockito.mock(UserResponse.class));

        final var response = service.findById("1");

        Assertions.assertNotNull(response);
        Assertions.assertEquals(UserResponse.class, response.getClass());

        Mockito.verify(repository,Mockito.times(1)).findById(anyString());
        Mockito.verify(mapper, Mockito.times(1)).fromEntity(any(User.class));
    }

    @Test
    void whenCallFindByIdWithIdValidInvalidIdTHENtROWrESOURCEnOTfoundException(){

        Mockito.when(repository.findById(anyString())).thenReturn(Optional.empty());

        try{
            service.findById("1");
        }
        catch (Exception e){
            Assertions.assertEquals( "Object not found. Id: 1, Type: UserResponse" ,e.getMessage());
        }


    }


}