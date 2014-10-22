package org.springfield.lou.application.types;

import org.json.simple.JSONObject;
import org.springfield.lou.application.Html5Application;
import org.springfield.lou.homer.LazyHomer;
import org.springfield.lou.screen.Screen;

public class EuscreenxlmapApplication extends Html5Application{
		
 	public EuscreenxlmapApplication(String id) {
		super(id); 
		
		this.addReferid("mobilenav", "/euscreenxlelements/mobilenav");
		this.addReferid("header", "/euscreenxlelements/header");
		this.addReferid("footer", "/euscreenxlelements/footer");
		this.addReferid("terms", "/euscreenxlelements/terms");
		this.addReferid("linkinterceptor", "/euscreenxlelements/linkinterceptor");
		this.addReferid("history", "/euscreenxlelements/history");
		this.addReferid("analytics", "/euscreenxlelements/analytics");
		
		this.addReferidCSS("fontawesome", "/euscreenxlelements/fontawesome");
		this.addReferidCSS("bootstrap", "/euscreenxlelements/bootstrap");
		this.addReferidCSS("theme", "/euscreenxlelements/theme");
		this.addReferidCSS("genericadditions", "/euscreenxlelements/generic");
		this.addReferidCSS("all", "/euscreenxlelements/all");
		this.addReferidCSS("terms", "/euscreenxlelements/terms");
		this.addReferidCSS("jqvmap", "/euscreenxlelements/jqvmap");
				
	}
 	
 	public String getFavicon() {
        return "/eddie/apps/euscreenxlelements/img/favicon.png";
    }
 	
 	public void initPage(Screen s){
 		if(!this.inDevelMode()){
			s.putMsg("linkinterceptor", "", "interceptLinks()");
		}
 	}
 	
 	private boolean inDevelMode() {
    	return LazyHomer.inDeveloperMode();
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
