package com.wazny.controllers;

import com.wazny.models.Language;
import com.wazny.repositories.LanguageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {

    private LanguageRepository repository;

    LanguageController(LanguageRepository repo) {
        this.repository = repo;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/languages";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public ModelAndView languages() {

        List<Language> languages = this.repository.findAll();
        ModelMap model = new ModelMap();
        model.addAttribute("form_action", "/languages/");
        model.addAttribute("form_method", "POST");
        model.addAttribute("form_caption", "Add");
        Language l = new Language();
        model.addAttribute("language", l);
        model.addAttribute("languages", languages);
        return new ModelAndView("index", model);

    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)

    public ModelAndView create(@Valid Language newLanguageDetails, BindingResult result) {

        ModelMap m = new ModelMap();
        if (result.hasErrors()) {
            List<Language> languages = repository.findAll();
            m.addAttribute("language", newLanguageDetails);
            formatValidationErrors(result, m);
            m.addAttribute("languages", languages);
            m.addAttribute("form_caption", "Add");
            m.addAttribute("form_method", "POST");
            return new ModelAndView("index", m);
        } else {
            repository.save(newLanguageDetails);

            return new ModelAndView("redirect:/languages", m);
        }
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.GET)

    public ModelAndView show(@PathVariable("id") Long id) {

        Language l = repository.findById(id).orElseThrow(IllegalArgumentException::new);

        ModelMap model = new ModelMap();
        model.addAttribute("language", l);

        return new ModelAndView("show", model);

    }

    @RequestMapping(value = "/languages/edit/{id}", method = RequestMethod.GET)

    public ModelAndView edit(@PathVariable("id") Long id) {

        Language l = repository.findById(id).orElseThrow(IllegalArgumentException::new);

        ModelMap model = new ModelMap();
        setUpModelForUpdate(l, model);
        return new ModelAndView("edit", model);

    }

    private void setUpModelForUpdate(Language l, ModelMap model) {
        model.addAttribute("language", l);
        model.addAttribute("form_method", "PUT");
        model.addAttribute("form_action", String.format("/languages/%d", l.getId()));
        model.addAttribute("form_caption", "Update");
        model.addAttribute("form_method_helper", "PUT");
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)

    public ModelAndView update(@PathVariable("id") Long id, @Valid Language updates, BindingResult result) {

        Language old = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        old.setName(updates.getName());
        old.setCreator(updates.getCreator());
        old.setCurrentVersion(updates.getCurrentVersion());


        ModelMap model = new ModelMap();
        if (result.hasErrors()) {
            formatValidationErrors(result, model);
            this.setUpModelForUpdate(old, model);
            return new ModelAndView("edit", model);
        } else {
            repository.save(old);

            return new ModelAndView("redirect:/languages/" + old.getId(), model);
        }
    }

    private void formatValidationErrors(BindingResult result, ModelMap model) {
        model.addAttribute("errors",
                result.
                        getFieldErrors().
                        stream().
                        map(e -> String.format("<strong>%s</strong>: %s", e.getField(),
                                e.getDefaultMessage())).toArray());
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
    public  String delete(@PathVariable("id") Long id) {

        repository.deleteById(id);
                return "redirect:/languages";
    }





}
