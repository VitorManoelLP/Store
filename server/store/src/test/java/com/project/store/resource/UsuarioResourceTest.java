package com.project.store.resource;

import com.project.store.domain.Usuario;
import com.project.store.fixture.Fixture;
import com.project.store.resources.UsuarioResource;
import com.project.store.service.UsuarioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioResourceTest {

    @Autowired
    public MockMvc mockMvc;

    @InjectMocks
    public UsuarioResource resource;

    @Mock
    public UsuarioService service;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
    }

    @Test
    public void findById() throws Exception {

        Usuario usuario = Fixture.createUsuario(1L);

        when(service.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.nome", is("Teste")));
    }

}
