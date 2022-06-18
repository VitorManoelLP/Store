package com.project.store.resources.abstracts;

import com.project.store.domain.interfaces.DomainImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractResource<E extends DomainImp<Long>, R extends JpaRepository<E, Long>> {

    @Autowired
    private R repository;

    private Class<E> clazz;

    @PostMapping("/new")
    public ResponseEntity<E> save(@RequestBody @Valid E entity) {
        return ResponseEntity.ok(repository.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id)
                .orElseThrow(() -> new IllegalCallerException(
                        String.format("%s não encontrado", clazz.getName()))));
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
