package com.example.assesment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.assesment.model.AssesmentModel;

@Repository
public interface AssesmentRepo extends JpaRepository<AssesmentModel, String> {
    
    @Query(value = "SELECT * FROM assesment WHERE id = ?1", nativeQuery = true)
    AssesmentModel getAssesmentById(String id);

    
    Optional<AssesmentModel> findById(String id);
}



