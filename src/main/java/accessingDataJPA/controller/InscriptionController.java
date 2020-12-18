package accessingDataJPA.controller;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.data.SessionDAO;
import accessingDataJPA.data.SondageDAO;
import accessingDataJPA.model.Client;
import accessingDataJPA.model.Sessions;
import accessingDataJPA.model.Sondage;
import accessingDataJPA.service.SecurityService;
import accessingDataJPA.service.UserService;
import accessingDataJPA.validator.ClientValidator;
import accessingDataJPA.validator.ModificationValidator;
import accessingDataJPA.validator.VoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InscriptionController {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private VoteValidator voteValidator;

    @Autowired
    private ClientValidator clientValidator;

    @Autowired
    private SondageDAO sondageDAO;

    @Autowired
    private SessionDAO sessionDAO;

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
        return "redirect:sondage?id="+client.getIdUser();
    }

    @PostMapping("/creation_sondage")
    public String postSondage(@ModelAttribute Sondage newSondage,@RequestParam(value="id") int id,BindingResult bindingResult){
        voteValidator.validate(newSondage,bindingResult);
        if (bindingResult.hasErrors()){  return "redirect:creation_sondage?id="+id;  }
        List<Client> clientList = clientDAO.findAll();
        Sondage sondage = new Sondage( newSondage.getName(), newSondage.getPlace(), newSondage.getDate(), newSondage.getDescription(), false);
        sondageDAO.save(sondage);

        Sondage sondage1 = sondageDAO.getVoteSondageByName(newSondage.getName());
        for(int i = 0; i<clientList.size();i++){
            Sessions session = new Sessions(clientList.get(i).getIdUser(),sondage1.getIdSondage());
            sessionDAO.save(session);
        }
        return "redirect:sondage?id="+id;
    }

    @GetMapping("/sondage")
    public String showSondage(Model model,@RequestParam(value="id") int id){
        Client client = clientDAO.getClientById(id);
        model.addAttribute("client",client);
        model.addAttribute("sdglist",sondageDAO.findAll());
        model.addAttribute("newSondage", new Sondage());
        return "sondage";
    }

    @GetMapping("/creation_sondage")
    public String showCreate(Model model,@RequestParam(value="id") int id){
        Client client = clientDAO.getClientById(id);
        model.addAttribute("client",client);
        model.addAttribute("sdglist",sondageDAO.findAll());
        model.addAttribute("newSondage", new Sondage());

        return "creation_sondage";
    }

    @GetMapping("/VoteSondage")
    public String showVote(Model model,@RequestParam(value="idVote") long idVote,@RequestParam(value="id") int id){
        Client client = clientDAO.getClientById(id);
        Sondage voteSondage = sondageDAO.getVoteSondageById(idVote);
        model.addAttribute("client",client);
        model.addAttribute("updateVote",voteSondage);
        return "VoteSondage";
    }


    @PostMapping("/UpdateVote")
    public String updateVote(@RequestParam(value="idVote") long idVote,@RequestParam(value="idUser") int idUser){
        Sondage sondage = sondageDAO.getVoteSondageById(idVote);
        if(sondage.getStatus() == true)
        {
            sondageDAO.setStatus(false,idVote,idUser);
        } else {
            sondageDAO.setStatus(true,idVote,idUser);
        }
        return "redirect:sondage?id="+idUser;
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
        return "redirect:sondage?id="+id;
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
