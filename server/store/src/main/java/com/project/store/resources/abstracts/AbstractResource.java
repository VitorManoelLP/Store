package com.project.store.resources.abstracts;

import com.project.store.domain.interfaces.DomainImp;
import com.project.store.service.interfaces.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> Stashed changes
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

<<<<<<< Updated upstream
public abstract class AbstractResource<E extends DomainImp<Long>, R extends JpaRepository<E, Long>> {
=======
public abstract class AbstractResource<E extends DomainImp<Long>> {
>>>>>>> Stashed changes

    @Autowired
    private ServiceImp<E> service;

    @PostMapping("/new")
    public ResponseEntity<E> save(@RequestBody @Valid E entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id)
                .orElseThrow(() -> new IllegalCallerException("ID não encontrado")));
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
