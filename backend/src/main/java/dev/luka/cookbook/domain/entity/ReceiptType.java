package dev.luka.cookbook.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipttype")
@Getter
@Setter
public class ReceiptType {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

}
