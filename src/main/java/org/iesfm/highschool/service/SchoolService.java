package org.iesfm.highschool.service;

import org.iesfm.highschool.dao.AbsenceDAO;
import org.iesfm.highschool.dao.StudentDAO;
import org.iesfm.highschool.dao.SubjectDAO;
import org.iesfm.highschool.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    @Autowired
    private AbsenceDAO absenceDAO;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private SubjectDAO subjectDAO;
    @Autowired
    private TeacherDAO teacherDAO;


}
