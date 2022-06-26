package com.project.store.service.interfaces;

import com.project.store.domain.interfaces.DomainImp;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "cacheService")
@Service
public interface ServiceImp<E extends DomainImp<Long>> {

    @Cacheable(value = "getAll")
    List<E> findAll();

    @CacheEvict(value = "getAll")
    E save(@RequestBody @Valid E entity);

    @CacheEvict(value = "getAll")
    void deleteById(Long id);

    @CachePut(value = "getAll")
    Optional<E> findById(Long id);

}
