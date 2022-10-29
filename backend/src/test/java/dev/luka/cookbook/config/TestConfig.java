package dev.luka.cookbook.config;

import dev.luka.cookbook.service.ReceiptItemService;
import dev.luka.cookbook.service.ReceiptItemServiceImpl;
import dev.luka.cookbook.service.ReceiptService;
import dev.luka.cookbook.service.ReceiptServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"dev.luka.cookbook.domain.repository"})
@ImportResource("classpath:META-INF/spring/applicationContext-domain-test.xml")
@EnableTransactionManagement
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
