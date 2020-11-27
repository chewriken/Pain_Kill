package accessingDataJPA.model;

import accessingDataJPA.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Inscription {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/client")
    public Client client(@RequestParam(value = "prenom", defaultValue = "Adil") String name){
        return new Client(name,"Bahou","AB","1234");
    }

}
