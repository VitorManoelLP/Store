package com.project.store.configuration;

import com.project.store.domain.Usuario;
import com.project.store.fixture.Fixture;
import com.project.store.repository.UsuarioRepository;
import com.project.store.resources.UsuarioResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
@ContextConfiguration(classes = UsuarioResource.class, loader = AnnotationConfigContextLoader.class)
@RunWith(MockitoJUnitRunner.class)
public class CachingIntegrationTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioResource resource;

    @Test
    public void findAllUsingRedisCache() {

        Usuario usuario = Fixture.createUsuario(1L);

        doReturn(Arrays.asList(usuario)).when(usuarioRepository).findAll();

        List<Usuario> firstCall = resource.findAll().getBody();
        List<Usuario> secondCall = resource.findAll().getBody();

        assertThat(firstCall.get(0)).isEqualTo(usuario);
        assertThat(secondCall.get(0)).isEqualTo(usuario);

        verify(usuarioRepository, times(1)).findAll();
    }

}
