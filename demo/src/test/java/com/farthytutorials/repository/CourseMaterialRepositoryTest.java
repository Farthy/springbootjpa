package com.farthytutorials.repository;

import com.farthytutorials.entity.Course;
import com.farthytutorials.entity.CourseMaterial;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("made Familiar")
                .credit(2500)
                 .build();
        CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.material.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}