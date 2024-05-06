package com.moviles.personal.trainer.infraestructure.output.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "muscle")
@Data
@AllArgsConstructor
public class MuscleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long muscleId;
    @Column(nullable = false, length = 50)
    private String muscleName;

    public MuscleEntity() {
    }
}
