package org.iesfm.highschool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    /*
    He quitado de todas las entidades el @GeneratedValue
    ya que pienso que se pueden tener id que no sean en orden,
     y para ejecutar los PUT es mejor
     */
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Timestamp date;
    @Column(name = "num_hours")
    private Integer num_hours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject")
    private Subject subject;
}
