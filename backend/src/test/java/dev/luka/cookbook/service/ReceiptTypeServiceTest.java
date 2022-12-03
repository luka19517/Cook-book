package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.model.ReceiptTypeModel;
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
public class ReceiptTypeServiceTest {

    @Autowired
    private ReceiptTypeService receiptTypeService;


    @Test
    public void testInsertUpdateDelete() {
        Assertions.assertEquals(0, receiptTypeService.getAll().size());

        ReceiptTypeModel receiptTypeModel1 = new ReceiptTypeModel();
        receiptTypeModel1.setId("dezert");
        receiptTypeModel1.setName("Dezert");

        receiptTypeModel1 = receiptTypeService.save(receiptTypeModel1);
        Assertions.assertEquals("dezert", receiptTypeModel1.getId());
        Assertions.assertEquals(1, receiptTypeService.getAll().size());

        ReceiptTypeModel receiptTypeModel2 = receiptTypeService.getForId("dezert");
        receiptTypeModel2.setName("Dezert2");
        receiptTypeService.save(receiptTypeModel2);

        receiptTypeModel2 = receiptTypeService.getForId("dezert");
        Assertions.assertEquals("Dezert2", receiptTypeModel2.getName());

        receiptTypeService.delete(receiptTypeModel2);

        Assertions.assertEquals(0, receiptTypeService.getAll().size());

    }

}
