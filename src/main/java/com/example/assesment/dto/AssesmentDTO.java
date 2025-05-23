package com.example.assesment.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssesmentDTO {
    private String id;
    private String questionText;
    private List<String> options;
    private String correctAnswer;
}
