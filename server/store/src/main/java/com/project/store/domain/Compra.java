package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@Table(name = "compras")
public class Compra implements DomainImp<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Carrinho carrinho;

    @Column
    private BigDecimal frete;
}
