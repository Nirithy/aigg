package android.ext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class ts {
    private static final ThreadLocal a;
    private static final char[] b;

    static {
        ts.a = new tt();
        ts.b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }

    public static Appendable a(Appendable appendable0, int v, char c, String s) {
        try {
            int v2 = s.length();
            for(int v1 = 0; true; ++v1) {
                if(v1 >= v - v2) {
                    return appendable0.append(s);
                }
                appendable0.append(c);
            }
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
    }

    public static Appendable a(Appendable appendable0, int v, int v1) {
        return ts.a(appendable0, v, '0', Integer.toHexString(v1).toUpperCase(Locale.US));
    }

    public static Appendable a(Appendable appendable0, int v, long v1) {
        return ts.a(appendable0, v, '0', Long.toHexString(v1).toUpperCase(Locale.US));
    }

    public static String a(int v) [...] // 潜在的解密器

    public static String a(int v, char c, String s) {
        int v1 = s.length();
        if(v1 < v) {
            char[] arr_c = (char[])ts.a.get();
            Arrays.fill(arr_c, 0, v - v1, c);
            return new String(arr_c, 0, v);
        }
        return s;
    }

    public static String a(int v, long v1) {
        return ts.a(v, '0', Long.toHexString(v1).toUpperCase(Locale.US));
    }

    public static String a(long v) [...] // 潜在的解密器

    public static String a(String s, Object[] arr_object) {
        return Tools.a(s, arr_object);
    }
}

