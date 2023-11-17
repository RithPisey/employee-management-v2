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
    @Column(name = "id")
    private Long role_module_id;

    @Column(name = "role_id")
    private Integer role_id;

    @Column(name = "module_key", length = 100)
    private String module_key;

    @Column(name = "permission_id")
    private Integer permission_id;

    @Column(name = "created_at" ,updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;


}
