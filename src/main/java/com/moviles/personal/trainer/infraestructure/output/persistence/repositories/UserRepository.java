package com.moviles.personal.trainer.infraestructure.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviles.personal.trainer.infraestructure.output.persistence.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    boolean existsByUserNameAndUserPassword(String userName, String userPassword);

    UserEntity findByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserName(String userName);

}
