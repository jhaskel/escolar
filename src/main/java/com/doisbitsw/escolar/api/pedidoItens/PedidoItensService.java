package com.doisbitsw.escolar.api.pedidoItens;

import com.doisbitsw.escolar.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoItensService {

    @Autowired

    private PedidoItensRepository rep;
    public List<PedidoItensDTO> getCarros() {
        List<PedidoItensDTO> list = rep.findAll().stream().map(PedidoItensDTO::create).collect(Collectors.toList());
        return list;
    }

    public PedidoItensDTO getCarroById(Long id) {
        Optional<PedidoItens> carro = rep.findById(id);
        return carro.map(PedidoItensDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public PedidoItensDTO insert(PedidoItens pedidoItens) {
        Assert.isNull(pedidoItens.getId(),"Não foi possível inserir o registro");
        return PedidoItensDTO.create(rep.save(pedidoItens));
    }

    public PedidoItensDTO update(PedidoItens pedidoItens, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<PedidoItens> optional = rep.findById(id);
        if(optional.isPresent()) {
            PedidoItens db = optional.get();
            // Copiar as propriedades
            db.setAlias(pedidoItens.getAlias());
            db.setIsaf(pedidoItens.getIsaf());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return PedidoItensDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
