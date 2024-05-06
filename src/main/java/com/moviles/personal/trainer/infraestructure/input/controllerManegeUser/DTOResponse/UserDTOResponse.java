package com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest.RoutineDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTOResponse {

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

    public UserDTOResponse() {
        this.routines = new ArrayList<>();
    }

}
