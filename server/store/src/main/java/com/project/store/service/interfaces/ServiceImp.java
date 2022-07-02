package com.project.store.service.interfaces;

import com.project.store.domain.interfaces.DomainImp;

public interface ServiceImp<E extends DomainImp<Long>> {

    default E beforeSave(E entity) {
        return entity;
    }

}
