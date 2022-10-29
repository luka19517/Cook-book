package dev.luka.cookbook.domain.entity;


import dev.luka.cookbook.model.ReceiptItemModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="receiptitem")
@Getter
@Setter
public class ReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name="receipt", referencedColumnName = "id")
    private Receipt receipt;

}
