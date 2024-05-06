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
@Table(name = "exercise")
@Data
@AllArgsConstructor
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exerciseId;
    @Column(nullable = false, length = 50)
    private String exerciseName;
    @Column(nullable = false)
    private int exerciseIcon;
    @Column(nullable = false, length = 350)
    private String exerciseDescription;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_muscles", joinColumns = @JoinColumn(name = "exerciseId"), inverseJoinColumns = @JoinColumn(name = "muscleId"))
    private List<MuscleEntity> muscles;

    public ExerciseEntity() {
        this.muscles = new ArrayList<MuscleEntity>();
    }
}
