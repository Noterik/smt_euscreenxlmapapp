package org.springfield.lou.application.types;

import org.json.simple.JSONObject;
import org.springfield.lou.application.Html5Application;
import org.springfield.lou.screen.Screen;

public class EuscreenxlmapApplication extends Html5Application{
		
 	public EuscreenxlmapApplication(String id) {
		super(id); 
		
		this.addReferid("mobilenav", "/euscreenxlelements/mobilenav");
		this.addReferid("header", "/euscreenxlelements/header");
		this.addReferid("footer", "/euscreenxlelements/footer");
		this.addReferid("terms", "/euscreenxlelements/terms");
		this.addReferid("linkinterceptor", "/euscreenxlelements/linkinterceptor");
		this.addReferid("favicon", "/euscreenxlelements/favicon");
		this.addReferid("history", "/euscreenxlelements/history");
		
		this.addReferidCSS("elements", "/euscreenxlelements/generic");
		this.addReferidCSS("bootstrap", "/euscreenxlelements/bootstrap");
		this.addReferidCSS("jqvmap", "/euscreenxlelements/jqvmap");
				
	}
 	
 	public void initMapTablet(Screen s){
 		System.out.println("initMap()");
 		
 		String regionCode = s.getParameter("code");
 		
 		JSONObject args = new JSONObject();
 		args.put("device", "tablet");
 		 		
 		if(regionCode != null){
 			args.put("region", regionCode);
 		}
 		
 		s.putMsg("template", "", "initMap(" + args + ")");
 	}
 	
 	public void initMap(Screen s){
 		System.out.println("initMap()");
 		
 		String regionCode = s.getParameter("code");
 		
 		JSONObject args = new JSONObject();
 		 		
 		if(regionCode != null){
 			args.put("region", regionCode);
 		}
 		
 		s.putMsg("template", "", "initMap(" + args + ")");
 		
 	};
 	
}
