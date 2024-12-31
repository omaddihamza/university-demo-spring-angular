package org.example.universitydemospringang.services;

import org.example.universitydemospringang.entities.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> findAll();
    Student findByCode(String code);
    void deleteById(int id);
    List<Student> getStudentsByProgramId(String programId);
}
