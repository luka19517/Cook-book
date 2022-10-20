package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReceiptItemRepository extends CrudRepository<ReceiptItem, Long> {

    List<ReceiptItem> findByReceipt(Receipt receipt);

}
