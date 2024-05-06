package com.moviles.personal.trainer.application.output;

import java.util.List;

import com.moviles.personal.trainer.domain.models.User;

public interface ManegeUserGatewayIntPort {

    public User login(String username, String pass);

    public User create(User user);

    public User update(User user);

    public User getById(long id);

    public List<User> getAll();

    public boolean existsById(long id);

    public boolean exist(String username, String pass);

    public boolean existsByUsername(String username);
}
