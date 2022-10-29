package dev.luka.cookbook.config;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.service.ReceiptItemService;
import dev.luka.cookbook.service.ReceiptItemServiceImpl;
import dev.luka.cookbook.service.ReceiptService;
import dev.luka.cookbook.service.ReceiptServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@Configuration
@ComponentScan(basePackages = {"dev.luka"})
public class TestConfig {

    @Bean
    ReceiptService receiptService() {
        return new ReceiptServiceImpl();
    }

    @Bean
    ReceiptItemService receiptItemService() {
        return new ReceiptItemServiceImpl();
    }
}
