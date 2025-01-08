package org.example.universitydemospringang.services;

import org.example.universitydemospringang.dto.StudentDTO;
import org.example.universitydemospringang.entities.Student;
import org.example.universitydemospringang.mappers.StudentMapper;
import org.example.universitydemospringang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudentPhoto(MultipartFile file, String code) throws IOException {
        Student student = studentRepository.findByCode(code);
        Path folderPath = Paths.get("C:/spring/profile-picture/");
       if(!folderPath.toFile().exists()){
           Files.createDirectories(folderPath);
       }

       String uniqueFilename = code + "_" + UUID.randomUUID() + ".jpg";

       Path filePath = Paths.get("C:/spring/profile-picture/",uniqueFilename );
       Files.copy(file.getInputStream(), filePath);

       student.setPhoto(filePath.toUri().toString());
       studentRepository.save(student);
    }

    @Override
    public void saveStudentsWithoutPhoto(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
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
