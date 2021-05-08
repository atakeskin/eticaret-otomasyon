package dataAccess.absracts;

import java.util.List;

import core.entities.concretes.User;
import entities.UserDto;

public interface UserDao {
	
	void register(User user);
	void login(UserDto userDto);
	List<String> getMails();
	List<UserDto> getWithMailsAndPasswords();
	void statusActive(User user);

}
