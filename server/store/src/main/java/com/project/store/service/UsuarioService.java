package com.project.store.service;

import com.project.store.domain.Usuario;
import com.project.store.repository.UsuarioRepository;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService implements ServiceImp<Usuario> {

    @Autowired
    private UsuarioRepository repository;


    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

}
