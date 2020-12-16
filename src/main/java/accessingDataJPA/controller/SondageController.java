package accessingDataJPA.controller;

import accessingDataJPA.data.SondageDAO;
import accessingDataJPA.model.Sondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SondageController {

    @Autowired
    private SondageDAO sondageDAO;


    @PostMapping("/creation_sondage")
    public String postSondage(@ModelAttribute Sondage newSondage) {
        Sondage sondage = new Sondage(newSondage.getId(), newSondage.getName(), newSondage.getPlace(), newSondage.getDate(), newSondage.getDescription(), false);
        sondageDAO.save(sondage);

        return "redirect:sondage";
    }

    @GetMapping("/sondage")
    public String showSondage(Model model){

        model.addAttribute("sdglist",sondageDAO.findAll());
        model.addAttribute("newSondage", new Sondage());

        return "sondage";
    }

    @GetMapping("/creation_sondage")
    public String showCreate(Model model){

        model.addAttribute("sdglist",sondageDAO.findAll());
        model.addAttribute("newSondage", new Sondage());

        return "creation_sondage";
    }
}

