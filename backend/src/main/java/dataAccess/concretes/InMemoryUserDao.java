package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import core.entities.concretes.User;
import dataAccess.absracts.UserDao;
import entities.UserDto;

public class InMemoryUserDao implements UserDao {
	
	private List<User> users;
	
	
	public InMemoryUserDao() {
		super();
		this.users = new ArrayList();
		User user1 = new User(1,"Atalay","Keskin","atalaykeskin@gmail.com","123456",false);
		User user2 = new User(1,"Atakan","Keskin","atakankeskin@gmail.com","123456",false);
		User user3 = new User(1,"Arda","Keskin","ardakeskin@gmail.com","123456",false);
		this.users.add(user1);
		this.users.add(user2);
		this.users.add(user3);
	}


	@Override
	public void register(User user) {
		users.add(user);
		System.out.println("Yeni kullanýcý sisteme kaydedildi.");
	}

	@Override
	public void login(UserDto userDto) {
		
		System.out.println("Kullanýcý sisteme login oldu. "+userDto.geteMail());
		
	}

	@Override
	public List<String> getMails() {
		List<String> mails = new ArrayList();
		for (User user : users) {
			mails.add(user.geteMail());
		}
		return mails;
	}


	@Override
	public List<UserDto> getWithMailsAndPasswords() {
		List<UserDto> userDtos = new ArrayList();
		for (User user : users) {
			UserDto userDto = new UserDto(user.geteMail(), user.getPassword());
			userDtos.add(userDto);
		}
		return userDtos;
	}


	@Override
	public void statusActive(User user) {
		for (User userExit : users) {
			if (userExit.equals(user)) {
				userExit.setStatus(true);
				System.out.println(userExit.getFirstName()+ " adlý kullanýcý sisteme aktifleþtirildi. "+"Durum: "+userExit.getStatus());
			}
			
		}
		
	}

}
