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
    @JoinTable(name = "id_produtos")
    private List<Produto> produtos;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "is_parcelado")
    private Boolean isParcelado;

    @Column(name = "valor_parcelas")
    private BigDecimal valorParcelas;

    @Column
    private Integer parcelas;

}
