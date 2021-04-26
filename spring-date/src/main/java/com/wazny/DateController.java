package com.wazny;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;

@Controller
public class DateController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/date")
    public String date( Model model) {
        model.addAttribute("date", new java.util.Date());
        return "date";
    }

    @GetMapping("/time")
    public String time( Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");
        model.addAttribute("date", formatter.format(new java.util.Date()));
        return "time";
    }
}
