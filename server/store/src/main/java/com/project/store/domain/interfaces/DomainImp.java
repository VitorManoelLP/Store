package com.project.store.domain.interfaces;

import java.io.Serializable;

public interface DomainImp<T extends Serializable> {

    T getId();

    void setId(T id);

    default boolean isNew() {
        return getId() == null;
    }

}
