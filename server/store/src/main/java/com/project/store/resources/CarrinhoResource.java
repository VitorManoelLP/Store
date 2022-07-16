package com.project.store.resources;

import com.project.store.domain.Carrinho;
import com.project.store.repository.CarrinhoRepository;
import com.project.store.resources.abstracts.AbstractResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoResource extends AbstractResource<Carrinho, CarrinhoRepository> {
}
