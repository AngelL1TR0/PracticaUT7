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
public class SubjectDto {
    @NotNull
    @Positive
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer totalHours;
}
