package egaranti.cayan.recruitmentAssignment.dataaccess;

import egaranti.cayan.recruitmentAssignment.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
