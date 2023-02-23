package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.SubjectDto;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SubjectController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/subjects")
    public ResponseEntity<List<SubjectDto>> listAllSubjets(
    ){
        return ResponseEntity.ok(
                schoolService
                        .listSubjects()
                        .stream()
                        .map(SubjectDto::toDto)
                        .collect(Collectors.toList())
        );
    }
}
