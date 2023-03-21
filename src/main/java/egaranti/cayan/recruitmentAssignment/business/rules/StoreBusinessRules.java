package egaranti.cayan.recruitmentAssignment.business.rules;

import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.NotFoundException;
import egaranti.cayan.recruitmentAssignment.dataaccess.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreBusinessRules {
    private StoreRepository storeRepository;

    public void isStoreExists(Long id) {
        if (!storeRepository.existsById(id)) {
            throw new NotFoundException("Store does not exits!");
        }
    }
}
