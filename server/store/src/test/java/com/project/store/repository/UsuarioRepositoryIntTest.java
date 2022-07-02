package com.project.store.repository;

import annotations.RepositoriesTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.project.store.domain.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@RepositoriesTest
@DatabaseSetup(value = {"classpath:/dbunit-test/usuario.xml"})
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
        assertThat(usuario.getSenha()).isEqualTo(1234);
    }

}
