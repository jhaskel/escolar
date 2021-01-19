package com.doisbitsw.escolar.api.produtos;

import com.doisbitsw.escolar.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired

    private ProdutoRepository rep;
    public List<ProdutoDTO> getCarros() {
        List<ProdutoDTO> list = rep.findAll().stream().map(ProdutoDTO::create).collect(Collectors.toList());
        return list;
    }

    public ProdutoDTO getCarroById(Long id) {
        Optional<Produto> carro = rep.findById(id);
        return carro.map(ProdutoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<ProdutoDTO> getCarrosByCode(String code) {
        return rep.findByCode(code).stream().map(ProdutoDTO::create).collect(Collectors.toList());
    }

    public ProdutoDTO insert(Produto produto) {
        Assert.isNull(produto.getId(),"Não foi possível inserir o registro");
        return ProdutoDTO.create(rep.save(produto));
    }

    public ProdutoDTO update(Produto produto, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Produto> optional = rep.findById(id);
        if(optional.isPresent()) {
            Produto db = optional.get();
            // Copiar as propriedades
            db.setNome(produto.getNome());
            db.setAlias(produto.getAlias());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ProdutoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
