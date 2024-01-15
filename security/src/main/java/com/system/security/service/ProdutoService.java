package com.system.security.service;


import com.system.security.domain.Produto;

import java.util.List;

public interface ProdutoService {
     List<Produto> listAll();
     Produto create(Produto produto);
     Produto update(Produto produto);
     void delete(Long id);

}
