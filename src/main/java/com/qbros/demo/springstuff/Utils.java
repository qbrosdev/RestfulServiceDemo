package com.qbros.demo.springstuff;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class Utils {

    public static Date convertToDate(String dateString) {
        if (!isNull(dateString)) {
            String[] fn = dateString.split("-");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(fn[0]));
            cal.set(Calendar.MONTH, Integer.parseInt(fn[1]) - 1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fn[2]));
            Date date = cal.getTime();
            return date;
        } else {
            return null;
        }
    }

    public static boolean isDigit(String input) {
        return Optional.ofNullable(input).orElse("0").chars().allMatch(Character::isDigit);
    }

    public static boolean contains(String inputString, String content) {
        if (!isNull(inputString)) {
            return inputString.contains(content);
        } else {
            return false;
        }
    }

    public static String getServerTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(System.currentTimeMillis());

    }

    public static boolean isNull(Object object) {
        return (object == null);
    }


}
