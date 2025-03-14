package temp;

import java.util.Date;

public class GenerateEmailAddress {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		String dateString = date.toString();
		String noSpaceDateString = dateString.replaceAll("\\s","");
		System.out.println(noSpaceDateString);
		String noSpacenoColonsString = noSpaceDateString.replaceAll("\\:","");
		System.out.println(noSpacenoColonsString);
		String emailWithTimeStamp = noSpacenoColonsString+"@gmail.com";
		System.out.println(emailWithTimeStamp);

	}

}
