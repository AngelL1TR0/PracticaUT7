package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
}
