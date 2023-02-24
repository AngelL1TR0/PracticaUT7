package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.StudentDto;
import org.iesfm.highschool.controllers.dto.SubjectDto;
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
    public ResponseEntity<Void> updateSubject(
            @PathVariable("subjectId") Integer subjectId,
            @Valid @RequestBody SubjectDto subjectDto
    ) {
        if (schoolService.updatesubject(subjectId, SubjectDto.toEntity(subjectDto))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/subject/{subjectId}")
    public ResponseEntity<Void> deleteSubject(
            @PathVariable("subjectId") Integer subjectId) {
        schoolService.deleteSubject(subjectId);
        return ResponseEntity.ok().build();
    }
}
