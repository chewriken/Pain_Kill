package accessingDataJPA.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import accessingDataJPA.model.VoteSondage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @Controller
    public class VoteSondageController {

        //private static final String template = "Hello, %s!";
        //private final AtomicLong counter = new AtomicLong();
        private List<VoteSondage> voteSondageList = new ArrayList();

       /* @GetMapping("/voteSondage")
        public VoteSondage voteSondage(@RequestParam(value = "name", defaultValue = "World") String name) {
            return new VoteSondage(counter.incrementAndGet(), String.format(template, name));
        }*/

        @GetMapping("/VoteSondage")
        public String showVote(Model model){
            VoteSondage sondage1 = new VoteSondage(1,"Mardi");
            VoteSondage sondage2 = new VoteSondage(2,"Jeudi");

            voteSondageList.add(sondage1);
            voteSondageList.add(sondage2);

            model.addAttribute("Vote",voteSondageList);
            return "VoteSondage";
        }

    }

