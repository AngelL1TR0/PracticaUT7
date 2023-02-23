package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "absence")
public class Absence implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "num_hours")
    private Integer numHours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject")
    private Subject subject;
}
