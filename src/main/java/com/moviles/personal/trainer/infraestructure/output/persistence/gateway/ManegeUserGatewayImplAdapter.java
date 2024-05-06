package com.moviles.personal.trainer.infraestructure.output.persistence.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.moviles.personal.trainer.application.output.ManegeUserGatewayIntPort;
import com.moviles.personal.trainer.domain.models.Routine;
import com.moviles.personal.trainer.domain.models.User;
import com.moviles.personal.trainer.infraestructure.output.persistence.entities.RoutineEntity;
import com.moviles.personal.trainer.infraestructure.output.persistence.entities.UserEntity;
import com.moviles.personal.trainer.infraestructure.output.persistence.repositories.UserRepository;

@Service
public class ManegeUserGatewayImplAdapter implements ManegeUserGatewayIntPort {

    private final UserRepository serviceDB;
    private final ModelMapper mapper;

    public ManegeUserGatewayImplAdapter(UserRepository serviceDB, ModelMapper mapper) {
        this.serviceDB = serviceDB;
        this.mapper = mapper;
    }

    @Override
    public User login(String username, String pass) {
        UserEntity entity = this.serviceDB.findByUserNameAndUserPassword(username, pass);
        return this.mapper.map(entity, User.class);
    }

    @Override
    public User create(User user) {
        UserEntity entity = this.mapper.map(user, UserEntity.class);
        UserEntity save = this.serviceDB.save(entity);
        return this.mapper.map(save, User.class);
    }

    @Override
    public User update(User user) {
        UserEntity entity = this.mapper.map(user, UserEntity.class);
        UserEntity save = this.serviceDB.save(entity);
        return this.mapper.map(save, User.class);
    }

    @Override
    public User getById(long id) {
        UserEntity entity = this.serviceDB.findById(id).get();
        return this.mapper.map(entity, User.class);
    }

    @Override
    public List<User> getAll() {
        Iterable<UserEntity> entities = this.serviceDB.findAll();
        return this.mapper.map(entities, new TypeToken<List<User>>() {
        }.getType());
    }

    @Override
    public boolean existsById(long id) {
        return this.serviceDB.existsById(id);
    }

    @Override
    public boolean exist(String username, String pass) {
        return this.serviceDB.existsByUserNameAndUserPassword(username, pass);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.serviceDB.existsByUserName(username);
    }
}