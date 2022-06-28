package com.project.store.service;

import com.project.store.domain.Produto;
import com.project.store.repository.ProdutoRepository;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "usuarioCache")
@Service
public class ProdutoService implements ServiceImp<Produto> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    @Cacheable(cacheNames = "getAllProduto")
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "getAllProduto")
    public Produto save(Produto entity) {
        return repository.save(entity);
    }

    @Override
    @CacheEvict(cacheNames = "getAllProduto")
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @CachePut(cacheNames = "getAllProduto")
    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }
}
