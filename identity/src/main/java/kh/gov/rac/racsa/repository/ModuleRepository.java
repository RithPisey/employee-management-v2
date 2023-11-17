package kh.gov.rac.racsa.repository;

import kh.gov.rac.racsa.dao.Module.ModuleDao;
import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    Page<Module> findAll(Specification<Module> moduleSpecification, Pageable pageable);
}
