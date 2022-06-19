package com.project.store.domain;

import com.project.store.domain.interfaces.DomainImp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Profiles implements DomainImp<Long>, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Override
    public String getAuthority() {
        return this.getNome();
    }
}
