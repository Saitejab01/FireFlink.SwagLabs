package swagLabs.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	public String getSystemDate(){
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY_hh-mm-ss");
		return sdf.format(date);
	}
}
