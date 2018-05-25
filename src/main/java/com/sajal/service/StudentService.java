package com.sajal.service;

import com.sajal.dao.StudentDAO;
import com.sajal.model.Student;
import com.sajal.model.StudentRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public List<Student> getAllStudents(){
        List<Student> studentlist = studentDAO.getAllStudents();
        return studentlist;
    }
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
    public Student getStudent(int sid){
        return studentDAO.getStudent(sid);
    }
    public void deleteStudent(int sid){
        studentDAO.deleteStudent(sid);
    }

    public void addStudentRole(StudentRole studentRole) {
        studentDAO.addStudentRole(studentRole);
    }

    public void deleteStudentRole(int sid) {
        studentDAO.deleteStudentRole(sid);
    }
}
