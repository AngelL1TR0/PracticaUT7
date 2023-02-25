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
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_surname")
    private String first_surname;
    @Column(name = "name")
    private String name;
    @Column(name = "second_surname")
    private String second_surname;
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

}
