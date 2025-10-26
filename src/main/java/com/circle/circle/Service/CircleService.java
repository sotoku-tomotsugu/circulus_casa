package com.circle.circle.Service;

import com.circle.circle.Model.Circle;
import com.circle.circle.Repository.CircleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircleService {
    private final CircleRepository repo;

    public CircleService(CircleRepository repo) {
        this.repo = repo;
    }

    public List<Circle> getAll() {
        return repo.findAll();
    }

    public Optional<Circle> getById(Integer id) {
        return repo.findById(id);
    }

    public Circle create(Circle circle) {
        return repo.create(circle);
    }

    public boolean update(Integer id, Circle circle) {
        circle.setCircleId(id);
        return repo.update(circle);
    }

    public boolean delete(Integer id) {
        return repo.deleteById(id);
    }
}