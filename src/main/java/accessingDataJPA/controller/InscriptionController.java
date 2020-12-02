package accessingDataJPA.controller;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InscriptionController {
    @Autowired
    private ClientDAO clientDAO;

    @GetMapping("/inscription")
    public String showInscription(Model model){
        model.addAttribute("cltList",clientDAO.findAll());
        model.addAttribute("newClient", new Client());
        return "InscriptionPage";
    }

    @PostMapping("/inscription")
    public String postInscription(@ModelAttribute Client newClient) {
        Client newclient = new Client(newClient.getPrenom(), newClient.getNom(), newClient.getLogin(), newClient.getMdp());
        List<Client> clientList = clientDAO.findAll();
        for(Client client:clientList){
            if(client.getLogin().equals(newClient.getLogin())){
                return "redirect:inscription";
            }
        }
        clientDAO.save(newclient);
        return "ClientPage";
    }

    @GetMapping("/connexion")
    public String showClient(Model model){
        model.addAttribute("connexion", new Client());
        return "ConnexionPage";
    }

    @PostMapping("/connexion")
    public String postConnexion(@ModelAttribute Client newclient) {
        List<Client> clientList = clientDAO.findAll();
        for(Client client:clientList){
            if(client.getLogin().equals(newclient.getLogin()) && client.getMdp().equals(newclient.getMdp())){
                return "ClientPage";
            }
        }
        return "redirect:connexion";
    }
}
