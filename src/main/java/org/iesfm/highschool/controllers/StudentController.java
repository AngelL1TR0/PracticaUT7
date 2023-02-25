package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.StudentDto;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/students")
    public ResponseEntity<List<StudentDto>> listAllStudents(
    ) {
        return ResponseEntity.ok(
                schoolService
                        .listStudents()
                        .stream()
                        .map(StudentDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/students")
    public ResponseEntity<Void> addStudent(
            @Valid @RequestBody StudentDto student) {
        if (schoolService.addStudent(StudentDto.toEntity(student))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/student/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {
        Student s = schoolService.getStudentById(id);
        if (s != null) {
            s.setId(student.getId());
            s.setName(student.getName());
            s.setFirst_surname(student.getFirst_surname());
            s.setSecond_surname(student.getSecond_surname());
            schoolService.addStudent(s);
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/students/{studentId}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable("studentId") Integer studentId) {
        if (schoolService.deleteStudent(studentId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
