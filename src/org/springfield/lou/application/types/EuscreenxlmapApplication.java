package org.springfield.lou.application.types;

import org.springfield.lou.application.Html5Application;

public class EuscreenxlmapApplication extends Html5Application{
		
 	public EuscreenxlmapApplication(String id) {
		super(id); 
		
		this.addReferid("mobilenav", "/euscreenxlelements/mobilenav");
		this.addReferid("header", "/euscreenxlelements/header");
		this.addReferid("footer", "/euscreenxlelements/footer");
		this.addReferid("terms", "/euscreenxlelements/terms");
		this.addReferid("linkinterceptor", "/euscreenxlelements/linkinterceptor");
		
	}

}
