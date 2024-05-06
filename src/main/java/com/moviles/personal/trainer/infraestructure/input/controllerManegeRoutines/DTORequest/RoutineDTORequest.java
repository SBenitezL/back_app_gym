package com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTORequest.ExerciseDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineDTORequest {
    private long routineId;
    private String routineTitle;
    private int routineIcon;
    private List<ExerciseDTORequest> exercises;

    public RoutineDTORequest() {
        exercises = new ArrayList<ExerciseDTORequest>();
    }

}
