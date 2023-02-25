package org.iesfm.highschool.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Absence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDto {
    @NotNull
    @Positive
    private Integer id;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Timestamp date;
    @NotNull
    @Positive
    private Integer num_hours;

    @NotNull
    private StudentDto student;
    @NotNull
    private SubjectDto subject;


    public static Absence toEntity(AbsenceDto dto) {
        return new Absence(
                dto.getId(),
                dto.getDate(),
                dto.getNum_hours(),
                StudentDto.toEntity(dto.getStudent()),
                SubjectDto.toEntity(dto.getSubject())
        );
    }

    public static AbsenceDto toDto(Absence absence) {
        return new AbsenceDto(
                absence.getId(),
                absence.getDate(),
                absence.getNum_hours(),
                StudentDto.toDto(absence.getStudent()),
                SubjectDto.toDto(absence.getSubject())
        );
    }
}
