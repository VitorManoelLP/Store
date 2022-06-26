package com.project.store.resources.abstracts;

import com.project.store.domain.interfaces.DomainImp;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
>>>>>>> 22f8cdf31a543df57e12b6b192354ac545d6ba87
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> Stashed changes
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
@CacheConfig(cacheNames = "cacheResource")
>>>>>>> 22f8cdf31a543df57e12b6b192354ac545d6ba87
public abstract class AbstractResource<E extends DomainImp<Long>, R extends JpaRepository<E, Long>> {
=======
public abstract class AbstractResource<E extends DomainImp<Long>> {
>>>>>>> Stashed changes

    @Autowired
    private ServiceImp<E> service;

    @PostMapping("/new")
    @CacheEvict(value = "getAll")
    public ResponseEntity<E> save(@RequestBody @Valid E entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping("/{id}")
    @CachePut(value = "getAll")
    public ResponseEntity<E> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id)
                .orElseThrow(() -> new IllegalCallerException("ID não encontrado")));
    }

    @GetMapping
    @Cacheable(value = "getAll")
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "getAll")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
