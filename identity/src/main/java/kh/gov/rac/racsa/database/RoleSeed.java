package kh.gov.rac.racsa.database;

import kh.gov.rac.racsa.model.Role;
import kh.gov.rac.racsa.model.User;
import kh.gov.rac.racsa.repository.RoleRepository;
import kh.gov.rac.racsa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RoleSeed implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("developer");
        role.setUserTypeId(1);

        roleRepository.save(role);

    }
}
