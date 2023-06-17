package org.jsp.Userbootapp.DAO;

import java.util.Optional;

import org.jsp.Userbootapp.DTO.User;
import org.jsp.Userbootapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DAO {

	@Autowired
	UserRepository repo;

	public User saveUser(User user) {

		return repo.save(user);

	}

	public User Updateuser(User user) {

		return repo.save(user);

	}

	public Optional<User> finduser(int id) {

		return repo.findById(id);

	}

	public void Deleteuser(int id) {
		repo.deleteById(id);

	}
	
	public Optional<User> Verifyuser(long phone,String email){
		
		return repo.verifyuser(phone, email);
	}

}
