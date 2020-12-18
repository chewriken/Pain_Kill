package accessingDataJPA.controller;

import accessingDataJPA.data.VoteSondageDAO;
import accessingDataJPA.model.VoteSondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class VoteSondageRestController {
   @Autowired
    VoteSondageDAO voteSondageDAO;

   @GetMapping("/api/voteSondage")
   public List<VoteSondage> voteSondageList(){
       return voteSondageDAO.findAll();
   }


    @PostMapping
    public void saveVoteSondage(@RequestBody VoteSondage voteSondage){
       voteSondageDAO.save(voteSondage);
    }
}
