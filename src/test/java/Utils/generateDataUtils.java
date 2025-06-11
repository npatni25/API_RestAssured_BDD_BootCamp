package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class generateDataUtils {

	public static String getFirstName()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		return ("Neha"+generatedString);	
	}
	
	public static String getLastName()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		return ("Neha"+generatedString);	
	}
	public static String getEmailId()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		return ("Neha"+generatedString);	
	}
	public static String getContNum()
	{
		String generatedNum =RandomStringUtils.randomNumeric(10);
		return (generatedNum);	
	}
}
