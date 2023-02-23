package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Student;

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
public class StudentDto {

    @NotNull
    @Positive
    private Integer id;
    @NotBlank
    private String firstSurname;
    @NotBlank
    private String name;
    @NotBlank
    private String secondSurname;

    public static Student toEntity(StudentDto dto){
        return new Student(
                dto.getId(),
                dto.getFirstSurname(),
                dto.getName(),
                dto.getSecondSurname(),
                new ArrayList<>(),
                new HashSet<>()
        );
    }

    public static StudentDto toDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstSurname(),
                student.getName(),
                student.getSecondSurname()
        );
    }
}
