package com.project.store.suite;

import com.project.store.configuration.CachingIntegrationTest;
import com.project.store.repository.UsuarioRepositoryIntTest;
import com.project.store.resource.UsuarioResourceTest;
import com.project.store.service.CarrinhoServiceTest;
import com.project.store.service.ProdutoServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CachingIntegrationTest.class,
        UsuarioRepositoryIntTest.class,
        UsuarioResourceTest.class,
        ProdutoServiceTest.class,
        CarrinhoServiceTest.class
})
public class TestSuite {
}
