package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {
    List<Subject> getAllSubjects();
}
