package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes= TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReceiptItemServiceTest {

    @Autowired
    ReceiptItemService receiptItemService;

    @Test
    public void testService(){
        System.out.println("pozz"+receiptItemService.toString());
        Assert.assertTrue(receiptItemService.getAll().size()>0);
    }
}
