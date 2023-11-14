package kh.gov.rac.racsa.dao.Employee;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import kh.gov.rac.racsa.model.*;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeDao {
    Specification<User> userSpecification(String email){
        return (root, query, criteriaBuilder)->{
            query.where(criteriaBuilder.equal(root.get("email"),email));
            Join<User, Role> userRoleJoin = root.join("role", JoinType.INNER);
            Join<Role, UserType> roleUserTypeJoin = userRoleJoin.join("user_type", JoinType.INNER);
            Join<User,Organization> userOrganizationJoin = root.join("organization",JoinType.INNER);
            Join<User, Branch> userBranchJoin = root.join("branch",JoinType.INNER);
            query.multiselect(
                    root.get("id"),
                    root.get("email"),
                    userRoleJoin.get("id").alias("role_id"),
                    userRoleJoin.get("role_name"),
                    roleUserTypeJoin.get("id").alias("user_type_id"),
                    roleUserTypeJoin.get("type"),
                    userOrganizationJoin.get("id").alias("org_id"),
                    userOrganizationJoin.get("name").alias("org_name"),
                    userOrganizationJoin.get("latin_name").alias("org_latin_name"),
                    userBranchJoin.get("id").alias("branch_id"),
                    userBranchJoin.get("branch_name"),
                    root.get("status"),
                    root.get("created_at"),
                    root.get("created_by")
            );

                return criteriaBuilder.conjunction();
        };
    }
}
