package consoleUI;

import java.util.Scanner;

import business.abstracts.UserService;
import business.concretes.UserManager;
import core.adaptor.GoogleAdaptor;
import core.crossCuttingConcerns.log.concretes.EmailLogger;
import core.entities.concretes.User;
import dataAccess.concretes.InMemoryUserDao;
import entities.UserDto;

public class Main {

	public static void main(String[] args) {		
		
		/*
		 * Aþaðýda bir e-ticaret sistemi
		 * Sisteme kayýt ve sisteme giriþ 
		 * Bu sisteme ait Java backend yazma örneði
		 * 
		 */
		
		//testNamesInput();
		//testMailInput();
		//testPasswordInput();
		//testRegisterSendEmail();
		//testBaseRegister();
		//testRegisterWithGoogle();
		//testLogin();

	}
	
	/*
	 * Ad ve soyad en az iki karakterden oluþmalýdýr.
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testNamesInput() {
		

		String inputFirstName = inputLabel("Adýnýzý Giriniz: ");
		String inputLastName = inputLabel("Soyadýnýzý Giriniz: ");
		
		User user = new User(1,inputFirstName,inputLastName,"FakeMail@gmail.com","FakePassword");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
	}
	
	
	/*
	 * E-posta alaný e-posta formatýnda olmalýdýr. (Regex ile yapýnýz. Araþtýrma konusu)
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testMailInput() {

		String inputMail = inputLabel("Mailinizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeName",inputMail,"FakeSifre");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		
	}
	
	
	/*
	 * Parola en az 6 karakterden oluþmalýdýr.
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testPasswordInput() {
		
		String inputPassword = inputLabel("Þifrenizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeLastName","FakeMail@gmail.com",inputPassword);	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
	}
	
	/*
	 * E-Posta daha önce kullanýlmamýþ olmalýdýr.
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * Üyelik sonucu kullanýcýya doðrulama e-postasý gönderilmelidir. (Simulasyon)
	 * Doðrulama linki týklandýðýnda üyelik tamamlanmalýdýr. (Simulasyon)
	 * 
	 */
	private static void testRegisterSendEmail() {
		
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeLastName",inputMail,"123456");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		System.out.println("Kiþi doðrulama linkine týkladý");
		userService.statusActive(user);
		
	}
	
	
	/*
	 * Kullanýcýlar sisteme bilgilerini girerek üye olabilmelidir.
	 * 
	 * Sisteme temel kullanýcý bilgileri , 
	 * e-posta ve parolayla üye olunabilmelidir. 
	 * Temel kullanýcý bilgileri : ad, soyad, e-posta, parola. 
	 * Temel bilgilerin tamamý zorunludur.
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testBaseRegister() {
		
		String inputFirstName = inputLabel("Adýnýzý Giriniz: ");
		String inputLastName = inputLabel("Soyadýnýzý Giriniz: ");
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		String inputPassword = inputLabel("Þifrenizi Giriniz: ");
		
		User user = new User(1,inputFirstName,inputLastName,inputMail,inputPassword);	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		
	}

	/*
	 * Kullanýcýlar sisteme Google hesaplarý ile üye olabilmelidir. (Simulasyon)
	 * 
	 * Ýlerleyen zamanlarda baþka yetkilendirme servisleri de kullanýlabilir. 
	 * (Sistemi dýþ servis entegrasyonu olacak þekilde yapýlandýrýnýz.)
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testRegisterWithGoogle() {
		
		User user = new User(1,"Ata","Demir","ata@gmail.com","123456");	
		UserService userService = new UserManager(new GoogleAdaptor(), new InMemoryUserDao(), new EmailLogger());		
		userService.registerWithGoogle(user);
		
	}
	
	/*
	 * Kullanýcýlar e-posta ve parola bilgisiyle sisteme giriþ yapabilmelidir.
	 * 
	 * E-posta ve parola zorunludur
	 * Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.
	 * 
	 */
	private static void testLogin() {
		
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		String inputPassword = inputLabel("Þifrenizi Giriniz: ");
		
		UserDto userDto = new UserDto(inputMail,inputPassword);	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.login(userDto);
		
	}
	
	private static String inputLabel(String label) {
		Scanner scanner = new Scanner(System.in);		
		System.out.print(label);
		String input = scanner.next();
		
		return input;
	}
	

}
