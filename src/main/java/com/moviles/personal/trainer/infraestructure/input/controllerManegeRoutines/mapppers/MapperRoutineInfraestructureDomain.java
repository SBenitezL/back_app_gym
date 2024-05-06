package com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.mapppers;

import java.util.List;

import org.mapstruct.Mapper;

import com.moviles.personal.trainer.domain.models.Routine;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest.RoutineDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTOResponse.RoutineDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperRoutineInfraestructureDomain {

    Routine mapperRequestToModel(RoutineDTORequest request);

    RoutineDTOResponse mapperModelToResponse(Routine model);

    List<Routine> mapperRequestsToModels(List<RoutineDTORequest> requests);

    List<RoutineDTOResponse> mapperModelsToResponses(List<Routine> models);

}
