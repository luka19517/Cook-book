package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
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
public class ReceiptServiceTest {

    @Autowired
    private ReceiptService receiptService;

    @Test
    public void testInsertUpdate() {
        ReceiptModel receiptModel = new ReceiptModel();

        receiptModel.setName("Baklava");
        receiptModel = receiptService.insert(receiptModel);
        long startingId = receiptModel.getId();
        receiptModel.setName("Makedonska baklava");
        receiptModel = receiptService.update(receiptModel);

        Assertions.assertEquals("Makedonska baklava", receiptService.getAll().get(0).getName());
        Assertions.assertEquals(startingId, receiptModel.getId());
        Assertions.assertEquals(1, receiptService.getAll().size());
    }

    @Test
    public void testDelete() {
        ReceiptModel receiptModel = new ReceiptModel();

        receiptModel.setName("Baklava");
        receiptModel = receiptService.insert(receiptModel);

        ReceiptModel receiptModel1 = new ReceiptModel();
        receiptModel1.setId((long) 21);
        receiptModel1.setName("Bajadere");
        receiptService.delete(receiptModel1);
        Assertions.assertEquals(1, receiptService.getAll().size());
        receiptService.delete(receiptModel);

        Assertions.assertEquals(0, receiptService.getAll().size());


    }
}
