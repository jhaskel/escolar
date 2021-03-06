package com.doisbitsw.escolar.api.produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoria;
    private Long fornecedor;
    private String code;
    private String nome;
    private String alias;
    private Double quantidade;
    private Double valor;
    private String unidade;
    private String image;
    private Boolean agrofamiliar;
    private String escolas;
    private Long ano;
    private Boolean ativo;
    private String created;
    private String modified;




}

