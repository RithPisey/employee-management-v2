package kh.gov.rac.racsa.service.serviceImp;

import kh.gov.rac.racsa.dto.Module.ModuleRequest;
import kh.gov.rac.racsa.repository.ModuleRepository;
import kh.gov.rac.racsa.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModuleServiceImp implements ModuleService {

    private final ModuleRepository moduleRepository;
    @Override
    public Boolean createModule(ModuleRequest moduleRequest) {

        return null;
    }
}
