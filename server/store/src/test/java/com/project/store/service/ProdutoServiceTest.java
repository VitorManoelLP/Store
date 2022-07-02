package com.project.store.service;

import com.project.store.domain.Produto;
import com.project.store.fixtures.Fixtures;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService service;

    @Test
    public void verifyIfProdutoIsParcelado() {

        Produto produto = Fixtures.createProdutoParcelado(1L, 4);

        service.verifyIfProdutoIsParcelado(produto);

        assertThat(produto.getIsParcelado(), equalTo(true));
        assertThat(produto.getValor(), equalTo(new BigDecimal("100")));
        assertThat(produto.getValorParcelas(), equalTo(new BigDecimal(25)));
    }

    @Test
    public void calculateInstallmentsWithComplexValue() {

        Produto produto = Fixtures.createProdutoParcelado(1L, 7);
        produto.setValor(new BigDecimal("3425.45"));

        service.verifyIfProdutoIsParcelado(produto);

        assertThat(produto.getValorParcelas(), equalTo(new BigDecimal("489.35")));
    }

    @Test
    public void verifyIfParcelasIsNull() {

        Produto produto = Fixtures.createProdutoParcelado(1L, 0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.verifyIfProdutoIsParcelado(produto));

        assertThat(exception.getMessage(), equalTo("Escolha uma quantidade de parcelas!"));
    }

}
