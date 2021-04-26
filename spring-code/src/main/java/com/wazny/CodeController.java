package com.wazny;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class CodeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String validate(@RequestParam String code, RedirectAttributes attributes) {


        if (code.equalsIgnoreCase("bushido")) {
            attributes.addAttribute("info", "Correct");
            return "redirect:/confirmed";
        }
        else {

            attributes.addAttribute("error", "You must train harder");
            return "redirect:/";
        }
    }
}
