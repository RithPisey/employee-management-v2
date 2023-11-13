package kh.gov.rac.racsa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "role_module")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_module_id")
    private Long roleModuleId;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "module_key", length = 100)
    private String moduleKey;

    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
