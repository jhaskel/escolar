package com.doisbitsw.escolar.api.unidadeEscolar;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UnidadeEscolarDTO {
    private Long id;
    private Long nivelescolar;
    private String nome;
    private String alias;
    private String endereco;
    private String bairro;
    private Long alunos;
    private Boolean ativo;
    private String created;
    private String modified;

    public static UnidadeEscolarDTO create(UnidadeEscolar unidadeEscolar) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(unidadeEscolar, UnidadeEscolarDTO.class);
    }
}
