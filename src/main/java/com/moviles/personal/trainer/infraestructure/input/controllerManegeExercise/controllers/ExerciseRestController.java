package com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.personal.trainer.application.input.ManegeExerciseCUIntPort;
import com.moviles.personal.trainer.domain.models.Exercise;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.DTOResponse.ExerciseDTOResponse;
import com.moviles.personal.trainer.infraestructure.input.controllerManegeExercise.mapppers.MapperExerciseInfraestructureDomain;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exercises")
@Validated
@RequiredArgsConstructor
public class ExerciseRestController {
    private final ManegeExerciseCUIntPort exerciseCU;
    private final MapperExerciseInfraestructureDomain mapper;

    @GetMapping("/")
    @Transactional(readOnly = true)
    public ResponseEntity<List<ExerciseDTOResponse>> listExercises() {
        List<Exercise> exercises = this.exerciseCU.getAll();
        ResponseEntity<List<ExerciseDTOResponse>> objResponse = new ResponseEntity<>(
                mapper.mapModelsToResponses(exercises), HttpStatus.OK);
        return objResponse;

    }

}
