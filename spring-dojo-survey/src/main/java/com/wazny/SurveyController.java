package com.wazny;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class SurveyController {

    @GetMapping("/")
    public ModelAndView survey() {
        ModelMap model = new ModelMap();
        model.addAttribute("locations", Arrays.asList("San Jose", "Chicago"));
        model.addAttribute("languages", Arrays.asList("Python", "Java"));
        return new ModelAndView("index",model);
    }

    @PostMapping(value = "/result")
    public ModelAndView results(SurveyModel answer) {


        ModelMap model = new ModelMap();
        model.addAttribute("answer", answer);
        return new ModelAndView("index", model);


    }
}
