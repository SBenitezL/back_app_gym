package com.moviles.personal.trainer.domain.userCases;

import java.util.List;

import com.moviles.personal.trainer.application.input.ManegeExerciseCUIntPort;
import com.moviles.personal.trainer.application.input.ManegeRoutineCUIntPort;
import com.moviles.personal.trainer.application.output.ExceptionFormatterIntPort;
import com.moviles.personal.trainer.application.output.ManegeRoutineGatewayIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.domain.models.Routine;

public class ManegeRoutineCUImplAdapter implements ManegeRoutineCUIntPort {

    private final ManegeRoutineGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManegeRoutineCUImplAdapter(ManegeRoutineGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Routine> getAll() {
        List<Routine> routines = this.gateway.findAll();
        if (routines.isEmpty())
            this.exceptionFormatter.returNoData("Not exist routines in the system");
        return routines;
    }

    @Override
    public Routine create(Routine routine) {
        return this.gateway.create(routine);
    }

    @Override
    public Routine update(Routine routine) {
        return this.gateway.update(routine);
    }

}
