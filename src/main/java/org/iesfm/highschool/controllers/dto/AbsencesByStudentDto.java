package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Subject;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsencesByStudentDto {
    private SimpleSubjectDto subject;
    private TeacherDto teacher;
    private List<SimpleAbsenceDto> absence;
    private Integer total_hours;
    private Double percentage;

    public static Subject toEntity(AbsencesByStudentDto dto) {
        Subject subject = new Subject();
        subject.setName(dto.getSubject().getName());
        subject.setTotal_hours(dto.getTotal_hours());
        subject.setAbsences(dto.getAbsence().stream().map(SimpleAbsenceDto::toEntity).collect(Collectors.toList()));
        return subject;
    }

    public static AbsencesByStudentDto toDto(Absence absence) {
        List<SimpleAbsenceDto> simpleAbsences = absence.getStudent().getAbsences().stream()
                .map(a -> new SimpleAbsenceDto(a.getDate(), a.getNum_hours()))
                .collect(Collectors.toList());

        int totalHours = simpleAbsences.stream().mapToInt(SimpleAbsenceDto::getNum_hours).sum();

        return new AbsencesByStudentDto(
                SimpleSubjectDto.toDto(absence.getSubject()),
                TeacherDto.toDto(absence.getSubject().getTeacher()),
                simpleAbsences,
                totalHours,
                totalHours * 100.0 / absence.getSubject().getTotal_hours()
        );
    }
}