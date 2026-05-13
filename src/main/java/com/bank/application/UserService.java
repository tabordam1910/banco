package com.bank.application;

import com.bank.domain.entities.User;
import com.bank.domain.exceptions.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void createClient(User user) {
        users.add(user);
    }

    public User findClient(String id) {
        return users.stream()
            .filter(u -> u.getUserId().equals(id))
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
    }

    public void deleteClient(String id) {
        User user = findClient(id);
        users.remove(user);
    }
}