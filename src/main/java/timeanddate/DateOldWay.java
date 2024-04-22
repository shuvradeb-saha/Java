package timeanddate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOldWay {
    private static final String ISO_DATE_PATTERN = "yyyy-MM-dd";
    private static final String ISO_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String ISO_DATE_TIME_JAVA = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(true);
        // System.out.println(dateFormat.parse("2024-01-24T12:34:23"));

        System.out.println(dateFormat.format(new Date()));

        System.out.println("Using short");
        DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
        System.out.println(df.format(new Date()));

        // Date date = convert("2000-10-31T01:30:00.000-05:00");
        // System.out.println(date);
    }

    public static Date convert(String source) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(ISO_DATE_PATTERN);
            return dateFormat.parse(source);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + source + " Format: " + ISO_DATE_PATTERN);
            try {
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat(ISO_DATE_TIME_PATTERN);
                return dateTimeFormat.parse(source);
            } catch (ParseException ex) {
                System.out.println("Error parsing date: " + source + " Format: " + ISO_DATE_TIME_PATTERN);
                throw new IllegalArgumentException("Invalid date format: " + source);
            }
        }
    }
}
