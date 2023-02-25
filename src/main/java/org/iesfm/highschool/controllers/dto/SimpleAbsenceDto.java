package org.iesfm.highschool.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesfm.highschool.entity.Absence;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleAbsenceDto implements Serializable {
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Timestamp date;
    private Integer num_hours;

    public static Absence toEntity(SimpleAbsenceDto dto) {
        Absence entity = new Absence();
        entity.setDate(dto.getDate());
        entity.setNum_hours(dto.getNum_hours());
        return entity;
    }
}