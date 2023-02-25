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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public boolean deleteTeacher(Integer teacherId) {
        try {
            teacherDAO.deleteById(teacherId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudent(Integer studentId) {
        try {
            teacherDAO.deleteById(studentId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteSubject(Integer subjectId) {
        try {
            teacherDAO.deleteById(subjectId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteAbsence(Integer absenceId) {
        try {
            teacherDAO.deleteById(absenceId);
            return true;
        } catch (Exception e) {
            return false;
        }
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


    public Set<Student> getStudentsByPercentage(Subject subject, double percentage) {
        Set<Student> studentsByPercentage = new HashSet<>();
        int totalHours = subject.getTotal_hours();
        double percentageOfAbsences;
        for (int i = 0; i < 100; i++) {
            List<Absence> absences = absenceDAO.findBySubject_IdAndStudent_id(subject.getId(), i);
            int studentTotalAbsences = 0;
            for (Absence absence : absences) {
                studentTotalAbsences = studentTotalAbsences + absence.getNum_hours();
            }
            percentageOfAbsences = (studentTotalAbsences * 100) / totalHours;

            if (percentageOfAbsences > percentage) {
                studentsByPercentage.add(absences.get(0).getStudent());
            }
        }
        return studentsByPercentage;
    }

    public List<Absence> getAbsencesByStudentId(Integer studentId) {
        Student student = studentDAO.findById(studentId).orElse(null);
        List<Absence> absences = student.getAbsences();
        if (absences.size() > 1) {
            absences = absences.subList(0, 1);
        }
        return absences;
    }
}
