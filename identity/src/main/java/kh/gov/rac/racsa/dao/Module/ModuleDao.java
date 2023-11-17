package kh.gov.rac.racsa.dao.Module;

import jakarta.persistence.criteria.Path;
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
            // Sorting
            if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
                Path<Object> orderByPath = root.get(orderBy);
                if ("asc".equalsIgnoreCase(orderType)) {
                    query.orderBy(criteriaBuilder.asc(orderByPath));
                } else if ("desc".equalsIgnoreCase(orderType)) {
                    query.orderBy(criteriaBuilder.desc(orderByPath));
                }
            }
            // Filter
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null && filter.getSearch() != null) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("name"), "%" + filter.getSearch() + "%"),
                        criteriaBuilder.like(root.get("module_key"), "%" + filter.getSearch() + "%")
                ));
            }

            // Combine predicates using AND
            if (!predicates.isEmpty()) {
                query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            }

            return query.getRestriction();
        });
    }
}
