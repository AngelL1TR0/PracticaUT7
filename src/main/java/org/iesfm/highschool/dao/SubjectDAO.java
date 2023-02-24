package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {
    @Query("SELECT s.student FROM Absence a JOIN a.student s WHERE a.subject.id = :subjectId GROUP BY s")
    List<Student> getStudentsBySubjectId(@Param("subjectId") Integer subjectId);

    @Query("SELECT SUM(s.hours) FROM Schedule s WHERE s.subject.id = :subjectId AND s.student.id = :studentId")
    Integer getTotalHoursByStudentAndSubject(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);

    @Query("SELECT COUNT(a.id) FROM Absence a WHERE a.subject.id = :subjectId AND a.student.id = :studentId")
    Integer getTotalAbsencesByStudentAndSubject(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);
}