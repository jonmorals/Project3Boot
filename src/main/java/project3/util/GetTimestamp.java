package project3.util;

import java.sql.Timestamp;
import java.util.Date;


public class GetTimestamp {

	public static Timestamp getCurrentTime() {
		Date today = new Date();
		Timestamp time = new Timestamp(today.getTime());
		return time;
	}
}
