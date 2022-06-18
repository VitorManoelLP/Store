package com.project.store.resource;

import com.project.store.domain.Usuario;
import com.project.store.fixture.Fixture;
import com.project.store.repository.UsuarioRepository;
import com.project.store.resources.UsuarioResource;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsuarioResource.class)
@ActiveProfiles("test")
public class UsuarioResourceTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public UsuarioRepository repository;

    @Autowired
    public UsuarioResource resource;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
    }

    @Test
    public void findById() throws Exception {

        Usuario usuario = Fixture.createUsuario(1L);

        when(repository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.nome", is("Teste")));
    }
}
