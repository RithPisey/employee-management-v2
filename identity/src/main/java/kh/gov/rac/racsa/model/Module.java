package kh.gov.rac.racsa.model;

import jakarta.persistence.*;
import kh.gov.rac.racsa.enums.StatusEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "module")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "module_key", length = 150, unique = true)
    private String module_key;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;


}
