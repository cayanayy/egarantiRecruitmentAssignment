package egaranti.cayan.recruitmentAssignment.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "stores")
@EntityListeners(AuditingEntityListener.class)
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store")
    private List<Employee> employees;

    @OneToMany(mappedBy = "store")
    private List<Expense> expenses = new ArrayList<>();
}
