package com.doisbitsw.escolar.api.cart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long escola;
    private Long comprador;
    private Long produto;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Long obs;
    private String created;
    private Boolean ativo;






}

