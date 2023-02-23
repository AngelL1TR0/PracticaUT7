package org.iesfm.highschool.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    @NotNull
    @Positive
    private Long id;
    @NotBlank
    private String firstSurname;
    @NotBlank
    private String name;
    @NotBlank
    private String secondSurname;
}
