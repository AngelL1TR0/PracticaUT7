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
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "total_hours")
    private Integer total_hours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private Teacher teacher;
    @OneToMany(mappedBy = "subject")
    private List<Absence> absences;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_subject",
            joinColumns = {@JoinColumn(name = "subject")},
            inverseJoinColumns = {@JoinColumn(name = "student")}
    )
    private Set<Student> students;

}