package com.project.store.service;

import com.project.store.domain.Carrinho;
import com.project.store.domain.Produto;
import com.project.store.fixtures.Fixtures;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class CarrinhoServiceTest {

    @InjectMocks
    private CarrinhoService service;

    @Test
    public void addShoppingCart() {

        Produto produto = Fixtures.createProduto(1L);
        produto.setValor(new BigDecimal("2354"));

        Produto produto2 = Fixtures.createProduto(2L);
        produto2.setValor(new BigDecimal("4356"));

        Produto produto3 = Fixtures.createProduto(3L);
        produto3.setValor(new BigDecimal("1276"));

        Carrinho carrinho = new Carrinho();
        carrinho.setProdutos(Arrays.asList(produto, produto2, produto3));
        carrinho.setIsParcelado(true);
        carrinho.setParcelas(2);

        Carrinho carrinhoConsumer = service.verifyIfProdutoIsParcelado(carrinho);

        assertThat(carrinhoConsumer, notNullValue());
        assertThat(carrinhoConsumer.getValorParcelas(), equalTo(new BigDecimal("3993")));
    }

    @Test
    public void verifyIfParcelasIsNull() {

        Produto produto = Fixtures.createProduto(1L);
        produto.setValor(new BigDecimal("2354"));

        Produto produto2 = Fixtures.createProduto(2L);
        produto2.setValor(new BigDecimal("4356"));

        Produto produto3 = Fixtures.createProduto(3L);
        produto3.setValor(new BigDecimal("1276"));

        Carrinho carrinho = new Carrinho();
        carrinho.setProdutos(Arrays.asList(produto, produto2, produto3));
        carrinho.setIsParcelado(true);
        carrinho.setParcelas(0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.verifyIfProdutoIsParcelado(carrinho));

        assertThat(exception.getMessage(), equalTo("Escolha uma quantidade de parcelas!"));
    }

}
