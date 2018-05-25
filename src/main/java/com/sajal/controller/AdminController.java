package com.sajal.controller;

import com.sajal.model.Student;
import com.sajal.model.StudentRole;
import com.sajal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    StudentService studentService;

    @Autowired
    HttpSession session;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/getAllStudents", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        List<Student> listOfStudents = studentService.getAllStudents();
        model.addAttribute("listOfStudents", listOfStudents);
        return "admin/studentDetails";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student){
        if(student.getSid()==0){
            studentService.addStudent(student);
            StudentRole studentRole = new StudentRole();
            studentRole.setSname(student.getSname());
            studentRole.setSrole("ROLE_USER");
            studentService.addStudentRole(studentRole);
        }
        else {
            studentService.updateStudent(student);
        }
        return "redirect:/admin/getAllStudents";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/updateStudent/{sid}", method = RequestMethod.GET)
    public String updateStudent(@PathVariable int sid, Model model){
        model.addAttribute("studentform", new Student());
        model.addAttribute("student", this.studentService.getStudent(sid));
        return "admin/editstudentDetails";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/deleteStudent/{sid}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int sid, Model model){
        studentService.deleteStudent(sid);
        studentService.deleteStudentRole(sid);
        return "redirect:/admin/getAllStudents";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "logout";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin/addnewstudent")
    public String addstudent(Model model){
        model.addAttribute("student", new Student());
        return "admin/addstudent";
    }

}