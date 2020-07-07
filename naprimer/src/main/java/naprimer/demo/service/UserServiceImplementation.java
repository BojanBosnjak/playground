package naprimer.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naprimer.demo.entity.User;
import naprimer.demo.exception.ResourceNotFoundException;
import naprimer.demo.model.UserModel;
import naprimer.demo.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private PasswordEncoder PasswordEncoder;
	
	@Override
	public UserModel saveUser(UserModel user) {
		User userEntity = new User();
		userEntity.setUserId(user.getId());
		userEntity.setName(user.getName());
		userEntity.setAuthority(5);
		/*Ovde mu setujem authority
		 * Password encoder String password =
		 * passwordEncoder.encode(company.getPassword());
		 * companyEntity.setPAssword(password);
		 * Posle dodati ostale metode koje rade nad userom
		 */
		userRepository.save(userEntity);
		return userToEntity(userEntity);
	}

	@Override
	public UserModel updateUser(Integer userId, UserModel user) {
		Optional<User> theUser = userRepository.findById(userId);
		if(theUser.isEmpty()) {
			throw new ResourceNotFoundException("User not found");
		}
		User userEntity = theUser.get();
		userEntity.setName(user.getName());
		//dodati ostala polja (metode) kada ih implementiram
		userRepository.save(userEntity);
		return userToEntity(userEntity);
	}

	@Override
	public UserModel getUserById(Integer userId) {
		Optional<User> theUser = userRepository.findById(userId);
		if(theUser.isEmpty()) {
			throw new ResourceNotFoundException("User not found");
		}
		return userToEntity(theUser.get());
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserModel> models = new ArrayList<>();
		for(User user : users) {
			models.add(userToEntity(user));
		}
		
		return models;
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}
	
	private UserModel userToEntity(User user) {
		UserModel userModel = new UserModel();
		userModel.setId(user.getUserId());
		userModel.setName(user.getName());
		return userModel;
	}

}
