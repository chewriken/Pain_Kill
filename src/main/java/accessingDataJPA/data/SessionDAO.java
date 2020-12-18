package accessingDataJPA.data;

import accessingDataJPA.model.Client;
import accessingDataJPA.model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface SessionDAO extends JpaRepository<Sessions,Long> {

    @Query(value = "select * from sessions inner join sondage on sessions.id_Sondage=sondage.id " +
            "and inner join client on sessions.id_User=client.id where id_User = ?1",nativeQuery = true)
    Client getSondageByUserId(int id_User);
}
