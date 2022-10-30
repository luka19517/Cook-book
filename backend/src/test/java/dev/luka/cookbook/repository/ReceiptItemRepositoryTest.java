package dev.luka.cookbook.repository;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@Configurable
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ExtendWith(SpringExtension.class)
public class ReceiptItemRepositoryTest {

    @Autowired
    ReceiptItemRepository receiptItemRepo;

    @Autowired
    ReceiptRepository receiptRepo;

    @Test
    public void testCrud() {
        Receipt receipt = new Receipt();
        receipt.setName("Baklava");
        receiptRepo.save(receipt);
        receiptRepo.flush();

        ReceiptItem receiptItem = new ReceiptItem();
        receiptItem.setQuantity(2.0);
        receiptItem.setName("Secer");
        receiptItem.setReceipt(receiptRepo.findById(receipt.getId()).get());
        receiptItemRepo.save(receiptItem);

        receiptItem.setName("Limun");

        Assertions.assertEquals(1, receiptItemRepo.findAll().size());

        Assertions.assertEquals(1,receiptItemRepo.findByReceipt(receiptRepo.findById(receipt.getId()).get()).size());

        receiptItemRepo.delete(receiptItemRepo.findById(receiptItem.getId()).get());

        Assertions.assertEquals(0, receiptItemRepo.findAll().size());

    }

}
