package uz.pdp.frontend.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public interface ScanUtil {
    Scanner strScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    static int scanInt(String hint){
        System.out.println(hint);
        return intScanner.nextInt();
    }

    static String scanString(String hint){
        System.out.println(hint);
        return strScanner.nextLine();
    }

    static BigDecimal scanBigDec(String hint){
        System.out.println(hint);
        String sum = strScanner.nextLine();
        return new BigDecimal(sum);
    }
}
