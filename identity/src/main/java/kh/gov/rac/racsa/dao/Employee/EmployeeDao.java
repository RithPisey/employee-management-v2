package kh.gov.rac.racsa.dao.Employee;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import kh.gov.rac.racsa.model.Organization;
import kh.gov.rac.racsa.model.Role;
import kh.gov.rac.racsa.model.User;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeDao {
    Specification<User> userSpecification(String email){
        return (root, query, criteriaBuilder)->{
            query.where(criteriaBuilder.equal(root.get("email"),email));
            Join<User, Role> userRoleJoin = root.join("role", JoinType.INNER);
            userRoleJoin.on(criteriaBuilder.equal(root.get("role_id"),userRoleJoin.get("id")));
            Join<User, Organization> userOrganizationJoin = root.join("organization",JoinType.INNER);
            query.multiselect(
                    root.get("id")
            );

            return null;
        };
    }
}
