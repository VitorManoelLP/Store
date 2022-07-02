package com.project.store.service;

import com.project.store.domain.Produto;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ProdutoService implements ServiceImp<Produto> {

    @Override
    public Produto beforeSave(Produto produto) {
        verifyIfProdutoIsParcelado(produto);
        return produto;
    }

    public void verifyIfProdutoIsParcelado(Produto produto) {
        if (produto.getIsParcelado()) {

            if (produto.getParcelas().equals(0) || Objects.isNull(produto.getParcelas())) {
                throw new IllegalArgumentException("Escolha uma quantidade de parcelas!");
            }

            calculateInstallments(produto);
        }
    }

    private void calculateInstallments(Produto produto) {
        produto.setValorParcelas(produto.getValor()
                .divide(new BigDecimal(produto.getParcelas())));
    }

}
