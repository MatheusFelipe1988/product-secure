package com.system.security.controller;

import com.system.security.domain.Produto;
import com.system.security.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Produto> listAll(){
        return service.listAll();
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return service.create(produto);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Produto update(@RequestBody Produto produto){
        return service.update(produto);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        service.delete(id);
    }

}
