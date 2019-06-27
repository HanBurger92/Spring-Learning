package com.hanburger92.controller;

import com.hanburger92.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute(new User());
        return "register";
    }

    // @Valid用来启用User.class里的校检功能
    @PostMapping("/register")
    public String processRegistration (@Valid @ModelAttribute User user, BindingResult bindingResult){
        // System.out.println("----");
        if(bindingResult.hasErrors()){
            // System.out.println("====");
            return "register";
        }
        String info = String.format("User Submission: username = %s, password = %s", user.getUsername(), user.getPassword());
        System.out.println(info);
        return "user";
    }
}
