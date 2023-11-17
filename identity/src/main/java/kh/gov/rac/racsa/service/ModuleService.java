package kh.gov.rac.racsa.service;

import kh.gov.rac.racsa.dto.Module.ModuleFilterInputDTO;
import kh.gov.rac.racsa.dto.Module.ModuleRequestDTO;
import kh.gov.rac.racsa.model.Module;

import java.util.Set;

public interface ModuleService {
    Boolean createModule(ModuleRequestDTO moduleRequestDTO);

    Set<Module> getModule(int page, int size, String orderBy, String orderType, ModuleFilterInputDTO filter);
}
