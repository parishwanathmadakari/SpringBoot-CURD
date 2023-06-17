package org.jsp.Userbootapp.Repository;

import java.util.Optional;

import org.jsp.Userbootapp.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.phone=?1 and u.email=?2")
	public Optional<User> verifyuser(long phone, String email);

}
