package by.grits.newsSpring.model.repository;

import by.grits.newsSpring.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query("select email_address,user_password, role_type, added_at from users where email_address=:email_address")
    User findByEmail(@Param("email_address") String email);

    @Query("select email_address, user_password, role_type, added_at from users where email_address=:email_address and user_password=:user_password")
    User findByEmailAndPassword(@Param("email_address") String emailAddress, @Param("user_password") String userPassword);

    @Modifying
    @Query("insert into users(email_address, user_password, role_type, added_at) values(:email_address,:user_password,:role_type,:added_at)")
    void saveUser(@Param("email_address") String emailAddress, @Param("user_password") String userPassword,
                  @Param("role_type") String roleType, @Param("added_at") String addedAt);
}
