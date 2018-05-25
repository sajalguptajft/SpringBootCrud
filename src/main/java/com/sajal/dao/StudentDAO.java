package com.sajal.dao;

import com.sajal.model.Student;
import com.sajal.model.StudentRole;

import java.util.List;

public interface StudentDAO {

    public List<Student> getAllStudents();

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public Student getStudent(int sid);

    public void deleteStudent(int sid);

    public void addStudentRole(StudentRole studentRole);

    void deleteStudentRole(int sid);
}
