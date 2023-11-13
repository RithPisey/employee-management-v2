package kh.gov.rac.racsa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "module_permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModulePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}
