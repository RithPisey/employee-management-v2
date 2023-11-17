package kh.gov.rac.racsa.model;

import jakarta.persistence.*;
import kh.gov.rac.racsa.enums.StatusEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @Column(name = "branch_id")
    private String branch_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "deleted_at")
    private Date deleted_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Column(name = "created_by")
    private LocalDateTime created_by;

}
