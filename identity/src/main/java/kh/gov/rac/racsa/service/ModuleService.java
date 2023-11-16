package kh.gov.rac.racsa.service;

import kh.gov.rac.racsa.dto.Module.ModuleRequest;

public interface ModuleService {
    Boolean createModule(ModuleRequest moduleRequest);
}
