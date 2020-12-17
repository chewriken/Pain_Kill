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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class VoteSondageController {

    @Autowired
    private VoteSondageDAO voteSondageDAO;

        @GetMapping("/VoteSondage")
        public String showVote(Model model){


            model.addAttribute("Vote", voteSondageDAO.findAll());
            model.addAttribute("newVote", new VoteSondage());
            model.addAttribute("updateVote",new VoteSondage());
            return "VoteSondage";
        }

        @PostMapping("/VoteSondage")
        public String postMessage(@ModelAttribute VoteSondage newVote){
            VoteSondage voteSondage = new VoteSondage(newVote.getSession(), newVote.getDate(), newVote.getDescription(),false);
            voteSondageDAO.save(voteSondage);
            voteSondageDAO.setStatus(true, newVote.getId());
            return "redirect:VoteSondage";
    }

        @PostMapping("/UpdateVote")
        public String updateVote(@RequestParam(value="id") long id){
            VoteSondage voteSondage = voteSondageDAO.getVoteSondageById(id);
            if(voteSondage.getStatus() == true)
            {
                voteSondageDAO.setStatus(false,id);
            } else {
                voteSondageDAO.setStatus(true,id);
            }
            return "redirect:VoteSondage";
        }
    }

