package br.com.rafael.user_service_api.entities;

import models.enums.ProfileEnum;

import java.util.Set;



public class User {


    private  String id;
    private String name;
    private String email;
    private String password;
    private Set<ProfileEnum> profie;


}
