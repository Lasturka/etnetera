package cz.lasturka.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHome(Model model) {

        return "main/home";
    }

    @GetMapping("/statistics")
    public String displayStatistics(Model model) {

        return "main/statistics";
    }


}
