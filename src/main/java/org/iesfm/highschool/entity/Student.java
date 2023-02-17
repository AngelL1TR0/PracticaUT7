package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    private Long id;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "name")
    private String name;
    @Column(name = "second_surname")
    private String secondSurname;
    @OneToMany(mappedBy = "student")
    private List<Absence> absences;

}

