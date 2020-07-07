package naprimer.demo.service;

import java.util.List;

import naprimer.demo.model.UserModel;

public interface UserService {
	UserModel saveUser(UserModel user); 
	UserModel updateUser(Integer userId, UserModel user);
	UserModel getUserById(Integer userId);
	List<UserModel> getAllUsers();
	void deleteById(Integer userId);
}
