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
		 * A�a��da bir e-ticaret sistemi
		 * Sisteme kay�t ve sisteme giri� 
		 * Bu sisteme ait Java backend yazma �rne�i
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
	 * Ad ve soyad en az iki karakterden olu�mal�d�r.
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testNamesInput() {
		

		String inputFirstName = inputLabel("Ad�n�z� Giriniz: ");
		String inputLastName = inputLabel("Soyad�n�z� Giriniz: ");
		
		User user = new User(1,inputFirstName,inputLastName,"FakeMail@gmail.com","FakePassword");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
	}
	
	
	/*
	 * E-posta alan� e-posta format�nda olmal�d�r. (Regex ile yap�n�z. Ara�t�rma konusu)
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testMailInput() {

		String inputMail = inputLabel("Mailinizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeName",inputMail,"FakeSifre");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		
	}
	
	
	/*
	 * Parola en az 6 karakterden olu�mal�d�r.
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testPasswordInput() {
		
		String inputPassword = inputLabel("�ifrenizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeLastName","FakeMail@gmail.com",inputPassword);	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
	}
	
	/*
	 * E-Posta daha �nce kullan�lmam�� olmal�d�r.
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * �yelik sonucu kullan�c�ya do�rulama e-postas� g�nderilmelidir. (Simulasyon)
	 * Do�rulama linki t�kland���nda �yelik tamamlanmal�d�r. (Simulasyon)
	 * 
	 */
	private static void testRegisterSendEmail() {
		
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		
		User user = new User(1,"FakeName","FakeLastName",inputMail,"123456");	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		System.out.println("Ki�i do�rulama linkine t�klad�");
		userService.statusActive(user);
		
	}
	
	
	/*
	 * Kullan�c�lar sisteme bilgilerini girerek �ye olabilmelidir.
	 * 
	 * Sisteme temel kullan�c� bilgileri , 
	 * e-posta ve parolayla �ye olunabilmelidir. 
	 * Temel kullan�c� bilgileri : ad, soyad, e-posta, parola. 
	 * Temel bilgilerin tamam� zorunludur.
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testBaseRegister() {
		
		String inputFirstName = inputLabel("Ad�n�z� Giriniz: ");
		String inputLastName = inputLabel("Soyad�n�z� Giriniz: ");
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		String inputPassword = inputLabel("�ifrenizi Giriniz: ");
		
		User user = new User(1,inputFirstName,inputLastName,inputMail,inputPassword);	
		UserService userService = new UserManager(new InMemoryUserDao(), new EmailLogger());		
		userService.register(user);
		
	}

	/*
	 * Kullan�c�lar sisteme Google hesaplar� ile �ye olabilmelidir. (Simulasyon)
	 * 
	 * �lerleyen zamanlarda ba�ka yetkilendirme servisleri de kullan�labilir. 
	 * (Sistemi d�� servis entegrasyonu olacak �ekilde yap�land�r�n�z.)
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testRegisterWithGoogle() {
		
		User user = new User(1,"Ata","Demir","ata@gmail.com","123456");	
		UserService userService = new UserManager(new GoogleAdaptor(), new InMemoryUserDao(), new EmailLogger());		
		userService.registerWithGoogle(user);
		
	}
	
	/*
	 * Kullan�c�lar e-posta ve parola bilgisiyle sisteme giri� yapabilmelidir.
	 * 
	 * E-posta ve parola zorunludur
	 * Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.
	 * 
	 */
	private static void testLogin() {
		
		String inputMail = inputLabel("Mailinizi Giriniz: ");
		String inputPassword = inputLabel("�ifrenizi Giriniz: ");
		
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
