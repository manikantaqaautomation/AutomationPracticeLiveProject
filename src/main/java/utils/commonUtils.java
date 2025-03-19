package utils;

import java.util.Date;

public class commonUtils {
	
public static String generateEmail() {
		
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@mail.com";
		
	}

}
