package com.moviles.personal.trainer.application.input;

import java.util.List;

import com.moviles.personal.trainer.domain.models.Routine;

public interface ManegeRoutineCUIntPort {
    public List<Routine> getAll();

    public Routine create(Routine routine);

    public Routine update(Routine routine);

}
