package business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.entities.concretes.User;

public class UserValidator {
	
	public static boolean validators(User user) {
		
		boolean result = true;
		if (!validatorNames(user)) {
			result = false;
		}
		if (!validatorPassword(user)) {
			result = false;
		}
		if (!validatorMail(user)) {
			result = false;
		}
		return result;
		
	}
	
	private static boolean validatorNames(User user) {
		
		boolean result = true;
		if (user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ad ve soyad en az 2 karekter olmalýdýr.");
			result = false;
		}
		
		return result;
		
	}
	
	private static boolean validatorPassword(User user) {
		
		boolean result = true;
		if (user.getPassword().length()<6) {
			System.out.println("Parola enaz 6 karekter olmalýdýr.");
			result = false;	
		}
		
		return result;
		
	}

	private static boolean validatorMail(User user) {
		boolean result = true;
		if (!checkMail(user.geteMail().toString())) {
			System.out.println("Geçersiz mail girdiniz.");
			result = false;
		}
		
		return result;
	}	
	
	
	private static boolean checkMail(String email) {
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		 

		Matcher matcher = pattern.matcher(email);
		   
		return matcher.matches();

		
	}


}
