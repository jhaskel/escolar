package com.doisbitsw.escolar.api.pedidos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoDTO {
    private Long id;
    private String code;
    private Long escola;
    private Long nivel;
    private Double total;
    private Long comprador;
    private String status;
    private Long semana;
    private String af;
    private String created;
    private String modified;
    private Boolean ativo;

    public static PedidoDTO create(Pedido pedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoDTO.class);
    }
}
