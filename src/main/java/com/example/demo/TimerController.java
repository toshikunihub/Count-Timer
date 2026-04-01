package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimerController {

    private Timer timer = new Timer();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("elapsedTime", timer.getElapsedTime());
        model.addAttribute("lapTimes", timer.getLapTimes());
        return "index"; // templates/index.html
    }

    @PostMapping("/start")
    public String start() {
        timer.start();
        return "redirect:/";
    }

    @PostMapping("/stop")
    public String stop() {
        timer.stop();
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset() {
        timer.reset();
        return "redirect:/";
    }

    @PostMapping("/lap")
    public String addLap() {
        timer.addLap();
        return "redirect:/";
    }

    @PostMapping("/deleteLap/{index}")
    public String deleteLap(@PathVariable int index) {
        timer.deleteLap(index);
        return "redirect:/";
    }
}