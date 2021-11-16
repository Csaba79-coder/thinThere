package backend.thinthere.service;

import backend.thinthere.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByUsername(String username);
}
