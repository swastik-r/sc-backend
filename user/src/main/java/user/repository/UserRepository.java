package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserId(Long userId);
}