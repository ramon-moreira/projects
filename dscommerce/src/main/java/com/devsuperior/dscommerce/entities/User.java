package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity //Declara que a classe é uma entidade JPA, que será mapeada para uma tabela no banco de dados.
@Table(name = "tb_user") //Especifica o nome da tabela no banco de dados.
public class User {
    @Id //Indica que o campo é a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configura a geração automática dos valores da chave primária, delegando ao banco de dados a responsabilidade de gerar o identificador único.
    private Long id;
    private String name;
    @Column(unique = true) //Define que a coluna email deve ser única no banco de dados.
    private String email;
    private String phone;
    private LocalDate birthDate; //Utiliza a classe LocalDate para armazenar datas sem informação de tempo.
    private String password;
@OneToMany(mappedBy = "client") //Define um relacionamento de um-para-muitos entre User e Order. O atributo mappedBy indica que a classe Order possui o campo client que mantém o relacionamento.
private List<Order> orders = new ArrayList<>();

public User() {

    }

    public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
