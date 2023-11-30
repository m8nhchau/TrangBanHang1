package com.example.trangbanhangonline.Utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date addMinute(Date date, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
}
