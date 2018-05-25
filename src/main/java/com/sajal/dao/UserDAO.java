package com.sajal.dao;

import com.sajal.model.Student;

public interface UserDAO {

    public Student getUserDetails(String username);

    public Student getUserProfile(int sid);

    public void updateUser(Student student);

    boolean checkUser(String email);

    void sendForgotPasswordMail(String email, String uuid);

    void saveUuid(String email, String uuid);

    void resetPassword(String key, String password);
}
