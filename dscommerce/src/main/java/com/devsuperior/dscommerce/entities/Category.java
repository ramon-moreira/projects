package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
//As anotações a cima, indicam que esta classe é uma entidade JPA e será mapeada para a tabela tb_category no banco de dados.
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Já essas outras duas anotações, indicam que o campo id é a chave primária da tabela e que será gerado automaticamente pelo banco de dados.
    private Long id;
private String name;
@ManyToMany(mappedBy = "categories")
private Set<Product> products = new HashSet<>();

    public Category() {

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
