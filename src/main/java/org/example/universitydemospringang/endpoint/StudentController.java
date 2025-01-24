package org.example.universitydemospringang.endpoint;

import org.example.universitydemospringang.dto.StudentDTO;
import org.example.universitydemospringang.entities.Student;
import org.example.universitydemospringang.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private  StudentService studentService;

    @PutMapping(path = "saveStudentPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveStudent(@RequestParam("file") MultipartFile file, @RequestParam("code") String code) throws IOException {
        studentService.saveStudentPhoto(file, code);
    }
    @GetMapping(path = "students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(path = "students/{code}")
    public Student findByCode(@PathVariable String code) {
        return studentService.findByCode(code);
    }

    public void deleteById(int id) {
        studentService.deleteById(id);
    }

    @GetMapping("studentByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId) {
        return studentService.getStudentsByProgramId(programId);
    }

    @PostMapping("saveStudentsWithoutPhoto")
    public void saveStudentsWithoutPhoto(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudentsWithoutPhoto(studentDTO);
    }
}
