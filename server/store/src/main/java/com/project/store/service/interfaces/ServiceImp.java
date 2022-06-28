package com.project.store.service.interfaces;

import com.project.store.domain.interfaces.DomainImp;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface ServiceImp<E extends DomainImp<Long>> {

    List<E> findAll();

    E save(@RequestBody @Valid E entity);

    void deleteById(Long id);

    Optional<E> findById(Long id);

}
