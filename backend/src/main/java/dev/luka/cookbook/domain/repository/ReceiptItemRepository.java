package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {

    List<ReceiptItem> findByReceipt(Receipt receipt);

    List<ReceiptItem> findAll();

}
