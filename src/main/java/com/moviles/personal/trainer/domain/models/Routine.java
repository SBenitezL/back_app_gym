package com.moviles.personal.trainer.domain.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Routine {
    private long routineId;
    private String routineTitle;
    private int routineIcon;
    private List<Exercise> exercises;

    public Routine() {
        exercises = new ArrayList<Exercise>();
    }

    public void update(Routine routine) {
        this.routineTitle = routine.routineTitle;
        this.exercises = routine.exercises;
        this.routineIcon = routine.routineIcon;
    }
}
