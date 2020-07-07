package naprimer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naprimer.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
