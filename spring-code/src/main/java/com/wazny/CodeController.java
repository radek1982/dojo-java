package com.wazny;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
@Controller
public class CodeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Boolean valid, ModelMap model) {

        model.addAttribute("valid", valid == null || valid);
        return new ModelAndView("index", model);
    }

    @PostMapping("/code")
    public ModelAndView validate (@RequestParam(name="code") String code, RedirectAttributes ra) {

        if (code.equalsIgnoreCase("bushido")) {

            ModelMap model = new ModelMap();
            List<String> bushido = Arrays.asList("Loyalty", "Courage", "Veracity", "Composition", "Honor");
            model.addAttribute("valid", true);
            model.addAttribute("code", bushido);
            return new ModelAndView("index", model);
        }
        else
            ra.addAttribute("valid", false);
            return new ModelAndView("redirect:/", ra.getFlashAttributes());
    }
}
