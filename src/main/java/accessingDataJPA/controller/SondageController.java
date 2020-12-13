package accessingDataJPA.controller;

import accessingDataJPA.model.Sondage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SondageController {
    private List<Sondage> sondageList = new ArrayList<>();

    @PostMapping("/creation_sondage")
    public String postSondage(@ModelAttribute Sondage newSondage) {
        sondageList.add(newSondage);

        return "redirect:sondage";
    }

    @GetMapping("/sondage")
    public String showSondage(Model model){

        model.addAttribute("sdglist",sondageList);
        model.addAttribute("newSondage", new Sondage());

        return "sondage";
    }

    @GetMapping("/creation_sondage")
    public String showCreate(Model model){

        model.addAttribute("sdglist",sondageList);
        model.addAttribute("newSondage", new Sondage());

        return "creation_sondage";
    }
}

