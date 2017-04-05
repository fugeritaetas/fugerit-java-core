package org.fugerit.java.core.util;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.fugerit.java.core.util.filter.ObjectFilter;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public class ArrayUtils {

    public static Object[] filter(Object[] data, ObjectFilter filter) {
        Vector v = new Vector();
        for (int k=0; k<data.length; k++) {
            if (filter.accept(data[k])) {
                v.add(data[k]);
            }
        }
        return v.toArray();
    }
    
    public static Object[] asArray(Object data) {
        Object[] result = { data }; 
        return result;
    }
    
    public static String toString(Object[] array) {
        String result = "null";
        if (array!=null) {
            result = "";
            for (int k=0; k<array.length; k++) {
                if (array[k]==null) {
                    result+= "null;";
                } else {
                    result+= array[k].toString()+";";
                }
            }
        }
        return "'"+result+"'";
    }
    
    public static void fillArray(List l, Object[] array) {
        Iterator it = l.iterator();
        int count = 0;
        while (it.hasNext()) {
            array[count] = it.next();
            count++;
        }
    }    
    
    public static long[] fillLongArray(List l) {
        long[] result = new long[l.size()];
        fillLongArray(l, result);
        return result;
    }
    
    public static void fillLongArray(List l, long[] array) {
        Iterator it = l.iterator();
        int count = 0;
        while (it.hasNext()) {
            Number n = (Number)it.next();
            array[count] = n.longValue();
            count++;
        }
    }    
    
    /*
     * <p>Crea un nuovo ArrayUtils</p>
     * 
     * 
     */
    public ArrayUtils() {
        super();
    }

}
