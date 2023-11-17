package kh.gov.rac.racsa.repository;

import kh.gov.rac.racsa.dao.Module.ModuleDao;
import kh.gov.rac.racsa.enums.StatusEnum;
import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    boolean existsByIdNot(Long id);
    Page<Module> findAll(Specification<Module> moduleSpecification, Pageable pageable);
}
