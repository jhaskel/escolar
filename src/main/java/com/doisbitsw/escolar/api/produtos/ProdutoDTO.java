package com.doisbitsw.escolar.api.produtos;

import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class ProdutoDTO {
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
    private List<String> escolas;
    private Long ano;
    private Boolean ativo;
    private String created;
    private String modified;

    public static ProdutoDTO create(Produto produto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produto, ProdutoDTO.class);
    }
}
