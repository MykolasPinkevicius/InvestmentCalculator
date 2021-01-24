package com.mykolaspinkevicius.investmentcalculator.controllers;

import com.mykolaspinkevicius.investmentcalculator.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AuthorisationController {

    @GetMapping("/")
    public String welcome(Model model) {
        return "welcomePage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("userInfo", WebUtils.toString((User) ((Authentication) principal).getPrincipal()));
        return "adminPage";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @GetMapping("/userinfo")
    public String userInfo(Model model, Principal principal) {
        System.out.println("Successful login user: " + principal.getName());
        model.addAttribute("userInfo", WebUtils.toString((User) ((Authentication) principal).getPrincipal()));
        return "userInfoPage";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("userInfo", WebUtils.toString((User) ((Authentication) principal).getPrincipal()));
            model.addAttribute("message", "Hi" + principal.getName() + "<br> You do not have access for this page!");
        }
        return "403Page";
    }
}
