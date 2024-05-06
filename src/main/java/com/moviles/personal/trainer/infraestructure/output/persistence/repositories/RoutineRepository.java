package com.moviles.personal.trainer.infraestructure.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moviles.personal.trainer.infraestructure.output.persistence.entities.RoutineEntity;

public interface RoutineRepository extends CrudRepository<RoutineEntity, Long> {

}
