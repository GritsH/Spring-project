package by.grits.newsSpring.service;

import by.grits.newsSpring.model.RoleType;
import by.grits.newsSpring.model.User;
import by.grits.newsSpring.model.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("should find by e-mail")
    @Test
    void findByEmail() {
        User user = mock(User.class);

        when(userRepository.findByEmail("email")).thenReturn(user);

        User result = userService.findByEmail("email");

        assertEquals(user, result);

        verify(userRepository).findByEmail("email");
        verifyNoMoreInteractions(userRepository);
    }

    @DisplayName("should add user")
    @Test
    void addUser() {
        User userToSave = new User("email", "password", RoleType.ROLE_USER, LocalDate.now());

        userService.addUser(userToSave);

        verify(userRepository).saveUser("email",
                userToSave.getPassword(),
                "ROLE_USER",
                LocalDate.now().toString());
    }
}