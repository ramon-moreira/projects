package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_order")
//As anotações a cima, indicam que esta classe é uma entidade JPA e será mapeada para a tabela tb_order no banco de dados.
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Já essas outras duas anotações, indicam que o campo id é a chave primária da tabela e que será gerado automaticamente pelo banco de dados.
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    //Especifica que o campo moment deve ser armazenado como um timestamp sem informações de fuso horário.
    private Instant moment;
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    //Essas duas anotações a cima, estabelecem um relacionamento muitos-para-um entre Order e User. O JoinColumn indica que a coluna client_id na tabela tb_order é a chave estrangeira que referencia a tabela tb_user.
    private User client;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
//Configura o relacionamento de mão dupla, onde mappedBy aponta para o campo order na entidade Payment. A opção cascade = CascadeType.ALL significa que as operações de persistência, atualização ou exclusão em Order serão propagadas para Payment.
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem > items = new HashSet<>();

    public Order() {

    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set <OrderItem > getItems() {
        return items;
    }

    public List<Product > getProducts() {
        return items.stream().map(x -> x.getProduct()).toList();
    }

}