package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import business.validationRules.UserValidator;
import core.adaptor.Adaptor;
import core.crossCuttingConcerns.log.abstracts.Logger;
import core.entities.concretes.User;
import dataAccess.absracts.UserDao;
import entities.UserDto;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private Logger logger;
	private Adaptor adaptor;
	

	public UserManager(UserDao userDao, Logger logger) {
		this.userDao = userDao;
		this.logger = logger;
		
	}
	
	public UserManager(Adaptor adaptor,UserDao userDao, Logger logger) {
		this(userDao,logger);
		this.adaptor = adaptor;
	}

	@Override
	public void register(User user) {

		if (!UserValidator.validators(user)) {
			
			System.out.println("Kullanýcý kaydedilemedi");
			return;
			
		}
		if (CheckEmail(user)) {
			System.out.println("Kullanýcý maili sistemde mevcut");
			return;
		}
		
		userDao.register(user);
		logger.log(user.toString());
		
	}

	@Override
	public void login(UserDto userDto) {
		
		if (!CheckEmailAndPassword(userDto)) {
			System.out.println("Giriþ iþlemi baþarýsýz.Kullanýcý veya parola yanlýþ.");
			return;
		}		
		userDao.login(userDto);
		
	}
	
	private boolean CheckEmail(User user) {
		
		List<String> mails = userDao.getMails();
		for (String mail : mails) {
			if (mail.equals(user.geteMail())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean CheckEmailAndPassword(UserDto user) {
		
		List<UserDto> userDtos = userDao.getWithMailsAndPasswords();
		for (UserDto userDto : userDtos) {
			
			if (userDto.geteMail().equals(user.geteMail()) && userDto.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}



	@Override
	public void registerWithGoogle(User user) {
		
		if (!adaptor.verification()) {
			System.out.println("Google hesap doðrulanamadýðýndan kaydýnýz oluþturulamamýþtýr.");
		}
		
		userDao.register(user);
	}

	@Override
	public void statusActive(User user) {
		
		userDao.statusActive(user);
		
	}
	

}
