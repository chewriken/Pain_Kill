package accessingDataJPA.controller;

import accessingDataJPA.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping
    public String showClient(Model model){
        return "ClientPage";
    }
}
