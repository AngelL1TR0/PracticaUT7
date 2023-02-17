package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_surname")
    private String firstSurname;

    @Column(name = "name")
    private String name;

    @Column(name = "second_surname")
    private String secondSurname;

    @OneToOne(mappedBy = "student_subject")
    private Student_subject studentSubject;

    @OneToMany(mappedBy = "absence")
    private List<Absence> absences;
}
