package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {
    @Id
    private Integer id;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "name")
    private String name;
    @Column(name = "second_surname")
    private String secondSurname;
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

}
