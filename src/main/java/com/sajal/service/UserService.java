package com.sajal.service;

import com.sajal.dao.UserDAO;
import com.sajal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDAO userDAO;

    public Student getUserDetails(String username){
        return userDAO.getUserDetails(username);
    }

    public Student getUserProfile(int sid) { return userDAO.getUserProfile(sid); }

    public void updateUser(Student student) {
        userDAO.updateUser(student);
    }

    public void sendForgotPasswordMail(String email, String uuid) {
        userDAO.sendForgotPasswordMail(email, uuid);
    }

    public boolean checkUser(String email) {
        boolean check = false;
        check = userDAO.checkUser(email);
        return check;
    }

    public void saveUuid(String email, String uuid) {
        userDAO.saveUuid(email, uuid);
    }

    public void resetPassword(String key, String password) {
        userDAO.resetPassword(key, password);
    }
}
