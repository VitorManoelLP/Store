package com.project.store.resources;

import com.project.store.domain.Produto;
import com.project.store.resources.abstracts.AbstractResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoResource extends AbstractResource<Produto> {

}
