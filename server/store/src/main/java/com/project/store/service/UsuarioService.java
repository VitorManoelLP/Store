package com.project.store.service;

import com.project.store.annotation.BeforeSave;
import com.project.store.domain.Produto;
import com.project.store.domain.Usuario;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements ServiceImp<Usuario> {


    @BeforeSave
    public Produto teste(Produto entity) {
        entity.setNome("brabo");
        return entity;
    }

}
