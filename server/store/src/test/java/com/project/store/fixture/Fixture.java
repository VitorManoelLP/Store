package com.project.store.fixture;

import com.project.store.domain.Usuario;

public final class Fixture {

    private Fixture() {
    }

    public static Usuario createUsuario(Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome("Teste");
        usuario.setEmail("teste@gmail.com");
        usuario.setSenha("123");

        return usuario;
    }

}
