package com.project.store.resources;

import com.project.store.domain.Usuario;
import com.project.store.resources.abstracts.AbstractResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UsuarioResource extends AbstractResource<Usuario> {
}
