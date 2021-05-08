package core.crossCuttingConcerns.log.concretes;

import core.crossCuttingConcerns.log.abstracts.Logger;

public class FileLogger implements Logger {

	@Override
	public void log(String message) {
		
		System.out.println("Dosyaya loglandý."+message);

	}

}
