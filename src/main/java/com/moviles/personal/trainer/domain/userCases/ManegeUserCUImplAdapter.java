package com.moviles.personal.trainer.domain.userCases;

import java.util.List;

import com.moviles.personal.trainer.application.input.ManegeUserCUIntPort;
import com.moviles.personal.trainer.application.output.ExceptionFormatterIntPort;
import com.moviles.personal.trainer.application.output.ManegeUserGatewayIntPort;
import com.moviles.personal.trainer.domain.models.User;

public class ManegeUserCUImplAdapter implements ManegeUserCUIntPort {

    private final ManegeUserGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatterIntPort;

    public ManegeUserCUImplAdapter(ManegeUserGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatterIntPort) {
        this.gateway = gateway;
        this.exceptionFormatterIntPort = exceptionFormatterIntPort;
    }

    @Override
    public User login(String username, String pass) {
        if (!this.gateway.exist(username, pass))
            this.exceptionFormatterIntPort.returnResponseErrorEntityNotFound("Incorrect credentials");
        return this.gateway.login(username, pass);
    }

    @Override
    public User create(User user) {
        if (this.gateway.existsByUsername(user.getUserName()))
            this.exceptionFormatterIntPort.returnResponseErrorEntityExists(
                    "All ready exists a user with username: \"" + user.getUserName() + "\"");
        return this.gateway.create(user);
    }

    @Override
    public User update(User user) {
        if (!this.gateway.existsById(user.getUserId()))
            this.exceptionFormatterIntPort.returnResponseErrorEntityNotFound(
                    "A user has not been registered with the id: " + user.getUserId());
        User oldUser = this.gateway.getById(user.getUserId());
        if (!oldUser.getUserName().equals(user.getUserName()))
            if (this.gateway.existsByUsername(user.getUserName()))
                this.exceptionFormatterIntPort.returnResponseErrorEntityExists(
                        "All ready exists a user with username: \"" + user.getUserName() + "\"");
        oldUser.update(user);
        return this.gateway.update(oldUser);
    }

    @Override
    public List<User> getAll() {
        List<User> users = this.gateway.getAll();
        if (users.isEmpty())
            this.exceptionFormatterIntPort.returnResponseErrorEntityNotFound("There are no registered users");
        return users;
    }

}
