package com.project.store.resources;

import com.project.store.domain.Produto;
import com.project.store.repository.ProdutoRepository;
import com.project.store.resources.abstracts.AbstractResource;
import com.project.store.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoResource extends AbstractResource<Produto, ProdutoRepository> {

}
