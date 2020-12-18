package accessingDataJPA.controller;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.model.Client;
import accessingDataJPA.service.SecurityService;
import accessingDataJPA.service.UserService;
import accessingDataJPA.validator.ClientValidator;
import accessingDataJPA.validator.ModificationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class InscriptionController {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private SecurityService securityService;


    @Autowired
    private ClientValidator clientValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private ModificationValidator modificationValidator;

    @GetMapping("/inscription")
    public String showInscription(Model model){
        model.addAttribute("user", new Client());
        return "InscriptionPage.html";
    }

    @PostMapping("/inscription")
    public String registration(@ModelAttribute("user")Client client,BindingResult bindingResult){
        clientValidator.validate(client,bindingResult);
        if (bindingResult.hasErrors()){  return "InscriptionPage";  }

        client.setRole("ROLE_USER");
        userService.save(client);
        securityService.autoLogin(client.getLogin(),client.getPasswordConfirm());
        return "redirect:client?id="+client.getId();
    }


    @GetMapping("/client")
    public String showClient(Model model,@RequestParam(value="id") int id){
        Client client = clientDAO.getClientById(id);
        model.addAttribute("client",client);
        return "ClientPage";
    }

    @GetMapping("/monCompte")
    public String showMonCompte(Model model,@RequestParam(value="id") int id){
        Client client = clientDAO.getClientById(id);
        model.addAttribute("client",client);
        model.addAttribute("modificationCompte",new Client());
        return "GestionCompte";
    }

    @PostMapping("/monCompte")
    public String postMonCompte(@ModelAttribute("client") Client newClient,@RequestParam(value="id") int id,BindingResult bindingResult){
        modificationValidator.validate(newClient,bindingResult);
        if (bindingResult.hasErrors()){  return "redirect:monCompte?id="+id; }
        if(!newClient.getNom().equals("")){
            clientDAO.setNom(newClient.getNom(),id);
        }
        if (!newClient.getPrenom().equals("")){
            clientDAO.setPrenom(newClient.getPrenom(),id);
        }
        if (!newClient.getLogin().equals("")){
            clientDAO.setLogin(newClient.getLogin(),id);
        }
        if(!newClient.getMdp().equals("")){
            clientDAO.setMDP(newClient.getLogin(),id);
        }
        return "redirect:client?id="+id;
    }

    @GetMapping({"/","/connexion"})
    public String showConnexion(Model model){
        model.addAttribute("connexion", new Client());
        return "ConnexionPage";
    }

    @PostMapping("/login")
    public String logout(){
        return"redirect:connexion?logout";
    }

}
