package com.project.store.service;

import com.project.store.domain.Produto;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements ServiceImp<Produto> {

    @Override
    public Produto beforeSave(Produto produto) {
        return produto;
    }

}
