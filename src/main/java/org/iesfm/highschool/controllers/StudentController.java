package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.StudentDto;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
