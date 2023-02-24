package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceDAO extends JpaRepository<Absence, Integer> {
}
