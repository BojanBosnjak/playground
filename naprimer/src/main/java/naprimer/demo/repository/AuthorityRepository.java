package naprimer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naprimer.demo.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
