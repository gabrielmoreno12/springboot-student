package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping(path = "api/v1/student")    // Define o mapeamento de URL para este controlador
public class StudentController {

    private final StudentService studentService;

    @Autowired  // Injeta uma instância do serviço StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping     // Mapeia solicitações GET para este método
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping    // Mapeia solicitações POST para este método
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")    // Mapeia solicitações DELETE para este método
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")   // Mapeia solicitações PUT para este método
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
