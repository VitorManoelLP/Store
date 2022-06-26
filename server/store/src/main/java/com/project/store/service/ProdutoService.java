package com.project.store.service;

import com.project.store.domain.Produto;
import com.project.store.repository.ProdutoRepository;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements ServiceImp<Produto> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Override
    public Produto save(Produto entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }
}
