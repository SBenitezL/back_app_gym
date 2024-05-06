package com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.personal.trainer.application.input.ManegeUserCUIntPort;
import com.moviles.personal.trainer.domain.models.Routine;
import com.moviles.personal.trainer.domain.models.User;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeMuscles.mapppers.MapperMuscleInfraestructureDomain;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest.RoutineDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTOResponse.RoutineDTOResponse;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTORequest.CredentialsDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTORequest.UserDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.DTOResponse.UserDTOResponse;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeUser.mapppers.MapperUserInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Valid
public class UserRestController {
    private final ManegeUserCUIntPort userCu;
    private final MapperUserInfraestructureDomain mapper;

    @GetMapping("/")
    public ResponseEntity<List<UserDTOResponse>> getAll() {
        List<User> users = this.userCu.getAll();
        ResponseEntity<List<UserDTOResponse>> objResponse = new ResponseEntity<>(
                mapper.mapperModelsToResponses(users), HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody UserDTORequest request, BindingResult result) {
        User user = this.mapper.mapperRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            UserDTOResponse objResponse = this.mapper.mapperModelToResponse(this.userCu.create(user));
            return new ResponseEntity<UserDTOResponse>(objResponse, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody UserDTORequest request, BindingResult result) {
        User user = this.mapper.mapperRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            UserDTOResponse objResponse = this.mapper.mapperModelToResponse(this.userCu.update(user));
            return new ResponseEntity<UserDTOResponse>(objResponse, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody CredentialsDTORequest request, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            UserDTOResponse objResponse = this.mapper
                    .mapperModelToResponse(this.userCu.login(request.getLogin(), request.getPass()));
            return new ResponseEntity<UserDTOResponse>(objResponse, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> catchErrors(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
        }
        return response;

    }
}
