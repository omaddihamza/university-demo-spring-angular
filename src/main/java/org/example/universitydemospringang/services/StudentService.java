package org.example.universitydemospringang.services;

import org.example.universitydemospringang.dto.StudentDTO;
import org.example.universitydemospringang.entities.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void saveStudentPhoto(MultipartFile file,String code) throws IOException;
    void saveStudentsWithoutPhoto(StudentDTO studentDTO);
    List<Student> findAll();
    Student findByCode(String code);
    void deleteById(int id);
    List<Student> getStudentsByProgramId(String programId);
}
