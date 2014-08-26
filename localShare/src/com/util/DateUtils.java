package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateUtils {

    public static final String SHORT_DATE_FORMAT_NOSEP = "yyyyMMdd";

    public static final String SHORT_DATE_FORMAT_NOSEP_WITH_HOUR = "yyyyMMddHH";

    public static final String SHORT_DATE_FORMAT_SEP = "yyyy-MM-dd";

    public static final String SHORT_DATE_FORMAT_SP = "yyyy/MM/dd";

    public static final String DEFUALT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_1 = DEFUALT_DATE_FORMAT;

    public static final String DATE_FORMAT_2 = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT_3 = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式转换
     * @param dateStr
     * @param fromFormat 原始格式
     * @param toFormat	 转换后的格式
     * @return
     * @throws ParseException
     */
    public static String formatConvert(String dateStr,String fromFormat,String toFormat)
            throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(fromFormat);
        Date date = sdf.parse(dateStr);
        SimpleDateFormat sdf2 = new SimpleDateFormat(toFormat);

        return sdf2.format(date);
    }

    public static int shortDateToInt(Date date) {
        return dateToInt(date, SHORT_DATE_FORMAT_NOSEP);
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat shortDateFormat =
            new SimpleDateFormat(pattern);
        return shortDateFormat.format(date);
    }

    public static Date stringToDate(String strDate) {
        Date date = null;
        SimpleDateFormat shortDateFormat =
            new SimpleDateFormat(DEFUALT_DATE_FORMAT);
        try {
            date = shortDateFormat.parse(strDate);
        } catch (Exception e) {}
        return date;
    }

    public static Date stringToDate(String strDate,String format) {
        Date date = null;
        SimpleDateFormat shortDateFormat = new SimpleDateFormat(format);
        try {
            date = shortDateFormat.parse(strDate);
        } catch (Exception e) {}
        return date;
    }

    public static int dateToInt(Date date, String pattern) {
        String dateStr = dateToString(date, pattern);

        int ret = 0;
        try {
            ret = Integer.parseInt(dateStr);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static Date intToDate(int intDate) {
        String strDate = String.valueOf(intDate);
        int[] ds = new int[]{0, 1, 1, 0, 0, 0};
        for(int i = 0; i < ds.length; i++) {
            if(strDate.length() == 0) break;
            int dlen = 2;
            if(i == 0) dlen = 4;
            String du = null;
            if(strDate.length() < dlen) {
                du = "0000".substring(0, dlen - strDate.length()) + strDate;
                strDate = "";
            } else {
                du = strDate.substring(0, dlen);
                strDate = strDate.substring(dlen);
            }
            ds[i] = Integer.parseInt(du);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(ds[0], ds[1] - 1, ds[2], ds[3], ds[4], ds[5]);
        return calendar.getTime();
    }
    
    public static Date addMonth(Date date, int monthnum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthnum);
        return calendar.getTime();
    }
    
    public static Date addDate(Date date, int daynum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, daynum);
        return calendar.getTime();
    }

    public static Date addHour(Date date, int hournum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hournum);
        return calendar.getTime();
    }

    public static Date nextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date previousDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 计算指定时间前一个小时的时间
     * @param date
     * @return
     */
    public static Date previousHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        return calendar.getTime();
    }


    public static String format(Date date, String pattern) {
        if(StringUtils.isEmpty(pattern))
            pattern = DEFUALT_DATE_FORMAT;

        SimpleDateFormat df =
            new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static String format(long timestamp, String pattern) {
        return format(new Date(timestamp), pattern);
    }


    /*
     * 两个时间差:时，分，秒
     */
    public static String getDateTimeOffset(long prevTime,long nextTime){
       String offsetTime = "";
       Date prev = new Date(prevTime);
       Date next = new Date(nextTime);
       long l =  next.getTime() - prev.getTime();
       long day = l/(24*60*60*1000);
       long hour = (l/(60*60*1000)-day*24);
       long min = ((l/(60*1000))-day*24*60-hour*60);
       long s = (l/1000-day*24*60*60-hour*60*60-min*60);
       long m = (l-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);

       if(day > 0)       offsetTime += day + " 天 ";
       //else            offsetTime +=  " 00 天 ";
       if(hour > 9)     offsetTime += hour + " 时 ";
       else if(hour > 0) offsetTime += " 0" + hour + " 时 ";
       else              offsetTime +=  " 00 时 ";
       if(min > 9)      offsetTime += min + " 分 ";
       else if(min > 0)  offsetTime += " 0" + min + " 分 ";
       else              offsetTime += " 00 分 ";
       if(s > 9)        offsetTime += s + " 秒 ";
       else if(s > 0)    offsetTime += " 0" + s + " 秒 ";
       else              offsetTime += " 00秒 ";
       if(m > 0)         offsetTime += m + " 毫秒 ";
       else              offsetTime = " 00毫秒 ";
       return offsetTime;
    }

    public static String shortIntDateToString(int i){
        Date date=intToDate(i);
        return dateToString(date, SHORT_DATE_FORMAT_SEP);
    }

    public static String secondsToDateString(int i,String pattern){
        long time=i*1000l;
        return format(time, pattern);
    }


    public static Date clearTime(Date date){
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.set(Calendar.MILLISECOND, 0);
         calendar.set(Calendar.SECOND, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.HOUR_OF_DAY, 0);
         return calendar.getTime();
    }

    public static boolean isBeforeDays(Date date1, Date date2, int days) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        c1.add(Calendar.DAY_OF_MONTH, days);
        return !c2.before(c1);
   }

    public int currentSeconds(){
        return (int)(System.currentTimeMillis()/1000);
    }
    
    public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFUALT_DATE_FORMAT,Locale.CHINA);
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(System.currentTimeMillis());
		System.out.println(sdf.format(cal.getTime()));
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(cal.getTimeInMillis()/1000);
		
		System.out.println(sdf.format(new Date(System.currentTimeMillis() + 3600 * 1000)));
	}
}
