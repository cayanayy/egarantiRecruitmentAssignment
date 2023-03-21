package egaranti.cayan.recruitmentAssignment.dataaccess;

import egaranti.cayan.recruitmentAssignment.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
