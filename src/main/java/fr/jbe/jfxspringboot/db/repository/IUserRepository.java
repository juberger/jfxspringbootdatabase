package fr.jbe.jfxspringboot.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jbe.jfxspringboot.db.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	public User findByFirstname(String firstname);

}
