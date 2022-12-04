package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceiptTypeRepository extends JpaRepository<ReceiptType, String> {

    Receipt findByName(String name);

    @Query("SELECT t FROM ReceiptType t where t.name like %?1%")
    List<ReceiptType> completeReceiptType(String query);


}
