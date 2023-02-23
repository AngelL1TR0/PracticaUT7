package org.iesfm.highschool.service;

import org.iesfm.highschool.dao.AbsenceDAO;
import org.iesfm.highschool.dao.StudentDAO;
import org.iesfm.highschool.dao.SubjectDAO;
import org.iesfm.highschool.dao.TeacherDAO;
import org.iesfm.highschool.entity.Absence;
import org.iesfm.highschool.entity.Student;
import org.iesfm.highschool.entity.Subject;
import org.iesfm.highschool.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Absence> listAbsences() {
        return absenceDAO.getAllAbsences();
    }
    public boolean add(Absence absence) {
        return absenceDAO.addAbsence(absence);
    }
    public List<Student> listStudents() {
        return studentDAO.getAllStudents();
    }
    public List<Subject> listSubjects() {
        return subjectDAO.getAllSubjects();
    }
    public List<Teacher> listTeachers() {
        return teacherDAO.getAllTeachers();
    }
}
