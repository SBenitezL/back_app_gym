package com.moviles.personal.trainer.application.input;

import java.util.List;

import com.moviles.personal.trainer.domain.models.Exercise;

public interface ManegeExerciseCUIntPort {

    public List<Exercise> getAll();
}
