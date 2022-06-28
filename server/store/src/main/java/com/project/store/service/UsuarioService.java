package com.project.store.service;

import com.project.store.domain.Usuario;
import com.project.store.repository.UsuarioRepository;
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
public class UsuarioService implements ServiceImp<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Cacheable(cacheNames = "getAllUsuarios")
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "getAllUsuarios")
    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }

    @Override
    @CacheEvict(cacheNames = "getAllUsuarios")
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @CachePut(cacheNames = "getAllUsuarios", unless = "#result == null")
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

}
