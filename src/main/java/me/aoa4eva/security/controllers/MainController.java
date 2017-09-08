package me.aoa4eva.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/")
    public String showIndex(Model model, Principal p) {
        model.addAttribute("Title","Page Title");
        if(p!=null)
            model.addAttribute("username", p.getName());
        return "index";
    }

}
