package com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTORequest.ExerciseDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineDTOResponse {
    private long routineId;
    private String routineTitle;
    private int routineIcon;
    private List<ExerciseDTORequest> exercises;

    public RoutineDTOResponse() {
        exercises = new ArrayList<ExerciseDTORequest>();
    }

}
