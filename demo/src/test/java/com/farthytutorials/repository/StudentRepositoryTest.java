package com.farthytutorials.repository;

import com.farthytutorials.entity.Guardian;
import com.farthytutorials.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public  void saveStudent(){

        Student student = Student.builder()
                //.guardianEmail("manu@gmail.com")
                //.guardianMobile("8997655444")
                .firstName("Farthy")
                .lastName("gjhhjj")
                //.guardianName("manu")
                .emailId("farthy@gmail.com")

                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("manu@gmail.com")
                .mobile("09876543")
                .name("manu")
                .build();
        Student student = Student.builder()
                .firstName("Farthy")
                .lastName("onzere")
                .emailId("farthy123@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
    
    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Farthy");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("hy");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("farthy@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "FarthyYvonne",
                "farthy@gmail.com");
    }

}