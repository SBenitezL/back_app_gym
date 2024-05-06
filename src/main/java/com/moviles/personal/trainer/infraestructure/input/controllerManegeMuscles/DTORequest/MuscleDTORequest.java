package com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MuscleDTORequest {
    private long muscleId;
    private String muscleName;

    public MuscleDTORequest() {

    }
}
