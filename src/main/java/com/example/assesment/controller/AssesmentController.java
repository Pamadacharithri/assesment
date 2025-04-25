package com.example.assesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assesment.dto.AssesmentDTO;
import com.example.assesment.service.AssesmentService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/assesment")
public class AssesmentController {

    @Autowired
    private AssesmentService assesmentService;


     @PostMapping("/create")
    public AssesmentDTO createAssesment(@RequestBody AssesmentDTO assesmentDTO) {
        return assesmentService.addAssesment(assesmentDTO);
    }

    @GetMapping("/")
    public List<AssesmentDTO> getAssesments() {
        return assesmentService.getAllAssesments();
    }

    @PutMapping("/update/{id}")
    public AssesmentDTO updateAssesment(@PathVariable String id, @RequestBody AssesmentDTO assesmentDTO) {
        return assesmentService.updateAssesment(id, assesmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAssesment(@PathVariable String id) {
        return assesmentService.deleteAssesment(id);
    }

    @GetMapping("/get/{id}")
    public AssesmentDTO getAssesment(@PathVariable String id) {
        return assesmentService.getAssesment(id);
    }
}
