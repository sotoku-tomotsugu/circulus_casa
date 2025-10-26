package com.circle.circle.Service;

import com.circle.circle.Model.User;
import com.circle.circle.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    public User createUser(User user) {
        return repo.create(user);
    }

    public boolean updateUser(Integer id, User user) {
        user.setUserId(id);
        return repo.update(user);
    }

    public boolean deleteUser(Integer id) {
        return repo.deleteById(id);
    }
}