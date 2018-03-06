package ro.oss.hibernate.tmq.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.oss.hibernate.tmq.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
