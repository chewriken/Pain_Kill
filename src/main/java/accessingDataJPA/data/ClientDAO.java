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

    @Query(value = "select * from client where login= ?1 and mdp= ?2",nativeQuery = true)
    Client connexion(String login,String mdp);

    @Query(value = "select * from client where login= ?1",nativeQuery = true)
    Client getClientByLogin(String login);

    @Query(value = "select * from client where id= ?1",nativeQuery = true)
    Client getClientById(int id);

    @Modifying
    @Query(value = "update client set nom= ?1 where id= ?2",nativeQuery = true)
    Client setNom(String nom,int id);

    @Modifying
    @Query(value = "update client set prenom= ?1 where id= ?2",nativeQuery = true)
    Client setPrenom(String prenom,int id);

    @Modifying
    @Query(value = "update client set login= ?1 where id= ?2",nativeQuery = true)
    Client setLogin(String loginn,int id);

    @Modifying
    @Query(value = "update client set mdp= ?1 where id= ?2",nativeQuery = true)
    Client setMDP(String mdp,int id);

}
