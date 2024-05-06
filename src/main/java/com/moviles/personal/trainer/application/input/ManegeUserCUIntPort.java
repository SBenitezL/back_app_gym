package com.moviles.personal.trainer.application.input;

import java.util.List;

import com.moviles.personal.trainer.domain.models.User;

public interface ManegeUserCUIntPort {
    public User login(String username, String pass);

    public User create(User user);

    public User update(User user);

    public List<User> getAll();
}
