package com.circle.circle.Controller;

import com.circle.circle.Model.Node;
import com.circle.circle.Service.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/nodes")
public class NodeController {
    private final NodeService service;

    public NodeController(NodeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Node> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Node> get(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Node> create(@RequestBody Node node) {
        Node created = service.create(node);
        return ResponseEntity.created(URI.create("/nodes/" + created.getNodeId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Node node) {
        boolean ok = service.update(id, node);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean ok = service.delete(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}