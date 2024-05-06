package com.moviles.personal.trainer.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Muscle {
    private long muscleId;
    private String muscleName;

    public Muscle() {

    }
}
