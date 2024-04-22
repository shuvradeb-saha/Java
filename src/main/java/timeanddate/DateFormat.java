package timeanddate;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    private static final String[] SUPPORTED_PATTERNS = new String[]{
            "yyyy-MM-dd",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ssZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    };

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.parse("2024-04-17T16:19:44.660+0600").toString());
        System.out.println(DateUtils.parseDate("2024-04-17T16:19:44.660+0600", SUPPORTED_PATTERNS));
        System.out.println(DateUtils.parseDate("2024-04-17T16:19:44.660-0600", SUPPORTED_PATTERNS));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        System.out.println(sdf2.format(new Date()));
        System.out.println(DateUtils.parseDate("2024-04-17T16:22:52+0600", SUPPORTED_PATTERNS));
    }


}
