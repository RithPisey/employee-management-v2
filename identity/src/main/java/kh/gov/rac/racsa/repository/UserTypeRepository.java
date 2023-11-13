package kh.gov.rac.racsa.repository;

import kh.gov.rac.racsa.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
