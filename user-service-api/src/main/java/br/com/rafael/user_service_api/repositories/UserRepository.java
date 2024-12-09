package br.com.rafael.user_service_api.repositories;


import br.com.rafael.user_service_api.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {



}
