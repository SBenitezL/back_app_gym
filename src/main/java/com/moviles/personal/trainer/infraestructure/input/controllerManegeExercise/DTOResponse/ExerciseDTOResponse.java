package com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTORequest.MuscleDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExerciseDTOResponse {
    private long exerciseId;
    private String exerciseName;
    private int exerciseIcon;
    private String exerciseDescription;
    private List<MuscleDTORequest> muscles;

    public ExerciseDTOResponse() {
        muscles = new ArrayList<MuscleDTORequest>();
    }
}
