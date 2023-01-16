package com.example.firstporoject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public  String niceToMeetYou(Model model) {
        model.addAttribute("username" ,"민균");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeyouNext(Model model){
        model.addAttribute("nickname","홍길동");
        return "godbye";
    }
}
