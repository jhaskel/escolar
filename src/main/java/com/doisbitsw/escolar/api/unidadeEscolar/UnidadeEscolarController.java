package com.doisbitsw.escolar.api.unidadeEscolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/escolas")
public class UnidadeEscolarController {
    @Autowired
    private UnidadeEscolarService service;


    @GetMapping()
    public ResponseEntity get() {
        List<UnidadeEscolarDTO> carros = service.getNivel();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        UnidadeEscolarDTO carro = service.getNivelById(id);

        return ResponseEntity.ok(carro);
    }



    @PostMapping

    public ResponseEntity post(@RequestBody UnidadeEscolar unidadeEscolar) {

        UnidadeEscolarDTO c = service.insert(unidadeEscolar);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody UnidadeEscolar unidadeEscolar) {

        unidadeEscolar.setId(id);

        UnidadeEscolarDTO c = service.update(unidadeEscolar, id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
