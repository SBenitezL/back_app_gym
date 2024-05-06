package com.moviles.personal.trainer.domain.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exercise {
    private long exerciseId;
    private String exerciseName;
    private int exerciseIcon;
    private String exerciseDescription;
    private List<Muscle> muscles;

    public Exercise() {
        muscles = new ArrayList<Muscle>();
    }
}
