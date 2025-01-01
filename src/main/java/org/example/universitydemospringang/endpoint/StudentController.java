package org.example.universitydemospringang.endpoint;

import org.example.universitydemospringang.entities.Student;
import org.example.universitydemospringang.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class StudentController {
    @Autowired
    private  StudentService studentService;

    @PostMapping(path = "saveStudent")
    public void saveStudent(@RequestBody  Student student) {
        studentService.saveStudent(student);
    }
    @GetMapping(path = "students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(path = "students/{id}")
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
}
