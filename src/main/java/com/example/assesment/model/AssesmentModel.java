package com.example.assesment.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AssesmentModel {
     @Id
    private String id;
    private String questionText;
    private List<String> options;
    private String correctAnswer;
}
