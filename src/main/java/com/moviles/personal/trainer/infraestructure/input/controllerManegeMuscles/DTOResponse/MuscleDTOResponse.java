package com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MuscleDTOResponse {
    private long muscleId;
    private String muscleName;

    public MuscleDTOResponse() {

    }
}
