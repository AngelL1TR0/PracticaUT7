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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return absenceDAO.findAll();
    }

    public List<Student> listStudents() {
        return studentDAO.findAll();
    }

    public List<Subject> listSubjects() {
        return subjectDAO.findAll();
    }

    public List<Teacher> listTeachers() {
        return teacherDAO.findAll();
    }

    public boolean addStudent(Student student) {
        try {
            studentDAO.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addAbsence(Absence absence) {

        try {
            absenceDAO.save(absence);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addSubject(Subject subject) {
        try {
            subjectDAO.save(subject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addTeacher(Teacher teacher) {
        try {
            teacherDAO.save(teacher);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteTeacher(Integer teacherId) {
        teacherDAO.deleteById(teacherId);
    }

    public void deleteStudent(Integer studentId) {
        studentDAO.deleteById(studentId);
    }

    public void deleteSubject(Integer subjectId) {
         subjectDAO.deleteById(subjectId);
    }

    public void deleteAbsence(Integer absenceId) {
        absenceDAO.deleteById(absenceId);
    }

    public boolean updateTeacher(Integer teacherId, Teacher teacher) {
        Map<Integer, Teacher> teacherMap = new HashMap<>();
        if (teacherMap.containsKey(teacherId)) {
            teacherMap.remove(teacherId);
            teacherMap.put(teacher.getId(), teacher);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatesubject(Integer subjectId, Subject subject) {
        Map<Integer, Subject> subjectMap = new HashMap<>();
        if (subjectMap.containsKey(subjectId)) {
            subjectMap.remove(subjectId);
            subjectMap.put(subject.getId(), subject);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStudent(Integer studentId, Student student) {
        Map<Integer, Student> studentMap = new HashMap<>();
        if (studentMap.containsKey(studentId)) {
            studentMap.remove(studentId);
            studentMap.put(student.getId(), student);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateAbsense(Integer abcenseId, Absence absence) {
        Map<Integer, Absence> absenceMap = new HashMap<>();
        if (absenceMap.containsKey(abcenseId)) {
            absenceMap.remove(abcenseId);
            absenceMap.put(absence.getId(), absence);
            return true;
        } else {
            return false;
        }
    }

}
