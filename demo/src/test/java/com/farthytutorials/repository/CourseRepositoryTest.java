package com.farthytutorials.repository;

import com.farthytutorials.entity.Course;
import com.farthytutorials.entity.Guardian;
import com.farthytutorials.entity.Student;
import com.farthytutorials.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .credit(30)
                .title("Blossoms of the savanna")
                .build();
        courseRepository.save(course);
    }
    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
   @Test
    public void saveCourseWithStudent(){
       Teacher teacher= Teacher.builder()
               .firstName("qwwert")
               .lastName("poiuyt")
               .build();
       Guardian guardian = Guardian.builder()
                .name("Bululu3")
                .mobile("09876543")
                .email("bululu3@gmail.com")
                .build();
        Student student= Student.builder()
                .firstName("vinny2")
                .lastName("Vinny2")
                .emailId("vinny4@gmail.com")
                .guardian(guardian)
                .build();
        Course course = Course.builder()
                .credit(3)
                .title("python")
                .students(List.of(student))
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

}