package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@Table(name = "carrinho")
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho implements DomainImp<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @Column
    private BigDecimal valorTotal;

    @Column
    private Boolean isParcelado;

    @Column(name = "valor_parcelas")
    private BigDecimal valorParcelas;

    @Column
    private Integer parcelas;

}
