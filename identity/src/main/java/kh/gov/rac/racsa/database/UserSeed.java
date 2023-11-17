package kh.gov.rac.racsa.database;

import kh.gov.rac.racsa.enums.StatusEnum;
import kh.gov.rac.racsa.model.Role;
import kh.gov.rac.racsa.model.User;
import kh.gov.rac.racsa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeed implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        Role role = new Role();
        role.setId(1L);
        user.setId(1L);
        user.setEmail("developer@rac.com.kh");
        user.setPassword(passwordEncoder.encode("$rac@123$"));
        user.setStatus(StatusEnum.ACTIVE);
        user.setRole(role);

        userRepository.save(user);

    }
}
