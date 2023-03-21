package egaranti.cayan.recruitmentAssignment.business.concretes;

import egaranti.cayan.recruitmentAssignment.business.abstracts.RoleService;
import egaranti.cayan.recruitmentAssignment.dataaccess.RoleRepository;
import egaranti.cayan.recruitmentAssignment.entities.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public void assignRoleToEmployee(Role role) {
        roleRepository.save(role);
    }
}
