package accessingDataJPA.controller;
import java.util.ArrayList;
import java.util.List;

import accessingDataJPA.model.VoteSondage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class VoteSondageController {

        private List<VoteSondage> voteSondageList = new ArrayList();

        @PostMapping("/VoteSondage")
        public String postMessage(@ModelAttribute VoteSondage newVote){
            voteSondageList.add(newVote);
            return "redirect:VoteSondage";
        }


        @GetMapping("/VoteSondage")
        public String showVote(Model model){
           /* VoteSondage sondage1 = new VoteSondage(1,"Bleu vs Rouge","Mardi","Affrontement Painball");
            VoteSondage sondage2 = new VoteSondage(2,"Orange vs Violet", "Jeudi","Mélée générale Airsoft");

            voteSondageList.add(sondage1);
            voteSondageList.add(sondage2); */

            model.addAttribute("Vote", voteSondageList);
            model.addAttribute("newVote", new VoteSondage());
            return "VoteSondage";
        }

    }

