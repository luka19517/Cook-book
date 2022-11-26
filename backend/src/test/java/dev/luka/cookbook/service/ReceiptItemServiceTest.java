package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@Configurable
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@SpringBootTest
public class ReceiptItemServiceTest {

    @Autowired
    private ReceiptItemService receiptItemService;

    @Autowired
    private ReceiptService receiptService;

    @Test
    public void testInsertUpdate() {
        ReceiptModel receiptModel = new ReceiptModel();
        receiptModel.setName("Baklava");
        receiptModel = receiptService.insert(receiptModel);

        ReceiptItemModel receiptItemModel = new ReceiptItemModel();
        receiptItemModel.setName("Secer");
        receiptItemModel.setQuantity(2.9);
        receiptItemModel.setReceipt(receiptModel);
        receiptItemModel = receiptItemService.insert(receiptItemModel);
        Assertions.assertEquals(2.9, receiptItemService.getAll().get(0).getQuantity());
        receiptItemModel.setQuantity(3.0);
        receiptItemService.update(receiptItemModel);
        Assertions.assertEquals(3.0, receiptItemService.getAll().get(0).getQuantity());
        Assertions.assertEquals(1, receiptItemService.getAll().size());
        Assertions.assertEquals(1, receiptItemService.getAllItemsForReceipt(receiptModel).size());

    }

    @Test
    public void testDelete() {
        ReceiptModel receiptModel = new ReceiptModel();
        receiptModel.setName("Baklava");
        receiptModel = receiptService.insert(receiptModel);

        ReceiptItemModel receiptItemModel = new ReceiptItemModel();
        receiptItemModel.setName("Voda");
        receiptItemModel.setReceipt(receiptModel);
        receiptItemModel.setQuantity(21.2);
        receiptItemModel = receiptItemService.insert(receiptItemModel);

        ReceiptItemModel receiptItemModel1 = new ReceiptItemModel();
        receiptItemModel1.setId((long) 21);
        receiptItemModel1.setName("Limun");
        receiptItemModel1.setQuantity(2.0);
        receiptItemService.delete(receiptItemModel1);
        Assertions.assertEquals(1, receiptItemService.getAll().size());
        receiptItemService.delete(receiptItemModel);

        Assertions.assertEquals(0, receiptItemService.getAll().size());


    }

}
