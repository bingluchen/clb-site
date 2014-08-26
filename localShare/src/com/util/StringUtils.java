package com.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class StringUtils {

    public final static String EMPTY_STRING = "";

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static int getLength(String str) {
        return str == null ? 0:str.length();
    }

    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str.length());
        if (capitalize) {
            buf.append(Character.toUpperCase(str.charAt(0)));
        }
        else {
            buf.append(Character.toLowerCase(str.charAt(0)));
        }
        buf.append(str.substring(1));
        return buf.toString();
    }

    public static <T> String toString(T[] objs, String sep) {
    	if(ObjectUtils.isEmpty(objs)) return EMPTY_STRING;
        return toString(Arrays.asList(objs),sep);
    }

    public static <T> String toString(Collection<T> objs, String sep) {
        if(isEmpty(sep))
            throw new IllegalArgumentException("Argument 'sep' must not be null");

        if(ObjectUtils.isEmpty(objs)) return EMPTY_STRING;

        StringBuilder sb = new StringBuilder();
        for(T obj : objs) {
            sb.append(obj).append(sep);
        }
        return (sb.substring(0, sb.length() - sep.length()));
    }

    public static <T> String nString(T obj, String sep, int size) {
        if(isEmpty(sep))
            throw new IllegalArgumentException("Argument 'sep' must not be null");

       StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++) {
            sb.append(obj).append(sep);
        }
        return (sb.substring(0, sb.length() - sep.length()));
    }

    public static int parseInt(String str, int defaultVal) {
        try {
            defaultVal = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    public static long parseLong(String str, long defaultVal) {
        try {
            defaultVal = Long.parseLong(str);
        } catch (Exception e) {
        }
        return defaultVal;
    }

    /**
     * 是否为手机号码
     */
    public static boolean isMobileNO(String phoneNo){
//        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
//        Matcher m = p.matcher(phoneNo);
//        return m.matches();
          return null!=phoneNo && phoneNo.startsWith("1");
    }

    public static String getChineseNumber(String integerNumber){
    	if(integerNumber==null){
			return "";
		}
		Pattern pattern = Pattern.compile("[0-9]{1,13}");
		Matcher isNum = pattern.matcher(integerNumber);
		if(!isNum.matches()){
			return "";
		}

    	final String[] cnNumbers = { "零", "一", "二", "三", "四", "五", "六", "七", "八","九" };
		// 供分级转化的数组
		final String[] series = { "", "十", "百", "千", "万", "十", "百", "千", "亿","十", "百", "千", "万" };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < integerNumber.length(); i++) {
			sb.append(cnNumbers[getNumber(integerNumber.charAt(i))]);
			sb.append(series[integerNumber.length()-1-i]);
		}
		return sb.toString();
    }

    private static int getNumber(char c) {
		String str = String.valueOf(c);
		return Integer.parseInt(str);
	}

}
