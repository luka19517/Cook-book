package dev.luka.cookbook.domain.repository;

import dev.luka.cookbook.domain.entity.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

}
