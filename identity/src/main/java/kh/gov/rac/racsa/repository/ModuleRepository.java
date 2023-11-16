package kh.gov.rac.racsa.repository;

import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
}
