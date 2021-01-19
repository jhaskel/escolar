package com.doisbitsw.escolar.api.pedidoItens;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoItensDTO {
    private Long id;
    private String pedido;
    private Long produto;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Boolean isaf;
    private Long obs;
    private String created;

    public static PedidoItensDTO create(PedidoItens pedidoItens) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedidoItens, PedidoItensDTO.class);
    }
}
