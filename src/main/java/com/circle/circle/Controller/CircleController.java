package com.circle.circle.Controller;

import com.circle.circle.Model.Circle;
import com.circle.circle.Service.CircleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/circles")
public class CircleController {
    private final CircleService service;

    public CircleController(CircleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Circle> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Circle> get(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Circle> create(@RequestBody Circle circle) {
        Circle created = service.create(circle);
        return ResponseEntity.created(URI.create("/circles/" + created.getCircleId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Circle circle) {
        boolean ok = service.update(id, circle);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean ok = service.delete(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}