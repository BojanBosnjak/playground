package naprimer.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import naprimer.demo.model.UserModel;
import naprimer.demo.service.UserService;

@RestController
public class UserRestController {
	@Autowired 
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserModel> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public UserModel getUserById (@PathVariable ("userId") Integer userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/users/create")
	public UserModel saveUser(@Valid @RequestBody UserModel user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/users/{userId}")
	public UserModel updateUser(@PathVariable ("userId") Integer userId, @Valid @RequestBody UserModel userModel) {
		return userService.updateUser(userId, userModel);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId ) {
		userService.deleteById(userId);
	}

}
