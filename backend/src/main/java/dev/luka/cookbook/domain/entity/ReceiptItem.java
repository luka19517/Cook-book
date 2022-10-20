package dev.luka.cookbook.domain.entity;


import dev.luka.cookbook.model.ReceiptItemModel;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="receiptitem")
@Data
public class ReceiptItem {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name="receipt", referencedColumnName = "id")
    private Receipt receipt;

}
