package com.moviles.personal.trainer.application.output;

import java.util.List;

import com.moviles.personal.trainer.domain.models.Exercise;

public interface ManegeExerciseGatewayIntPort {
    public List<Exercise> findAll();
}
