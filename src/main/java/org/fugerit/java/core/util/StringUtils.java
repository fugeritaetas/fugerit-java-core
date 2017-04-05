package org.fugerit.java.core.util;

import java.util.Iterator;
import java.util.List;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public class StringUtils {
    
    public static final char DEFAULT_PAD = ' ';
    
    public static String[] toArray(List l) {
        String[] result = new String[l.size()];
        Iterator it = l.iterator();
        int count = 0;
        while (it.hasNext()) {
            result[count] = (String)it.next();
            count++;
        }
        return result;
    }
    
    
    public static String[] toArray(String str) {
        String[] result = { str };
        return result;
    }
    
    public static String firstWord(String str) {
        String result = str;
        int index = str.indexOf(" ");
        if (index>=0) {
            result = result.substring(0, index);
        }
        return result;
    }
    
    public static boolean containsIgnoreCase(String str, String[] data) {
        boolean result = false;
        for (int k=0; k<data.length && !result; k++) {
            result = (str.equalsIgnoreCase(data[k]));
        }
        return result;
    }
    
    /*
     * <p>Porta la lunghezza di una stringa 
     * esttamente alla lunghezza desiderata.</p>
     * 
     * @param str       la stringa da ridimensionare
     * @param length    la nuova dimensione della stringa
     * @param pad       il carattere da usare per il padding
     * @return          la stringa ridimensionata
     */
    public static String resize(String str, int length, char pad) {
        String result = str;
        if (str.length()<length) {
            result = pad(str, length, pad);
        } else {
            result = truncate(str, length);
        }
        return result;
    }

    /*
     * <p>Porta la lunghezza di una stringa 
     * esttamente alla lunghezza desiderata.</p>
     * 
     * @param str       la stringa da ridimensionare
     * @param length    la nuova dimensione della stringa
     * @return          la stringa ridimensionata
     */
    public static String resize(String str, int length) {
       return resize(str, length, DEFAULT_PAD);
    }
    
    /* 
     * <p>Tronca la lunghezza di una stringa se
     * maggiore di un valore dato.</p>
     * 
     * @param str       la stringa da troncare
     * @param length    le nuove dimensioni della strigna
     * @return          la stringa troncata
     */
    public static String truncate(String str, int length) {
        return str.substring(0, Math.min(str.length(), length));
    }
    
    public static String pad(String str, int length) {
        return pad(str, length, DEFAULT_PAD);
    }
    
    public static String pad(String str, int length, char pad) {
        String result = str;
        while (result.length()<length) {
            result+= pad;
        }
        return result;
    }
    
    private StringUtils() {
        super();
    }

}
