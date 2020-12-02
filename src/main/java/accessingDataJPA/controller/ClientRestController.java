package accessingDataJPA.controller;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestController {

    @Autowired
    ClientDAO clientDAO;

    @GetMapping("/api/inscription")
    public List<Client> clientList(){
        return clientDAO.findAll();
    }

    @PostMapping("/api/inscription")
    public void saveMessage(@RequestBody Client client){
        clientDAO.save(client);
    }
}
