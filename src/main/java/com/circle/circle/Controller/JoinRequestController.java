package com.circle.circle.Controller;

import com.circle.circle.Model.JoinRequest;
import com.circle.circle.Service.JoinRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/join_requests")
public class JoinRequestController {
    private final JoinRequestService service;

    public JoinRequestController(JoinRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<JoinRequest> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoinRequest> get(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JoinRequest> create(@RequestBody JoinRequest jr) {
        JoinRequest created = service.create(jr);
        return ResponseEntity.created(URI.create("/join_requests/" + created.getRequestId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody JoinRequest jr) {
        boolean ok = service.update(id, jr);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean ok = service.delete(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}