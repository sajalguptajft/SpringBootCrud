package com.sajal.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String sname;
    private String smobile;
    private String spassword;
    private boolean senabled;
    private String semail;
    @Transient
    private String sconfpassword;

    public String getSconfpassword() {
        return sconfpassword;
    }

    public void setSconfpassword(String sconfpassword) {
        this.sconfpassword = sconfpassword;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public boolean isSenabled() {
        return senabled;
    }

    public void setSenabled(boolean senabled) {
        this.senabled = senabled;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSmobile() {
        return smobile;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }
}
