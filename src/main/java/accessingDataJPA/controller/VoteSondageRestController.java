package accessingDataJPA.controller;

import accessingDataJPA.data.SondageDAO;
import accessingDataJPA.model.Sondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class VoteSondageRestController {
   @Autowired
   SondageDAO sondageDAO;

   @GetMapping("/api/voteSondage")
   public List<Sondage> voteSondageList(){
       return sondageDAO.findAll();
   }


    @PostMapping
    public void saveVoteSondage(@RequestBody Sondage voteSondage){
       sondageDAO.save(voteSondage);
    }
}
