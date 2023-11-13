package kh.gov.rac.racsa.config;

import kh.gov.rac.racsa.model.User;
import kh.gov.rac.racsa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public IUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> credential = userRepository.findByEmail(email);
        if(credential.isPresent()){
            if(credential.get().getDeletedAt() !=null) throw new UsernameNotFoundException("user is not active :" + email);
        }
        return credential.map(IUserDetails::new).orElseThrow(()
                -> new UsernameNotFoundException("user not found with email :" + email));
    }
}
