package com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTORequest.MuscleDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExerciseDTORequest {
    private long exerciseId;
    private String exerciseName;
    private int exerciseIcon;
    private String exerciseDescription;
    private List<MuscleDTORequest> muscles;

    public ExerciseDTORequest() {
        muscles = new ArrayList<MuscleDTORequest>();
    }
}
