package me.aoa4eva.security.controllers;

import me.aoa4eva.security.models.Club;
import me.aoa4eva.security.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    ClubRepository clubRepository;


    @GetMapping("/")
    public String showIndex(Model model, Principal p) {
        model.addAttribute("Title","Page Title");
        System.out.println("Successfully logged in with"+p.getName());
        if(p!=null)
            model.addAttribute("username", p.getName());
        System.out.println("Displaying the login details");
        model.addAttribute("message",p.getName()+"is logged in");
        return "index";
    }


    @GetMapping("/addclub")
    public String addClub(Model model)
    {
        model.addAttribute("club",new Club());
        return "clubform";
    }


    @PostMapping("/addclub")
    public String addClub(@Valid @ModelAttribute("club") Club club, BindingResult bindingResult, Model model )
    {
        if(bindingResult.hasErrors())
        {
            return "addclub";
        }

        clubRepository.save(club);
        model.addAttribute("message","Your club has been saved");
        return "index";



    }


}
