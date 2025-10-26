package com.circle.circle.Service;

import com.circle.circle.Model.JoinRequest;
import com.circle.circle.Repository.JoinRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoinRequestService {
    private final JoinRequestRepository repo;

    public JoinRequestService(JoinRequestRepository repo) {
        this.repo = repo;
    }

    public List<JoinRequest> getAll() {
        return repo.findAll();
    }

    public Optional<JoinRequest> getById(Integer id) {
        return repo.findById(id);
    }

    public JoinRequest create(JoinRequest jr) {
        return repo.create(jr);
    }

    public boolean update(Integer id, JoinRequest jr) {
        jr.setRequestId(id);
        return repo.update(jr);
    }

    public boolean delete(Integer id) {
        return repo.deleteById(id);
    }
}