package accessingDataJPA.controller;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.data.UserDTO;
import accessingDataJPA.exception.UserAlreadyExistException;
import accessingDataJPA.model.Client;
import accessingDataJPA.service.SecurityService;
import accessingDataJPA.service.UserService;
import accessingDataJPA.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/inscription")
    public String showInscription(Model model){
        model.addAttribute("user", new Client());
        return "InscriptionPage";
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
        return "GestionCompte";
    }

    @PostMapping("/monCompte")
    public String postMonCompte(@ModelAttribute Client newclient) {
        List<Client> clientList = clientDAO.findAll();
        for(Client client:clientList){
            if(client.getLogin().equals(newclient.getLogin()) && client.getMdp().equals(newclient.getMdp())){
                return "redirect:client";
            }
        }
        return "redirect:connexion";
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
