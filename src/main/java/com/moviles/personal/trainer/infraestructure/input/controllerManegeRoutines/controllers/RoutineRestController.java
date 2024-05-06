package com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.personal.trainer.application.input.ManegeExerciseCUIntPort;
import com.moviles.personal.trainer.application.input.ManegeRoutineCUIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.domain.models.Routine;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTOResponse.ExerciseDTOResponse;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTORequest.RoutineDTORequest;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.DTOResponse.RoutineDTOResponse;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeRoutines.mapppers.MapperRoutineInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/routines")
@RequiredArgsConstructor
public class RoutineRestController {
    private final ManegeRoutineCUIntPort routineCU;
    private final MapperRoutineInfraestructureDomain mapper;

    @PostMapping("/")
    public ResponseEntity<?> saveRoutine(@Valid @RequestBody RoutineDTORequest request, BindingResult result) {
        Routine routine = this.mapper.mapperRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            RoutineDTOResponse objRoutine = this.mapper.mapperModelToResponse(this.routineCU.create(routine));
            return new ResponseEntity<RoutineDTOResponse>(objRoutine, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<RoutineDTOResponse>> getAll() {
        List<Routine> routines = this.routineCU.getAll();
        ResponseEntity<List<RoutineDTOResponse>> objResponse = new ResponseEntity<>(
                mapper.mapperModelsToResponses(routines), HttpStatus.OK);
        return objResponse;
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
