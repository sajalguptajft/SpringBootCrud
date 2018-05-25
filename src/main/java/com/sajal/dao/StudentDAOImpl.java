package com.sajal.dao;

import com.sajal.model.Student;
import com.sajal.model.StudentRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Student> getAllStudents(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery(" from Student").list();
    }

    public void addStudent(Student student){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(student);
    }

    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    public Student getStudent(int sid) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.get(Student.class, sid);
        return student;
    }

    public void deleteStudent(int sid) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(sid));
        if (null != student) {
            session.delete(student);
        }
    }

    public void addStudentRole(StudentRole studentRole) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(studentRole);
    }

    public void deleteStudentRole(int srid) {
        Session session = this.sessionFactory.getCurrentSession();
        StudentRole student = (StudentRole) session.load(StudentRole.class, new Integer(srid));
        if (null != student) {
            session.delete(student);
        }
    }
}
