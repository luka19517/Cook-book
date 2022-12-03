package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptTypeRepository extends JpaRepository<ReceiptType, String> {

    Receipt findByName(String name);


}
