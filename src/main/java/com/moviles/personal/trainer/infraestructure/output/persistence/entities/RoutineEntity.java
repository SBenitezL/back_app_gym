package com.moviles.personal.trainer.infraestructure.output.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "routine")
@Data
@AllArgsConstructor
public class RoutineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long routineId;
    @Column(nullable = false, length = 50)
    private String routineTitle;
    @Column(nullable = false)
    private int routineIcon;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "routine_exercises", joinColumns = @JoinColumn(name = "routineId"), inverseJoinColumns = @JoinColumn(name = "exerciseId"))
    private List<ExerciseEntity> exercises;

    public RoutineEntity() {
        this.exercises = new ArrayList<ExerciseEntity>();
    }
}
