package org.iesfm.highschool.dao;

import org.iesfm.highschool.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AbsenceDAO extends JpaRepository<Absence, Integer> {
    List<Absence> getAllAbsences();

    boolean addAbsence(Absence absence);
}
