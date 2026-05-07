package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.User;
import org.example.kinotirana.Repositories.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRep userRep;

    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    public List<User> getAll() {
        return userRep.findByUserIsActiveTrue();
    }

    public User create(User user) {
        return userRep.save(user);
    }

    @Transactional
    public User update(Long userId, User newuser) {
        User u = userRep.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        u.setUserName(newuser.getUserName());
        u.setUserSurname(newuser.getUserSurname());
        u.setUserBirthdate(newuser.getUserBirthdate());
        u.setUserEmail(newuser.getUserEmail());
        u.setUserIsActive(newuser.isUserIsActive());
        u.setUserPassword(newuser.getUserPassword());
        return userRep.save(u);
    }
    @Transactional
    public void delete (Long userId){
        User u = userRep.findById(userId).orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found!"));
        u.setUserIsActive(false);
    }
}