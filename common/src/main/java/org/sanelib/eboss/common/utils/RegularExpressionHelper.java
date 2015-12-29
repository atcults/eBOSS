package org.sanelib.eboss.common.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionHelper {

    public static final String PHONE_FORMAT = "^\\+(\\d{2})-(\\d{10})$";
    public static final String PHONE_FORMAT_EXAMPLE = "+91-9876543210";
    public static final String EMAIL_FORMAT = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*\\@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
    public static final String EMAIL_FORMAT_EXAMPLE = "megh@yahoo.com or megh.94@yahoo.com";
    public static final String DATE_FORMAT ="^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$";
    public static final String DATE_FORMAT_EXAMPLE ="1991/01/01";

    public static boolean checkPhoneFormat(String phone) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile(PHONE_FORMAT);

        // Create matcher object.
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean checkEmailFormat(String email) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile(EMAIL_FORMAT);

        // Create matcher object.
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkDateFormat(String date) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile(DATE_FORMAT);

        // Create matcher object.
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
