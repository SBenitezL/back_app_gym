package com.moviles.personal.trainer.domain.userCases;

import java.util.List;

import com.moviles.personal.trainer.application.input.ManegeExerciseCUIntPort;
import com.moviles.personal.trainer.application.output.ExceptionFormatterIntPort;
import com.moviles.personal.trainer.application.output.ManegeExerciseGatewayIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.domain.models.Routine;

public class ManegeExerciseCUImpImplAdapter implements ManegeExerciseCUIntPort {
    private final ManegeExerciseGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManegeExerciseCUImpImplAdapter(ManegeExerciseGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Exercise> getAll() {
        List<Exercise> exercises = this.gateway.findAll();
        if (exercises.isEmpty())
            this.exceptionFormatter.returNoData("Not exist routines in the system");
        return exercises;
    }

}
