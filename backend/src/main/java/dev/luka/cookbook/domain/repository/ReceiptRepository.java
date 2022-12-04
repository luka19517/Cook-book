package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Receipt findByName(String name);

    @Query("SELECT r FROM Receipt r WHERE r.name like %?1%")
    List<Receipt> completeReceipt(String query);

}
