package api.v1.repository;

import api.v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    List<User> findByRfc(String rfc);
}
