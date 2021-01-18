package pl.uracz.workAccident.service;

import pl.uracz.workAccident.dto.UserRegisterDto;
import pl.uracz.workAccident.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername (String username);
    List<User> findAll();
    User readUser(Long id);
    User findById(Long id);
    void delete(Long id);
    void saveUser(UserRegisterDto user);
    public User findByUsernameAndPassword(String username, String password);
}
