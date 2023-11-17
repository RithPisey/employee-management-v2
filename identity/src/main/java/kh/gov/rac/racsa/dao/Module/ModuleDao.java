package kh.gov.rac.racsa.dao.Module;

import jakarta.persistence.criteria.Predicate;
import kh.gov.rac.racsa.dto.Module.ModuleFilterInputDTO;
import kh.gov.rac.racsa.model.Module;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ModuleDao {
    public static Specification<Module> moduleSpecification(
            int page,
            int size,
            String orderBy,
            String orderType,
            ModuleFilterInputDTO filter){
        return ((root, query, criteriaBuilder) -> {
            if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
                // Assuming orderBy is a valid field in your Module entity
                if ("asc".equalsIgnoreCase(orderType)) {
                    query.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if ("desc".equalsIgnoreCase(orderType)) {
                    query.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
            // filter
            List<Predicate> orPredicates = new ArrayList<>();

            Predicate orPredicateSearch =
                    criteriaBuilder.or(
                            criteriaBuilder.like(root.get("name"), "%" + filter.getSearch() + "%"),
                            criteriaBuilder.like(root.get("module_key"), "%" + filter.getSearch() + "%")
                    );

            orPredicates.add(orPredicateSearch);


            // combine or
            Predicate orPredicate = criteriaBuilder.or(orPredicates.toArray(new Predicate[0]));

            return orPredicate;
        });
    }
}
