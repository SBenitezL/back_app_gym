package com.moviles.personal.trainer.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moviles.personal.trainer.application.output.ExceptionFormatterIntPort;
import com.moviles.personal.trainer.application.output.ManegeExerciseGatewayIntPort;
import com.moviles.personal.trainer.application.output.ManegeRoutineGatewayIntPort;
import com.moviles.personal.trainer.application.output.ManegeUserGatewayIntPort;
import com.moviles.personal.trainer.domain.userCases.ManegeExerciseCUImpImplAdapter;
import com.moviles.personal.trainer.domain.userCases.ManegeRoutineCUImplAdapter;
import com.moviles.personal.trainer.domain.userCases.ManegeUserCUImplAdapter;

@Configuration
public class BeanConfigurations {
    @Bean
    public ManegeUserCUImplAdapter createUserCu(ManegeUserGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManegeUserCUImplAdapter userCU = new ManegeUserCUImplAdapter(gateway, exceptionFormatter);
        return userCU;
    }

    @Bean
    public ManegeRoutineCUImplAdapter createRoutineCu(ManegeRoutineGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManegeRoutineCUImplAdapter routineCU = new ManegeRoutineCUImplAdapter(gateway, exceptionFormatter);
        return routineCU;
    }

    @Bean
    public ManegeExerciseCUImpImplAdapter createExerciseCu(ManegeExerciseGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        ManegeExerciseCUImpImplAdapter exerciseCU = new ManegeExerciseCUImpImplAdapter(gateway, exceptionFormatter);
        return exerciseCU;
    }

}
