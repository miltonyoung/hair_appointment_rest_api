package com.example.demo;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebServerController
{

    @GetMapping("/home")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "User")
                    String name, Model model)
    {
        model.addAttribute("name", name);
        return "home"; //view
    }
}
