package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    @NotNull
    @Positive
    private Integer id;
    @NotBlank
    private String first_surname;
    @NotBlank
    private String name;
    @NotBlank
    private String second_surname;

    public static Teacher toEntity(TeacherDto dto) {
        return new Teacher(
                dto.getId(),
                dto.getFirst_surname(),
                dto.getName(),
                dto.getSecond_surname(),
                new ArrayList<>()
        );
    }

    public static TeacherDto toDto(Teacher teacher) {
        return new TeacherDto(
                teacher.getId(),
                teacher.getFirst_surname(),
                teacher.getName(),
                teacher.getSecond_surname()
        );
    }
}