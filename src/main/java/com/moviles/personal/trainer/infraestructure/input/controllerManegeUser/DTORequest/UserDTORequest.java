package com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest.RoutineDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTORequest {

    private long userId;
    private String userNames;
    private String userLastNames;
    private int serAge;
    private Double userHeight;
    private Double userWeight;
    private String userEmail;
    private String userName;
    private String userPassword;
    private List<RoutineDTORequest> routines;

    public UserDTORequest() {
        this.routines = new ArrayList<>();
    }

}
