package accessingDataJPA.data;

import accessingDataJPA.model.VoteSondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface VoteSondageDAO extends JpaRepository<VoteSondage,Long> {

}
