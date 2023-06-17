package org.jsp.Userbootapp.Service;

import java.util.Optional;

import org.jsp.Userbootapp.DAO.DAO;
import org.jsp.Userbootapp.DTO.Responsestructure;
import org.jsp.Userbootapp.DTO.User;
import org.jsp.Userbootapp.Exceptions.Idnotfoundexception;
import org.jsp.Userbootapp.Exceptions.InvalidCredinctionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private DAO d;

	public ResponseEntity<Responsestructure<User>> saveUser(User user) {

		Responsestructure<User> structure = new Responsestructure<>();

		structure.setMessage("User saved");
		structure.setCode(HttpStatus.CREATED.value());
		structure.setBody(d.saveUser(user));
		return new ResponseEntity<Responsestructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<User>> UpdateUser(User user) {
		Responsestructure<User> structure = new Responsestructure<>();
		structure.setMessage("User updated");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(d.Updateuser(user));
		return new ResponseEntity<Responsestructure<User>>(structure, HttpStatus.ACCEPTED);

	}

	public ResponseEntity<Responsestructure<User>> finduser(int id) {

		Responsestructure<User> structure = new Responsestructure<>();

		Optional<User> u = d.finduser(id);
		if (u.isPresent()) {
			structure.setBody(u.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("User found");
			return new ResponseEntity<Responsestructure<User>>(structure, HttpStatus.OK);
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<Responsestructure<String>> Deleteuser(int id) {

		Responsestructure<String> structure = new Responsestructure<>();

		Optional<User> u = d.finduser(id);
		if (u.isPresent()) {
			d.Deleteuser(id);
			structure.setBody("User deleted");
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("User found");
			return new ResponseEntity<Responsestructure<String>>(structure, HttpStatus.OK);

		} else {
			structure.setBody("User not  deleted");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("User not found");

			return new ResponseEntity<Responsestructure<String>>(structure, HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<Responsestructure<User>> verifyuser(long phone, String email) {
		Responsestructure<User> structure = new Responsestructure<>();
		Optional<User> u = d.Verifyuser(phone, email);

		if (u.isPresent()) {

			structure.setBody(u.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("User verified");
			return new ResponseEntity<Responsestructure<User>>(structure, HttpStatus.OK);

		}
		throw new InvalidCredinctionals();

	}

}
