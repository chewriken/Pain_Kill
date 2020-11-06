
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByLastName(String lastName);
    Client findById(long id);
}
