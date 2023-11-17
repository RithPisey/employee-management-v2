package kh.gov.rac.racsa.model;


import jakarta.persistence.*;
import kh.gov.rac.racsa.enums.StatusEnum;
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
    private Integer org_id;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "branch_name", length = 150)
    private String branch_name;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "alt_phone", length = 100)
    private String alt_phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "created_at" ,updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;

}
