package com.moviles.personal.trainer.application.output;

import java.util.List;

import com.moviles.personal.trainer.domain.models.Routine;

public interface ManegeRoutineGatewayIntPort {
    public List<Routine> findAll();

    public Routine create(Routine routine);

    public Routine update(Routine routine);

}
