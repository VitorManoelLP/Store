package com.project.store.service;

import com.project.store.domain.Carrinho;
import com.project.store.domain.Produto;
import com.project.store.service.interfaces.ServiceImp;

import java.math.BigDecimal;
import java.util.Objects;

public class CarrinhoService implements ServiceImp<Carrinho> {

    @Override
    public Carrinho beforeSave(Carrinho entity) {
        verifyIfProdutoIsParcelado(entity);
        return entity;
    }

    public Carrinho verifyIfProdutoIsParcelado(Carrinho carrinho) {

        if (carrinho.getIsParcelado()) {

            if (carrinho.getParcelas().equals(0) || Objects.isNull(carrinho.getParcelas())) {
                throw new IllegalArgumentException("Escolha uma quantidade de parcelas!");
            }

            calculateInstallments(carrinho);
        }

        return carrinho;
    }

    private void calculateInstallments(Carrinho carrinho) {
        BigDecimal valorCarrinho = carrinho.getProdutos().stream()
                .map(Produto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorParcelas = valorCarrinho
                .divide(new BigDecimal(carrinho.getParcelas()));

        carrinho.setValorTotal(valorCarrinho);
        carrinho.setValorParcelas(valorParcelas);
    }
}
