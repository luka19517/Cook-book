package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findAll();

    Receipt findByName(String name);


}
