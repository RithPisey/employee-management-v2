package kh.gov.rac.racsa.config;

import kh.gov.rac.racsa.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<UserCredential> credential = userRepository.findByEmail(email);
//        if(credential.isPresent()){
//            if(credential.get().getDeletedAt() !=null) throw new UsernameNotFoundException("user is not active :" + email);
//        }
//        return credential.map(CustomUserDetails::new).orElseThrow(()
//                -> new UsernameNotFoundException("user not found with email :" + email));
//    }
//}
