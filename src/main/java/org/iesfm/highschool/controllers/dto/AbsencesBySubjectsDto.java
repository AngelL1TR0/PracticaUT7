package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.entity.Subject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsencesBySubjectsDto {
    @NotNull
    @Positive
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Integer total_hours;
    @NotNull
    private Double percentage;
    @NotNull
    private Set<StudentDto> students;

    public static Subject toEntity(SubjectDto dto) {
        return new Subject(
                dto.getId(),
                dto.getName(),
                dto.getTotal_hours(),
                TeacherDto.toEntity(dto.getTeacher()),
                new ArrayList<>(),
                new HashSet<>()
        );
    }

    public static AbsencesBySubjectsDto toDto(Subject subject, double percentage) {
        Set<Student> students = subject.getStudents();
        Set<StudentDto> studentDtos = new HashSet<>();
        for (Student student : students) {
            studentDtos.add(StudentDto.toDto(student));
        }
        return new AbsencesBySubjectsDto(
                subject.getId(),
                subject.getName(),
                subject.getTotal_hours(),
                percentage,
                studentDtos
        );
    }
}