package com.sajal.controller;

import com.sajal.model.Student;
import com.sajal.service.UserService;
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
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/userprofile", method = RequestMethod.GET)
    public String userprofile(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("user", userService.getUserDetails(username));
        return "user/userprofile";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/editUser/{sid}", method = RequestMethod.GET)
    public String edituser(@PathVariable int sid, Model model){
        model.addAttribute("userform", new Student());
        model.addAttribute("user", userService.getUserProfile(sid));
        return "user/edituser";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/userUpdate", method = RequestMethod.POST)
    public String updateuser(@ModelAttribute("userform") Student student){
        userService.updateUser(student);
        return "redirect:/user/userprofile";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "logout";
    }

}
