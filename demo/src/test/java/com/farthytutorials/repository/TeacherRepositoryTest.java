package com.farthytutorials.repository;

import com.farthytutorials.entity.Course;
import com.farthytutorials.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
       Course course= Course.builder()
                .title("Kigogo")
                .credit(200)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Yvonne")
                .lastName("Chelangat")
                .course(List.of(course))
                .build();
        teacherRepository.save(teacher);
    }

}