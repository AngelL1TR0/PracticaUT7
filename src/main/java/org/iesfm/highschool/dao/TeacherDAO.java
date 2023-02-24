package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
}
