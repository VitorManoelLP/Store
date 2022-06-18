package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "nome"})
public class Usuario implements DomainImp<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String senha;

}
