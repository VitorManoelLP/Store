package com.project.store.resources;

import com.project.store.domain.Usuario;
<<<<<<< Updated upstream
import com.project.store.repository.UsuarioRepository;
=======
>>>>>>> Stashed changes
import com.project.store.resources.abstracts.AbstractResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
<<<<<<< Updated upstream
public class UsuarioResource extends AbstractResource<Usuario, UsuarioRepository> {
=======
public class UsuarioResource extends AbstractResource<Usuario> {

>>>>>>> Stashed changes
}
