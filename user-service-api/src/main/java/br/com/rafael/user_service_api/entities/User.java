package br.com.rafael.user_service_api.entities;

import lombok.*;
import models.enums.ProfileEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private  String id;
    private String name;
    private String email;
    private String password;
    private Set<ProfileEnum> profile;


}
