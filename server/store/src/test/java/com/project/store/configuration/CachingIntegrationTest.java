package com.project.store.configuration;

import com.project.store.domain.Usuario;
import com.project.store.fixture.Fixture;
import com.project.store.repository.UsuarioRepository;
import com.project.store.resources.UsuarioResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class
})
@ContextConfiguration(classes = UsuarioResource.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CachingIntegrationTest {

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired(required = true)
    private UsuarioResource usuarioResource;

    @Test
    public void findAllUsingRedisCache() {

        Usuario usuario = Fixture.createUsuario(1L);

        doReturn(Arrays.asList(usuario)).when(usuarioRepository).findAll();

        List<Usuario> firstCall = usuarioResource.findAll().getBody();
        List<Usuario> secondCall = usuarioResource.findAll().getBody();

        assertThat(firstCall.get(0)).isEqualTo(usuario);
        assertThat(secondCall.get(0)).isEqualTo(usuario);

        verify(usuarioRepository, times(1)).findAll();
    }

}
