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
@Table(name = "user")
@Data
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(nullable = false, length = 150)
    private String userNames;
    @Column(nullable = false, length = 150)
    private String userLastNames;
    @Column(nullable = false)
    private int serAge;
    @Column(nullable = false)
    private Double userHeight;
    @Column(nullable = false)
    private Double userWeight;
    @Column(nullable = false, length = 200)
    private String userEmail;
    @Column(nullable = false, length = 20)
    private String userName;
    @Column(nullable = false, length = 100)
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_routines", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "routineId"))
    private List<RoutineEntity> routines;

    public UserEntity() {
        this.routines = new ArrayList<RoutineEntity>();
    }

}
