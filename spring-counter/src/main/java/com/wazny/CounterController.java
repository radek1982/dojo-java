package com.wazny;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {

    @GetMapping("/")
    public String home(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {counter = 0;}
        session.setAttribute("counter", counter+1);
        return "index";


    }
    @GetMapping("/counter")
    public String counter(HttpSession session, Model model) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {counter = 0;} ;
        model.addAttribute("counter",  counter);
        return "counter";


    }
}
