package accessingDataJPA.service;
import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Client client) {
        client.setMdp(bCryptPasswordEncoder.encode(client.getMdp()));
        clientDAO.save(client);
    }

    @Override
    public Client getClientByLogin(String username) {
        return clientDAO.getClientByLogin(username);
    }

}