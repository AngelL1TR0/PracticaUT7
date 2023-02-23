package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.TeacherDto;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/teachers")
    public ResponseEntity<List<TeacherDto>> listAllTeachers(
    ){
        return ResponseEntity.ok(
                schoolService
                        .listTeachers()
                        .stream()
                        .map(TeacherDto::toDto)
                        .collect(Collectors.toList())
        );
    }
}
