package accessingDataJPA.data;

import accessingDataJPA.model.Client;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientDAO extends JpaRepository<Client,Long> {

    List<Client> findByNom(String nom);
    Client findById(long id);

    @Query(value = "select * from Client where login= ?1 and mdp= ?2",nativeQuery = true)
    Client connexion(String login,String mdp);

    @Query(value = "select * from Client",nativeQuery = true)
    List<Client> selectAll();

    @Query(value = "select * from Client  where prenom=?1",nativeQuery = true)
    List<Client> selectByPrenom(String prenom);

    @Modifying
    @Query(value = "insert into Client ( login, mdp, prenom,nom) values (?1, ?2,?3,?4)",
            nativeQuery = true)
    void insertClient(String login, String mdp, String prenom, String nom);
}
