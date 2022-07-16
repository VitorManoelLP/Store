package com.project.store.repository;

import annotations.RepositoriesTest;
import com.project.store.domain.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@RepositoriesTest
@Sql(statements = {"INSERT INTO USUARIOS(id, nome, email, senha) VALUES(1, 'Teste', 'teste@gmail.com', '1234')"})
public class UsuarioRepositoryIntTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    public void findByEmail() {

        Usuario usuario = repository.findByEmail("teste@gmail.com").get();

        assertThat(usuario).isNotNull();
        assertThat(usuario.getId()).isEqualTo(1L);
        assertThat(usuario.getNome()).isEqualTo("Teste");
        assertThat(usuario.getEmail()).isEqualTo("teste@gmail.com");
        assertThat(usuario.getSenha()).isEqualTo("1234");
    }

}
