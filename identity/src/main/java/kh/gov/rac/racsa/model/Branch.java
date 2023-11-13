package kh.gov.rac.racsa.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "branch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "branch_name", length = 150)
    private String branchName;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "alt_phone", length = 100)
    private String altPhone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
