package com.doisbitsw.escolar.api.fornecedor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FornecedorDTO {
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

    public static FornecedorDTO create(Fornecedor fornecedor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }
}
