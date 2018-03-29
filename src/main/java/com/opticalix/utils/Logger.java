package com.opticalix.utils;

import java.util.Arrays;
import java.util.Collection;

public class Logger {

    public static void pWithoutLn(String format, Object... args) {
        System.out.print(String.format(format, args));
    }

    public static void p(String format) {
        System.out.println(format);
    }
    public static void p(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    public static void pIntMatrix(int[][] m) {
        for (int[] obs : m) {
            p(Arrays.toString(obs));
        }
    }

    public static <T> String getCollectionMsg(Collection<T> collection) {
        return getCollectionMsg(collection, new MsgCollector<T>(){
            @Override
            public String getMsg(T o) {
                return o.toString();
            }
        });
    }

    public static <T> String getArrayMsg(T... t) {
        return getCollectionMsg(Arrays.asList(t), new MsgCollector<T>(){
            @Override
            public String getMsg(T o) {
                return o.toString();
            }
        });
    }

    public static <T> String getCollectionMsg(Collection<T> collection, MsgCollector<T> msgCollector) {
        StringBuilder sb = new StringBuilder();
        if (collection == null) {
            sb.append("NULL");
            return sb.toString();
        } else {
            sb.append("[");
            for (T o : collection) {
                if (o == null) {
                    sb.append("null,");
                } else {
                    sb.append(msgCollector.getMsg(o)).append(",");
                }
            }
            sb.append("size=").append(collection.size()).append("]");
        }
        return sb.toString();
    }

    public abstract static class MsgCollector<T> {
        public abstract String getMsg(T element);
    }


}
