package accessingDataJPA.data;

import accessingDataJPA.model.VoteSondage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface VoteSondageDAO extends JpaRepository<VoteSondage,Long> {

    @Query(value = "select * from vote_sondage where id= ?1",nativeQuery = true)
    VoteSondage getVoteSondageById(long id);

    @Transactional
    @Modifying
    @Query(value = "update vote_sondage set status= ?1 where id= ?2", nativeQuery = true)
    void setStatus(Boolean status, long id);
}
