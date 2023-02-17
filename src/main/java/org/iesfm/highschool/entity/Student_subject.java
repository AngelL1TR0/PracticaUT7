package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_subject")
public class Student_subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "subject", nullable = false)
    private Long subjectId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student", nullable = false)
    private Long studentId;

    @OneToOne(mappedBy = "student")
    private Student student;

    @OneToOne(mappedBy = "subject")
    private Subject subject;
    
}
