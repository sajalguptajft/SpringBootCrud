package com.sajal.controller;

import com.sajal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = { "/", "/index", "/login" }, method = RequestMethod.GET)
    public String goToHomePage(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        return "index";
    }

    @RequestMapping(value = "validate", method = RequestMethod.GET)
    public String validateuser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if(role.contains("ADMIN")) return "redirect:/admin/getAllStudents";
        else if(role.contains("USER")) return "redirect:/user/userprofile";
        else return "index";
    }

    @RequestMapping("/accessdenied")
    public String error403(){
        return "403";
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String forotpass(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        boolean check = false;
        check = userService.checkUser(email);
        if(check){
            final String uuid = UUID.randomUUID().toString().replace("-", "");
            userService.saveUuid(email, uuid);
            userService.sendForgotPasswordMail(email, uuid);
            model.addAttribute("error", "Password Reset Link Sent on Registered Email!");
        }
        else {
            model.addAttribute("error", "Email ID Not Registered!");
        }
        return "index";
    }

    @GetMapping("/resetpassword")
    public String resetpasspage(@RequestParam("key") String key, Model model){
        model.addAttribute("key", key);
        return "resetpassword";
    }

    @PostMapping("/passwordreset")
    public String resetpass(HttpServletRequest request, Model model){
        String key = request.getParameter("key");
        String password = request.getParameter("password");
        String confpassword = request.getParameter("confirmpassword");
        if(password.equals(confpassword)){
            userService.resetPassword(key, password);
            model.addAttribute("error", "Password Updated!");
        } else {
            model.addAttribute("error", "Passwords DO NOT MATCH!");
        }
        return "index";
    }

}