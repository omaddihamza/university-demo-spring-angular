package org.example.universitydemospringang.services;

import org.example.universitydemospringang.entities.Student;
import org.example.universitydemospringang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
       student.setId(UUID.randomUUID().toString());
       student.setCode(Student.generateUniqueCode());
       studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByCode(String code) {
        return studentRepository.findByCode(code);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Student> getStudentsByProgramId(String programId) {
        return studentRepository.findByProgramId(programId);
    }
}
