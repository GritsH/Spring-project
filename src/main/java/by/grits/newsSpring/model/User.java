package by.grits.newsSpring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    @Id
    private String email;
    @Column("user_password")
    private String password;
    @Column("role_type")
    private RoleType roleType;
    @Column("added_at")
    private LocalDate addedAt;

    public User(String email, String password, RoleType roleType, LocalDate addedAt) {
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        this.addedAt = addedAt;
    }
    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDate getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDate addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && roleType == user.roleType && Objects.equals(addedAt, user.addedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, roleType, addedAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleType=" + roleType +
                ", addedAt=" + addedAt +
                '}';
    }
}
