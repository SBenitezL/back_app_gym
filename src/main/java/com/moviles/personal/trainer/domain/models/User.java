package com.moviles.personal.trainer.domain.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private long userId;
    private String userNames;
    private String userLastNames;
    private int serAge;
    private Double userHeight;
    private Double userWeight;
    private String userEmail;
    private String userName;
    private String userPassword;
    private List<Routine> routines;

    public User() {
    }

    public void update(User user) {
        this.userNames = user.userNames;
        this.userLastNames = user.userLastNames;
        this.serAge = user.serAge;
        this.userHeight = user.userHeight;
        this.userWeight = user.userWeight;
        this.userEmail = user.userEmail;
        this.userName = user.userName;
        this.userPassword = user.userPassword;
        this.routines = user.routines;
    }

}
