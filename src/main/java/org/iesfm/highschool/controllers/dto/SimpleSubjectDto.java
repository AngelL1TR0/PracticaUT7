package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Subject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSubjectDto implements Serializable {
    @NotNull
    @Positive
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Integer total_hours;

    public static Subject toEntity(SimpleSubjectDto dto){
        Subject subject = new Subject();
        return new Subject(
                dto.getId(),
                dto.getName(),
                dto.getTotal_hours(),
                TeacherDto.toEntity(null),
                new ArrayList<>(),
                new HashSet<>()
        );
    }

    public static SimpleSubjectDto toDto(Subject entity){
        return new SimpleSubjectDto(
                entity.getId(),
                entity.getName(),
                entity.getTotal_hours()
        );
    }
}