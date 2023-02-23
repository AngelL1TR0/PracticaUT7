package org.iesfm.highschool.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDto {

    @NotBlank
    private String id;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Timestamp date;

    @NotNull
    @Positive
    private Integer numHours;

}
