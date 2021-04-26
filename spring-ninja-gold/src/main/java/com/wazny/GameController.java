package com.wazny;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    private List<Quest> quests = new ArrayList<>();
    private List<LogEntry> log;
    private Integer gold = 0;
    private HttpSession session;
    GameController(HttpSession s ) {
        quests.add(new Quest("Farm", 10,20));
        quests.add(new Quest("Cave", 5,10));
        quests.add(new Quest("House", 2,5));
        quests.add(new Quest("Casino", -50,50));

        session = s;
    }

    @GetMapping("/")
    public ModelAndView startGame(
                                  ) {

        if (this.session.getAttribute("gold")!=null) {
            this.gold = (Integer) this.session.getAttribute("gold");
        }
        if (this.session.getAttribute("log")!=null) {
            this.log = (List<LogEntry>) this.session.getAttribute("log");
        }
        ModelMap model = new ModelMap();
        model.addAttribute("quests", quests);
        model.addAttribute("log", this.log);
        model.addAttribute("gold",this.gold);
        return new ModelAndView("index",model );
    }
    @PostMapping("/takeQuest")
    public ModelAndView takeQuest(@RequestParam String  quest) {

        Quest r = Quest.findQuest(quest, this.quests);
        Integer gain =  r.getResult();
        Integer gold = this.gold +gain;
        LogEntry logEntry = new LogEntry(r.name, gain);
        List<LogEntry> l = this.log(logEntry);

        this.session.setAttribute("gold", gold);
      ModelMap model = new ModelMap();
        model.addAttribute("log", l);
        return new ModelAndView("redirect:/",model );
    }


    @GetMapping("/reset")

    public String reset() {
        session.removeAttribute("gold");
        session.removeAttribute("log");
        this.log.clear();
        this.gold =0;

        return "redirect:/";

    }

    private List<LogEntry> log(LogEntry entry) {
        List<LogEntry> log = (List<LogEntry>) this.session.getAttribute("log");
        if (log==null) {
            log = new ArrayList<LogEntry>();

        }
        log.add(entry);
        this.session.setAttribute("log", log);
        return log;
    }
}
