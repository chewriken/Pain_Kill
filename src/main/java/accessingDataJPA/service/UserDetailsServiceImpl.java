package accessingDataJPA.service;

import accessingDataJPA.data.ClientDAO;
import accessingDataJPA.data.MyUserDetails;
import accessingDataJPA.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientDAO.getClientByLogin(username);

        if (client == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(client);
    }
}