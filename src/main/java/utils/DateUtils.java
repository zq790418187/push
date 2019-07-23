package utils;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static String getTime(){
        Date now= new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ssgit ");
        return format.format(now);
    }
}
