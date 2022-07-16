package com.project.store.resources;

import com.project.store.domain.Compra;
import com.project.store.repository.CompraRepository;
import com.project.store.resources.abstracts.AbstractResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compras")
public class CompraResource extends AbstractResource<Compra, CompraRepository> {
}
