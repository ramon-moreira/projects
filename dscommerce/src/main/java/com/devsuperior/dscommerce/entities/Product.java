package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
//As anotações a cima, indicam que esta classe é uma entidade JPA e será mapeada para a tabela tb_product no banco de dados.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Já essas outras duas anotações, indicam que o campo id é a chave primária da tabela e que será gerado automaticamente pelo banco de dados.
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    //Define que o campo description deve ser armazenado como texto, o que é útil para descrições longas que excedem o limite padrão de caracteres.
    private String description;
    private Double price;
    private String imgURL;
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
     private Set<Category> categories = new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set <OrderItem > items = new HashSet <>();

    public Product() {

    }

    public Product(Long id, String name, String description, Double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set <OrderItem > getItems() {
        return items;
    }

    public List<Order > getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
