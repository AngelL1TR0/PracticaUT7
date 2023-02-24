package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.StudentDto;
import org.iesfm.highschool.controllers.dto.SubjectDto;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.entity.Subject;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SubjectController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/subjects")
    public ResponseEntity<List<SubjectDto>> listAllSubjets(
    ) {
        return ResponseEntity.ok(
                schoolService
                        .listSubjects()
                        .stream()
                        .map(SubjectDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/subject")
    public ResponseEntity<Void> addSubject(
            @Valid @RequestBody SubjectDto subject) {
        if (schoolService.addSubject(SubjectDto.toEntity(subject))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/subject/{subjectId}")
    public void updateSubject(@PathVariable Integer id, @RequestBody Subject subject) {
        Subject s = schoolService.getSubjectById(id);
        if (s != null) {
            s.setTotalHours(subject.getTotalHours());
            schoolService.addSubject(s);
        }
    }

    @DeleteMapping(path = "/subject/{subjectId}")
    public ResponseEntity<Void> deleteSubject(
            @PathVariable("subjectId") Integer subjectId) {
        schoolService.deleteSubject(subjectId);
        return ResponseEntity.ok().build();
    }

    //endpoint para el ejercicio 2

    @GetMapping("/{subjectId}/students")
    public ResponseEntity<List<Student>> getStudentsWithExcessiveAbsences(
            @PathVariable("subjectId") Integer subjectId,
            @RequestParam(value = "threshold", required = false, defaultValue = "10") Double threshold) {
        List<Student> students = schoolService.getStudentsWithExcessiveAbsences(subjectId, threshold);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }
}
