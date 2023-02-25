package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Subject;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsencesStudentDto implements Serializable {
    private SimpleSubjectDto subject;
    private TeacherDto teacher;
    private List<SimpleAbsenceDto> absence;
    private Integer total_hours;
    private Double percentage;

    public static Subject toEntity(AbsencesStudentDto dto) {
        Subject entity = new Subject();
        entity.setName(dto.getSubject().getName());
        entity.setTotal_hours(dto.getTotal_hours());
        entity.setAbsences(dto.getAbsence().stream().map(SimpleAbsenceDto::toEntity).collect(Collectors.toList()));
        return entity;
    }

    public static AbsencesStudentDto toDto(Absence absence) {
        List<SimpleAbsenceDto> simpleAbsences = absence.getStudent().getAbsences().stream()
                .map(a -> new SimpleAbsenceDto(a.getDate(), a.getNum_hours()))
                .collect(Collectors.toList());

        int totalHours = simpleAbsences.stream().mapToInt(SimpleAbsenceDto::getNum_hours).sum();

        return new AbsencesStudentDto(
                SimpleSubjectDto.toDto(absence.getSubject()),
                TeacherDto.toDto(absence.getSubject().getTeacher()),
                simpleAbsences,
                totalHours,
                totalHours * 100.0 / absence.getSubject().getTotal_hours()
        );
    }
}