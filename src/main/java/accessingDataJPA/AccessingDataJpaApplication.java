package accessingDataJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

   /* @Bean
    public CommandLineRunner demo(ClientRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Client("Jack", "Bauer","JB","1234"));
            repository.save(new Client("Chloe", "O'Brian","OC","1234"));
            repository.save(new Client("Kim", "Bauer","KB","1234"));
            repository.save(new Client("David", "Palmer","DP","1234"));
            repository.save(new Client("Michelle", "Dessler","MD","1234"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Client customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Client customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByNom('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByNom("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");

            // connexion
            Client customer2 = repository.connexion("JB","1234");
            log.info("Client connect");
            log.info("--------------------------------");
            log.info(customer2.toString());
            log.info("");

            // fetch all customers
            log.info("Customers found with selectAll():");
            log.info("-------------------------------");
            for (Client customer3 : repository.selectAll()) {
                log.info(customer3.toString());
            }
            log.info("");

            //insertion client
            repository.save(new Client("Adil","Bahou","AB","1234"));
            log.info("Customers found by name:");
            log.info("-------------------------------");
            for (Client customer4 : repository.selectByPrenom("Adil")) {
                log.info(customer4.toString());
            }
            log.info("");

        };
    }*/

}