package com.doisbitsw.escolar.api.fornecedor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String celular;
    private Boolean ativo;
    private String created;
    private String modified;




}

