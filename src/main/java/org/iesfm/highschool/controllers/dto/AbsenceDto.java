package org.iesfm.highschool.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.entity.Subject;

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
    private Integer numHours;

    @NotNull
    private Student student;
    @NotNull
    private Subject subject;


    public static Absence toEntity(AbsenceDto dto){
        return new Absence(
                dto.getId(),
                dto.getDate(),
                dto.getNumHours(),
                new Student(),
                new Subject()
        );
    }

    public static AbsenceDto toDto(Absence absence){
        return new AbsenceDto(
                absence.getId(),
                absence.getDate(),
                absence.getNumHours(),
                absence.getStudent(),
                absence.getSubject()
        );
    }
}
