package accessingDataJPA.controller;
import java.util.ArrayList;
import java.util.List;

import accessingDataJPA.data.VoteSondageDAO;
import accessingDataJPA.model.VoteSondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class VoteSondageController {

    @Autowired
    private VoteSondageDAO voteSondageDAO;

        @GetMapping("/VoteSondage")
        public String showVote(Model model){

            model.addAttribute("Vote", voteSondageDAO.findAll());
            model.addAttribute("newVote", new VoteSondage());
            return "VoteSondage";
        }

        @PostMapping("/VoteSondage")
        public String postMessage(@ModelAttribute VoteSondage newVote){
            VoteSondage voteSondage = new VoteSondage(newVote.getSession(), newVote.getDate(), newVote.getDescription());
            voteSondageDAO.save(voteSondage);
            return "redirect:VoteSondage";
    }
    }

