package com.farthytutorials.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private  String title;
    private Integer credit;
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_Id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_Id",
                    referencedColumnName = "studentId"
            )
    )

    private List<Student> students;
    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
