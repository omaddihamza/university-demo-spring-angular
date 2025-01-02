package org.example.universitydemospringang.mappers;

import org.example.universitydemospringang.dto.StudentDTO;
import org.example.universitydemospringang.entities.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
       return StudentDTO.builder()
               .id(student.getId())
               .firstName(student.getFirstName())
               .lastName(student.getLastName())
               .code(student.getCode())
               .programId(student.getProgramId())
               .photo(student.getPhoto())
               .build();
    }
    public static Student toEntity(StudentDTO studentDTO) {
        return Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .code(studentDTO.getCode())
                .programId(studentDTO.getProgramId())
                .photo(studentDTO.getPhoto())
                .build();
    }
}
