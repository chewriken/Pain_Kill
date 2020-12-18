package accessingDataJPA.data;

import accessingDataJPA.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface ClientDAO extends JpaRepository<Client,Long> {

    List<Client> findByNom(String nom);

    @Query(value = "select * from client where login= ?1 and mdp= ?2",nativeQuery = true)
    Client connexion(String login,String mdp);

    @Query(value = "select * from client where login= ?1",nativeQuery = true)
    Client getClientByLogin(String login);

    @Query(value = "select * from client where id_user= ?1",nativeQuery = true)
    Client getClientById(int id);

    @Transactional
    @Modifying
    @Query(value = "update client set nom= ?1 where id_user= ?2",nativeQuery = true)
    void setNom(String nom,int id);

    @Transactional
    @Modifying
    @Query(value = "update client set prenom= ?1 where id_user= ?2",nativeQuery = true)
    void setPrenom(String prenom,int id);

    @Transactional
    @Modifying
    @Query(value = "update client set login= ?1 where id_user= ?2",nativeQuery = true)
    void setLogin(String login,int id);

    @Transactional
    @Modifying
    @Query(value = "update client set mdp= ?1 where id_user= ?2",nativeQuery = true)
    void setMDP(String mdp,int id);

}
