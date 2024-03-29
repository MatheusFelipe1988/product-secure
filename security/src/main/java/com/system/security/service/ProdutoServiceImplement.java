package com.system.security.service;

import com.system.security.domain.Produto;
import com.system.security.repository.ProdutoRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImplement implements ProdutoService{
    @Autowired
    private ProdutoRepository repository;
    @Override
    public List<Produto> listAll() {
        return repository.findAll();
    }

    @Override
    public Produto create(Produto produto) {
        if (produto.getId() != null) {
            throw new RuntimeException("To create an record, is not Id");
        }
        return repository.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        if(produto.getId() == null){
            throw new RuntimeException("To update an record, is not id");
        }

        return repository.save(produto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
