package kh.gov.rac.racsa.database;

import kh.gov.rac.racsa.model.User;
import kh.gov.rac.racsa.model.UserType;
import kh.gov.rac.racsa.repository.UserRepository;
import kh.gov.rac.racsa.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserTypeSeed implements CommandLineRunner {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {


        UserType dev = new UserType();
        dev.setId(1L);
        dev.setType("DEV");
        dev.setLevel(10);

        UserType org = new UserType();
        org.setId(2L);
        org.setType("ORGANIZATION");
        org.setLevel(9);

        UserType branch = new UserType();
        branch.setId(3L);
        branch.setType("BRANCH");
        branch.setLevel(8);

        UserType user = new UserType();
        user.setId(4L);
        user.setType("USER");
        user.setLevel(1);

        userTypeRepository.save(dev);
        userTypeRepository.save(org);
        userTypeRepository.save(branch);
        userTypeRepository.save(user);
    }
}
