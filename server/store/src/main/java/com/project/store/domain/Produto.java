package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class Produto implements DomainImp<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    private String nome;

    @Column
    @NotNull
    private BigDecimal valor;

    @Column
    private Integer parcelas;

    @Column
    private String descricao;

}
