package locale.start;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author gabriel
 */
public class StartLocale {

    private ResourceBundle bundle = null;
    
    public StartLocale(String idioma) {     	    	    	
    	switch(idioma){
	    	case "pt-BR":
	    		bundle = ResourceBundle.getBundle("locale.packages.locale", new Locale("pt", "BR"));
	    		break;
	    		
	    	case "en-US":
	    		bundle = ResourceBundle.getBundle("locale.packages.locale", Locale.US);
	    		break;
    	}
    }
    
    public ResourceBundle getLocale() {
        return bundle;
    }
}