package com.sajal.dao;

import com.sajal.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Student getUserDetails(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.createQuery("from Student where sname='"+username+"'").list().get(0);
        return student;
    }

    public Student getUserProfile(int sid) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.get(Student.class, sid);
        return student;
    }

    public void updateUser(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Transactional
    public boolean checkUser(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        boolean check = false;
        int count = ((Long)session.createQuery("select count(*) from Student where semail='"+email+"'").uniqueResult()).intValue();
        if(count>0)
            check = true;
        else
            check = false;
        return check;
    }

    @Transactional
    public void sendForgotPasswordMail(String email, String uuid) {
        final String username = "sajal.gupta@jellyfishtechnologies.com";
        final String password = "sajal123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Forgot Password");
            message.setText("Please Click on the link below to reset your Password. \n\n http://localhost:8080/resetpassword?key="+uuid+"");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUuid(String email, String uuid) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Student set suuid='"+uuid+"' where semail='"+email+"'");
        query.executeUpdate();
    }

    public void resetPassword(String key, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Student set spassword='"+password+"' where suuid='"+key+"'");
        query.executeUpdate();
    }
}
