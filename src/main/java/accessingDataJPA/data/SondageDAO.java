package accessingDataJPA.data;


import accessingDataJPA.model.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface SondageDAO extends JpaRepository<Sondage,Long>{

    @Query(value = "select * from sondage where id_sondage= ?1",nativeQuery = true)
    Sondage getVoteSondageById(long id);

    @Query(value = "select * from sondage where name = ?1",nativeQuery = true)
    Sondage getVoteSondageByName(String name);

    @Transactional
    @Modifying
    @Query(value = "update sondage set status = ?1 from sessions natural join client where sessions.id_sondage = ?2 and sessions.id_user = ?3", nativeQuery = true)
    void setStatus(Boolean status, long id_sondage, int id_client);
}
