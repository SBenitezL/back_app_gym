package com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.mapppers;

import java.util.List;

import org.mapstruct.Mapper;

import com.moviles.personal.trainer.domain.models.Muscle;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTORequest.MuscleDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.DTOResponse.MuscleDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperMuscleInfraestructureDomain {
    Muscle mapperRequestToModel(MuscleDTORequest request);

    MuscleDTOResponse mapperModelToResponse(Muscle model);

    List<MuscleDTOResponse> mapperModelsToResponses(List<Muscle> models);

    List<Muscle> mapperRequestsToModel(List<MuscleDTORequest> requests);
}
