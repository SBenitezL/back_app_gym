package com.moviles.personal.trainer.infraestructure.output.persistence.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.moviles.personal.trainer.application.output.ManegeExerciseGatewayIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.infraestructure.output.persistence.entities.ExerciseEntity;
import com.moviles.personal.trainer.infraestructure.output.persistence.repositories.ExerciseRepository;

@Service
public class ManegeExerciseGatewayImplAdapter implements ManegeExerciseGatewayIntPort {

    private final ExerciseRepository serviceDB;
    private final ModelMapper mapper;

    public ManegeExerciseGatewayImplAdapter(ExerciseRepository serviceDB, ModelMapper mapper) {
        this.serviceDB = serviceDB;
        this.mapper = mapper;
    }

    @Override
    public List<Exercise> findAll() {
        Iterable<ExerciseEntity> entities = serviceDB.findAll();
        return this.mapper.map(entities, new TypeToken<List<Exercise>>() {
        }.getType());

    }

}
