package by.grits.newsSpring.model.repository;

import by.grits.newsSpring.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query("select email,user_password, role_type, added_at from user where email=:email_address")
    User findByEmail(@Param("email_address") String email);

}
