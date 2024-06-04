package Baitap.NguyenMinhQuang.services;

import Baitap.NguyenMinhQuang.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private List<User> users;

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(User user) {
        var userOptional = getUserById(user.getId());
        if (userOptional.isPresent()) {
            User userUpdate = userOptional.get();
            userUpdate.setFirstname(user.getFirstname());
            userUpdate.setLastname(user.getLastname());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setId(user.getId());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setBirthDay(user.getBirthDay());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole_id(user.getRole_id());
            userUpdate.setUser_id(user.getUser_id());
        }
    }
    public void deleteUserById(Long id) {
        getUserById(id).ifPresent(users::remove);
    }
}
