package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "nome"})
@Table(name = "usuarios")
@Cacheable
@ToString
public class Usuario implements DomainImp<Long>, Serializable {

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
