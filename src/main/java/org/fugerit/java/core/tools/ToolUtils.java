package org.fugerit.java.core.tools;

import org.fugerit.java.core.util.StringUtils;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ToolUtils {
    
    
    public static void printInfo(String prg, String auth) {
        System.out.println();
        System.out.println("   //////////////////////////////////////////////");
        System.out.println("  // "+StringUtils.resize(prg, 40)+" //");
        System.out.println(" // "+StringUtils.resize(auth, 40)+" //");
        System.out.println("//////////////////////////////////////////////");
        System.out.println();
    }
    
    private ToolUtils() {
        super();
    }

}
