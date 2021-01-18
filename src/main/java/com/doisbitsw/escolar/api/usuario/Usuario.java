package com.doisbitsw.escolar.api.usuario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String urlFoto;
    private String cpf;
    private String recuperar;
    private String celular;
    private String role;
    private Boolean ativo;
    private String created;
    private String modified;
    private String nivel;





}

