package com.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Map;


public abstract class ObjectUtils {

    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(Map<?,?> map) {
        return (map == null || map.isEmpty());
    }

    public static int[] toPrimativeArray(Integer[] objs) {
        if(objs == null) return (new int[0]);

        int[] rs = new int[objs.length];
        for(int i = 0; i < objs.length; i++) {
            rs[i] = (objs[i] == null?0:objs[i]);
        }
        return rs;
    }

    public static long[] toPrimativeArray(Long[] objs) {
        if(objs == null) return (new long[0]);

        long[] rs = new long[objs.length];
        for(int i = 0; i < objs.length; i++) {
            rs[i] = (objs[i] == null?0:objs[i]);
        }
        return rs;
    }

    public static Integer[] toObjectArray(int[] objs) {
        if(objs == null) return (new Integer[0]);

        Integer[] rs = new Integer[objs.length];
        for(int i = 0; i < objs.length; i++) {
            rs[i] = new Integer(objs[i]);
        }
        return rs;
    }

    public static Long[] toObjectArray(long[] objs) {
        if(objs == null) return (new Long[0]);

        Long[] rs = new Long[objs.length];
        for(int i = 0; i < objs.length; i++) {
            rs[i] = new Long(objs[i]);
        }
        return rs;
    }

    public static int toInteger(Object obj, int defaultVal) {
        try {
            if(obj == null) return defaultVal;
            return Integer.parseInt(obj.toString());
        }catch(Exception e) {
            return defaultVal;
        }
    }

    public static int toInteger(Object obj) {
        try {
            if(obj == null) return 0;
            return Integer.parseInt(obj.toString());
        }catch(Exception e) {
            return 0;
        }
    }

    public static long toLong(Object obj, long defaultVal) {
        try {
            if(obj == null) return defaultVal;
            return Long.parseLong(obj.toString());
        }catch(Exception e) {
            return defaultVal;
        }
    }

    public static long toLong(Object obj) {
        try {
            if(obj == null) return 0L;
            return Long.parseLong(obj.toString());
        }catch(Exception e) {
            return 0L;
        }
    }

    public static float toFloat(Object obj, float defaultVal) {
        try {
            if(obj == null) return defaultVal;
            return Float.parseFloat(obj.toString());
        }catch(Exception e) {
            return defaultVal;
        }
    }

    public static float toFloat(Object obj) {
        try {
            if(obj == null) return 0.0f;
            return Float.parseFloat(obj.toString());
        }catch(Exception e) {
            return 0.0f;
        }
    }

    public static double toDouble(Object obj, double defaultVal) {
        try {
            if(obj == null) return defaultVal;
            return Double.parseDouble(obj.toString());
        }catch(Exception e) {
            return defaultVal;
        }
    }

    public static double toDouble(Object obj) {
        try {
            if(obj == null) return 0.0;
            return Double.parseDouble(obj.toString());
        }catch(Exception e) {
            return 0.0;
        }
    }

    public static String toString(Object obj, String defaultVal) {
        return obj == null?defaultVal:String.valueOf(obj);
    }

    public static String toString(Object obj) {
        return obj == null?null:String.valueOf(obj);
    }

    /**
     * n%
     */
    public static String getPercent(int numerator,int denominator){
        if(denominator==0) return "0%";
        NumberFormat formatter = new DecimalFormat("0%");
        Double x=new Double(numerator);
        Double y=new Double(denominator);

        return formatter.format(x/y);
    }

}
