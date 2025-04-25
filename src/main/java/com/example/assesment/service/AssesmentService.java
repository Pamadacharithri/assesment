package com.example.assesment.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assesment.dto.AssesmentDTO;
import com.example.assesment.model.AssesmentModel;
import com.example.assesment.repo.AssesmentRepo;

@Service
@Transactional
public class AssesmentService {

    @Autowired
    private AssesmentRepo assesmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AssesmentDTO addAssesment(AssesmentDTO assesmentDTO) {
        assesmentRepo.save(modelMapper.map(assesmentDTO, AssesmentModel.class));
        return assesmentDTO;
    }

    public List<AssesmentDTO> getAllAssesments() {
        List<AssesmentModel> assesmentsList = assesmentRepo.findAll();
        return modelMapper.map(assesmentsList, new TypeToken<List<AssesmentDTO>>(){}.getType());
    }

    public AssesmentDTO updateAssesment(String userId, AssesmentDTO feedbackDTO) {
        // Use userId instead of id
        AssesmentModel existingAssesment = assesmentRepo.findById(userId)
           .orElseThrow(() -> new RuntimeException("Assesment not found"));

        // Assuming you want to map the new data to the existing assessment
        modelMapper.map(feedbackDTO, existingAssesment); // Update existing model with new data
        AssesmentModel updatedAssesment = assesmentRepo.save(existingAssesment); // Save the updated model

        return modelMapper.map(updatedAssesment, AssesmentDTO.class); // Return the updated DTO
    }

    public String deleteAssesment(String id) {
        assesmentRepo.deleteById(id);
        return "Assesment deleted successfully";
    }

    public AssesmentDTO getAssesment(String id) {
        AssesmentModel feedback = assesmentRepo.getAssesmentById(id);
        return modelMapper.map(feedback, AssesmentDTO.class); // Return the mapped DTO
    }
}

