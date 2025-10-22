package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
//As anotações a cima, define a classe Payment como uma entidade e mapeia para a tabela tb_payment.
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //A chave primária
    //id é gerada automaticamente pelo banco de dados.
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME Zone")
    //Especifica como o campo moment deve ser armazenado no banco de dados.
private Instant moment;
    @OneToOne
    @MapsId
    //Estas anotações estabelecem um relacionamento um-para-um com a entidade Order. @MapsId indica que o id de Payment será mapeado para o mesmo id de Order, compartilhando assim a chave primária entre as duas entidades.
private Order order;

    public Payment() {

    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}