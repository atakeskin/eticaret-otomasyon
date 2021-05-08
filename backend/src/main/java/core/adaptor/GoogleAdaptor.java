package core.adaptor;

import outSservices.fakeGoogleAccount.GoogleAccount;

public class GoogleAdaptor implements Adaptor {
	
	public boolean verification() {
		
		GoogleAccount googleAccount = new GoogleAccount();
		return googleAccount.verification();
		
	}
	
	

}
