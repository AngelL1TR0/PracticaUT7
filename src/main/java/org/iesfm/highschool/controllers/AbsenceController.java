package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.AbsenceDto;
import org.iesfm.highschool.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AbsenceController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/absences")
    public ResponseEntity<List<AbsenceDto>> listAllAbsences(
    ) {
        return ResponseEntity.ok(
                schoolService
                        .listAbsences()
                        .stream()
                        .map(AbsenceDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/absences")
    public ResponseEntity<Void> addAbsences(
            @Valid @RequestBody AbsenceDto absence
    ) {
        if (schoolService.add(AbsenceDto.toEntity(absence))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
