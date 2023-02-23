package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Subject;
import org.iesfm.highschool.entity.Teacher;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    @NotNull
    @Positive
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Integer totalHours;
    @NotBlank
    private Teacher teacher;

    public static Subject toEntity(SubjectDto dto){
        return new Subject(
                dto.getId(),
                dto.getName(),
                dto.getTotalHours(),
                dto.getTeacher(),
                new ArrayList<>(),
                new HashSet<>()
        );
    }

    public static SubjectDto toDto(Subject subject){
        return new SubjectDto(
                subject.getId(),
                subject.getName(),
                subject.getTotalHours(),
                subject.getTeacher()
        );
    }
}
