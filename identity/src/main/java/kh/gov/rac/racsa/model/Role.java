package kh.gov.rac.racsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType user_type;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @Column(name = "role_name", length = 150)
    private String role_name;

    @Column(name = "role_desc", columnDefinition = "text")
    private String role_desc;

    @Column(name = "created_at" ,updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    Set<User> user;

}
