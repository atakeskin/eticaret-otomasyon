package core.crossCuttingConcerns.log.concretes;

import core.crossCuttingConcerns.log.abstracts.Logger;

public class EmailLogger implements Logger {

	@Override
	public void log(String message) {
		
		System.out.println("Email yollandý."+message);
		
	}
	
	

}
