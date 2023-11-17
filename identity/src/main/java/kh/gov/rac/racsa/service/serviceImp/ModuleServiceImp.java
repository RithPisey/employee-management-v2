package kh.gov.rac.racsa.service.serviceImp;

import kh.gov.rac.racsa.dao.Module.ModuleDao;
import kh.gov.rac.racsa.dto.Module.ModuleFilterInputDTO;
import kh.gov.rac.racsa.dto.Module.ModuleRequestDTO;
import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.repository.ModuleRepository;
import kh.gov.rac.racsa.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModuleServiceImp implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public Boolean createModule(ModuleRequestDTO moduleRequestDTO) {
        return null;
    }
    @Override
    public List<Module> getModule(int page, int size, String orderBy, String orderType, ModuleFilterInputDTO filter) {
//
        Pageable pageable = PageRequest.of(page, size);
        Page<Module> modules = moduleRepository
                .findAll(ModuleDao.moduleSpecification(page,size,orderBy,orderType,filter),pageable);
        return modules
                .stream()
                .collect(Collectors.toList());
    }

}
