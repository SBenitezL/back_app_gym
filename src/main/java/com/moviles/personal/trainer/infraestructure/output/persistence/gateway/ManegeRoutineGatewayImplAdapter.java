package com.moviles.personal.trainer.infraestructure.output.persistence.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.moviles.personal.trainer.application.output.ManegeExerciseGatewayIntPort;
import com.moviles.personal.trainer.application.output.ManegeRoutineGatewayIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.domain.models.Routine;
import com.moviles.personal.trainer.infraestructure.output.persistence.entities.ExerciseEntity;
import com.moviles.personal.trainer.infraestructure.output.persistence.entities.RoutineEntity;
import com.moviles.personal.trainer.infraestructure.output.persistence.repositories.RoutineRepository;

@Service
public class ManegeRoutineGatewayImplAdapter implements ManegeRoutineGatewayIntPort {

    private final RoutineRepository serviceDB;
    private final ModelMapper mapper;

    public ManegeRoutineGatewayImplAdapter(RoutineRepository serviceDB, ModelMapper mapper) {
        this.serviceDB = serviceDB;
        this.mapper = mapper;
    }

    @Override
    public List<Routine> findAll() {
        Iterable<RoutineEntity> entities = this.serviceDB.findAll();
        return this.mapper.map(entities, new TypeToken<List<Routine>>() {
        }.getType());
    }

    @Override
    public Routine create(Routine routine) {
        RoutineEntity entity = this.mapper.map(routine, RoutineEntity.class);
        RoutineEntity save = this.serviceDB.save(entity);
        return this.mapper.map(save, Routine.class);
    }

    @Override
    public Routine update(Routine routine) {
        RoutineEntity entity = this.mapper.map(routine, RoutineEntity.class);
        RoutineEntity save = this.serviceDB.save(entity);
        return this.mapper.map(save, Routine.class);
    }

}
