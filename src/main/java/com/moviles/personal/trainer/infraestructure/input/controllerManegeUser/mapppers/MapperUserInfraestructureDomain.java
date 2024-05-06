package com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.mapppers;

import java.util.List;

import org.mapstruct.Mapper;

import com.moviles.personal.trainer.domain.models.User;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTORequest.UserDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTOResponse.UserDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperUserInfraestructureDomain {

    User mapperRequestToModel(UserDTORequest request);

    UserDTOResponse mapperModelToResponse(User model);

    List<User> mapperRequestsToModels(List<UserDTORequest> requests);

    List<UserDTOResponse> mapperModelsToResponses(List<User> models);

}
