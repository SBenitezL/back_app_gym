package com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.mapppers;

import java.util.List;

import org.mapstruct.Mapper;

import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTORequest.ExerciseDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTOResponse.ExerciseDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperExerciseInfraestructureDomain {
    Exercise mapRequestToModel(ExerciseDTORequest request);

    ExerciseDTOResponse mapModelToResponse(Exercise model);

    List<Exercise> mapRequestsToModels(List<ExerciseDTORequest> requests);

    List<ExerciseDTOResponse> mapModelsToResponses(List<Exercise> models);
}
