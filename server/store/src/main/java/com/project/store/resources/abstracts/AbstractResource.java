package com.project.store.resources.abstracts;

import com.project.store.domain.interfaces.DomainImp;
import com.project.store.service.interfaces.ServiceImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractResource<E extends DomainImp<Long>, R extends JpaRepository<E, Long>> {

    @Autowired
    private R repository;

    @Autowired
    private ServiceImp<E> service;

    protected E beforeSave(E entity) {
        return entity;
    }

    @PostMapping("/new")
    public ResponseEntity<E> save(@RequestBody @Valid E entity) {
        beforeSave(entity);
        return ResponseEntity.ok(repository.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado")));
    }

    @GetMapping("/all")
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
