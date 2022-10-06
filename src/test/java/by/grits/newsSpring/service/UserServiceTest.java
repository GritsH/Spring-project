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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        when(userRepository.findById("email")).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByEmail("email");

        assertEquals(user, result.get());

        verify(userRepository).findById("email");
        verifyNoMoreInteractions(userRepository);
    }

    @DisplayName("should add user")
    @Test
    void addUser() {
        User userToSave = new User("email", "password", RoleType.ROLE_USER, LocalDate.now());

        userService.addUser(userToSave);

        verify(userRepository).save(userToSave);
        verifyNoMoreInteractions(userRepository);
    }
}