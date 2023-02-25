package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.TeacherDto;
import org.iesfm.highschool.entity.Teacher;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/teachers")
    public ResponseEntity<List<TeacherDto>> listAllTeachers(
    ) {
        return ResponseEntity.ok(
                schoolService
                        .listTeachers()
                        .stream()
                        .map(TeacherDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/teacher")
    public ResponseEntity<Void> addTeacher(
            @Valid @RequestBody TeacherDto teacher) {
        if (schoolService.addTeacher(TeacherDto.toEntity(teacher))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(
            @PathVariable Integer id,
            @RequestBody Teacher teacher) {
        Teacher t = schoolService.getTeacherById(id);
        if (t != null) {
            t.setId(teacher.getId());
            t.setName(teacher.getName());
            t.setFirst_surname(teacher.getFirst_surname());
            t.setSecond_surname(teacher.getSecond_surname());
            schoolService.addTeacher(t);
            return ResponseEntity.ok().body(t);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/teacher/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(
            @PathVariable("teacherId") Integer teacherId) {
        if (schoolService.deleteTeacher(teacherId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
