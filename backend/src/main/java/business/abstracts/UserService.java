package business.abstracts;

import core.entities.concretes.User;
import entities.UserDto;

public interface UserService {
	
	void register(User user);
	void registerWithGoogle(User user);
	void login(UserDto userDto);
	void statusActive(User user);


}
