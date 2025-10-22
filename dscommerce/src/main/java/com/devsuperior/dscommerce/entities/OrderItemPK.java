package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
//Marca a classe como incorporável em outras entidades.
public class OrderItemPK {
    @ManyToOne
    //Define um relacionamento muitos-para-um, significando que muitos itens de pedido podem estar associados a um único pedido ou produto.
    @JoinColumn(name = "order_id")
    //Especifica o nome da coluna na tabela que estabelece o vínculo.
    private Order order;
    @ManyToOne
    //Define um relacionamento muitos-para-um, significando que muitos itens de pedido podem estar associados a um único pedido ou produto.
    @JoinColumn(name = "product_id")
    //Especifica o nome da coluna na tabela que estabelece o vínculo.
    private Product product;

    public OrderItemPK() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
