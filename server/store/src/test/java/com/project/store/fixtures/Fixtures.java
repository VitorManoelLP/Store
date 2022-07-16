package com.project.store.fixtures;

import com.project.store.domain.Produto;
import com.project.store.domain.Usuario;

import java.math.BigDecimal;

public final class Fixtures {

    private Fixtures() {
    }

    public static Usuario createUsuario(Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome("Teste");
        usuario.setEmail("teste@gmail.com");
        usuario.setSenha("123");

        return usuario;
    }

    public static Produto createProduto(Long id) {

        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome("TesteProduto");
        produto.setValor(new BigDecimal("100"));
        produto.setDescricao("TesteDescricao");

        return produto;
    }


}
