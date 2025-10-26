package com.circle.circle.Service;

import com.circle.circle.Model.Node;
import com.circle.circle.Repository.NodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeService {
    private final NodeRepository repo;

    public NodeService(NodeRepository repo) {
        this.repo = repo;
    }

    public List<Node> getAll() {
        return repo.findAll();
    }

    public Optional<Node> getById(Integer id) {
        return repo.findById(id);
    }

    public Node create(Node node) {
        return repo.create(node);
    }

    public boolean update(Integer id, Node node) {
        node.setNodeId(id);
        return repo.update(node);
    }

    public boolean delete(Integer id) {
        return repo.deleteById(id);
    }
}