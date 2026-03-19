package com.capgemini.model.entity;
import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String studentName;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Project project;
}