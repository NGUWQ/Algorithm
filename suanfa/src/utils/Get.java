package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/25
 * \* Time: 19:04
 */
public class Get {
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(isr);
        String s = buf.readLine();
        return s;
    }


    public  static char getChoice() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public  static int getValue() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    public  static double getDouble() throws IOException {
        String s = getString();
        return Double.parseDouble(s);
    }

}
