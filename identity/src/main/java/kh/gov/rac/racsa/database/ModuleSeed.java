package kh.gov.rac.racsa.database;

import kh.gov.rac.racsa.enums.StatusEnum;
import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ModuleSeed implements CommandLineRunner {
    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public void run(String... args) throws Exception {
        Module moduleDashboard = new Module();
        moduleDashboard.setId(1L);
        moduleDashboard.setName("dashboard");
        moduleDashboard.setModuleKey("dashboard");
        moduleDashboard.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleDashboard);


        Module moduleOrganization = new Module();
        moduleOrganization.setId(2L);
        moduleOrganization.setName("organization");
        moduleOrganization.setModuleKey("organization");
        moduleOrganization.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleOrganization);

        Module moduleBranch = new Module();
        moduleBranch.setId(2L);
        moduleBranch.setName("branch");
        moduleBranch.setModuleKey("branch");
        moduleBranch.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleBranch);

        Module moduleUserList = new Module();
        moduleUserList.setId(3L);
        moduleUserList.setName("user_list");
        moduleUserList.setModuleKey("user_list");
        moduleUserList.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleUserList);

        Module moduleRole = new Module();
        moduleRole.setId(4L);
        moduleRole.setName("role");
        moduleRole.setModuleKey("role");
        moduleRole.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleRole);

        Module moduleUserLog = new Module();
        moduleUserLog.setId(4L);
        moduleUserLog.setName("user_log");
        moduleUserLog.setModuleKey("user_log");
        moduleUserLog.setStatus(StatusEnum.ACTIVE);
        moduleRepository.save(moduleUserLog);

    }
}
