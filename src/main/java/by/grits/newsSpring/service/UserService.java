package by.grits.newsSpring.service;

import by.grits.newsSpring.model.RoleType;
import by.grits.newsSpring.model.User;
import by.grits.newsSpring.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public User findByEmailAndPassword(String email, String password) {
        User foundUser = findByEmail(email);
        boolean arePasswordsMatch;
        if (foundUser != null) {
            arePasswordsMatch = passwordEncoder.matches(password, foundUser.getPassword());
            if (arePasswordsMatch) {
                return foundUser;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        User foundUser = userRepository.findByEmail(email);
        if (foundUser != null) {
            foundUser.setEmail(email);
        }
        return foundUser;
    }

    public void saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userRepository.saveUser(user.getEmail(), encodedPassword, RoleType.ROLE_USER.toString(), String.valueOf(LocalDate.now()));
    }
}
