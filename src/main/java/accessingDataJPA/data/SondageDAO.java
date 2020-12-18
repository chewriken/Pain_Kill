package accessingDataJPA.data;


import accessingDataJPA.model.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SondageDAO extends JpaRepository<Sondage,Long>{
}
