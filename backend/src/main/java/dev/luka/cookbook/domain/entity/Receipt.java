package dev.luka.cookbook.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receipt")
@Getter
@Setter
public class Receipt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type")
    private ReceiptType type;

    @OneToMany(mappedBy = "receipt")
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(name = "description")
    private String description;


}
