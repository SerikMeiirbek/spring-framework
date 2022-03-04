package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String homePage(Model model){


        Mentor mentor = new Mentor("Mike", "Smith", 45, Gender.Male);
        Mentor mentor2 = new Mentor("Tom", "Hanks", 65, Gender.Male);
        Mentor mentor3 = new Mentor("Ammy", "Bryan", 25, Gender.Female);

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(mentor);
        mentors.add(mentor2);
        mentors.add(mentor3);


        model.addAttribute("mentors", mentors);

        return "/mentors/mentor";
    }
}
