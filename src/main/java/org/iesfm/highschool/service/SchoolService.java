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

import java.util.ArrayList;
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

    public Teacher getTeacherById(Integer id) {
        return teacherDAO.findById(id).orElse(null);
    }

    public Subject getSubjectById(Integer id) {
        return subjectDAO.findById(id).orElse(null);
    }

    public Student getStudentById(Integer id) {
        return studentDAO.findById(id).orElse(null);
    }
    public Absence getAbsenceById(Integer id) {
        return absenceDAO.findById(id).orElse(null);
    }

    public List<Student> getStudentsWithExcessiveAbsences(Integer subjectId, Double threshold) {
        List<Student> students = subjectDAO.getStudentsBySubjectId(subjectId);
        List<Student> studentsWithExcessiveAbsences = new ArrayList<>();
        for (Student student : students) {
            Integer totalHours = subjectDAO.getTotalHoursByStudentAndSubject(student.getId(), subjectId);
            Integer totalAbsences = subjectDAO.getTotalAbsencesByStudentAndSubject(student.getId(), subjectId);
            Double absencePercentage = (double) totalAbsences / totalHours * 100;
            if (absencePercentage > threshold) {
                studentsWithExcessiveAbsences.add(student);
            }
        }
        return studentsWithExcessiveAbsences;
    }
}
