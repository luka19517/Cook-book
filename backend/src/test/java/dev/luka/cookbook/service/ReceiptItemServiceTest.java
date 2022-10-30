package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
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
public class ReceiptItemServiceTest {

    @Autowired
    private ReceiptItemService receiptItemService;

    @Autowired
    private ReceiptService receiptService;

    @Test
    public void testService() {
        ReceiptModel receiptModel = new ReceiptModel();
        receiptModel.setName("Baklava");
        receiptService.insert(receiptModel);


        ReceiptItemModel receiptItemModel = new ReceiptItemModel();
        receiptItemModel.setName("Secer");
        receiptItemModel.setQuantity(2.9);
        receiptItemModel.setReceiptModel(receiptModel);
        receiptItemService.insert(receiptItemModel);

        Assertions.assertEquals(1, receiptItemService.getAll().size());
        Assertions.assertEquals(1, receiptItemService.getAllItemsForReceipt(receiptModel).size());

    }

}
