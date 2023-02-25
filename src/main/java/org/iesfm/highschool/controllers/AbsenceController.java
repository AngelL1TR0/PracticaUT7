package org.iesfm.highschool.controllers;

import org.iesfm.highschool.controllers.dto.AbsenceDto;
import org.iesfm.highschool.controllers.dto.AbsencesStudentDto;
import org.iesfm.highschool.controllers.dto.AbsencesSubjectsDto;
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
import java.util.Set;
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
        if (schoolService.addAbsence(AbsenceDto.toEntity(absence))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/absences/{absenceId}")
    public ResponseEntity<Absence> updateAbsence(
            @PathVariable Integer id,
            @RequestBody Absence absence) {
        Absence a = schoolService.getAbsenceById(id);
        if (a != null) {
            a.setId(absence.getId());
            a.setDate(absence.getDate());
            a.setNum_hours(absence.getNum_hours());
            schoolService.addAbsence(a);
            return ResponseEntity.ok().body(a);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/absences/{absenceId}")
    public ResponseEntity<Void> deleteAbsence(
            @PathVariable("absenceId") Integer absenceId) {
        if (schoolService.deleteAbsence(absenceId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/absence/subject/{id_subject}")
    public ResponseEntity<AbsencesSubjectsDto> getStudentByPercentaje(
            @PathVariable("id_subject") Integer subjectId,
            @RequestParam(value = "percentage", required = false) double percentage
    ) {
        Subject subject = schoolService.getSubjectById(subjectId);
        Set<Student> studentSubject = schoolService.getStudentsByPercentage(subject, percentage);
        subject.setStudents(studentSubject);
        return ResponseEntity.ok(AbsencesSubjectsDto.toDto(subject, percentage));
    }

    @GetMapping("/absences/student/{studentId}")
    public ResponseEntity<AbsencesStudentDto> getAbsencesByStudentId(
            @PathVariable Integer studentId) {
        List<Absence> absences = schoolService.getAbsencesByStudentId(studentId);
        if (absences == null || absences.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AbsencesStudentDto> absenceDtoList = absences.stream()
                .map(AbsencesStudentDto::toDto)
                .collect(Collectors.toList());
        AbsencesStudentDto firstAbsenceDto = absenceDtoList.get(0);
        return ResponseEntity.ok(firstAbsenceDto);
    }
}

