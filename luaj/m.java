package luaj;

import java.io.File;

public class m {
    public static final int[] a;

    static {
        m.a = new int[]{0x60, 0x71, 65, 84, 80, 80, 92, 108, 60, 16, 60, 84, 108, 0x7C, 0x7C, 0x7C, 0x7C, 0x7C, 0x7C, 0x60, 0x60, 0x60, 104, 34, 0xBC, 0xBC, 0xBC, 0x84, 0xE4, 84, 80, 16, 98, 98, 4, 0xE2, 20, 81, 80, 23, 0x7C, 0x60, 0x7C, 0x7C, 0x7C, 0x7C, 0x7C};
    }

    public static int a(int v) [...] // Inlined contents

    public static String a(String s) {
        if(s.startsWith("=")) {
            return s.substring(1);
        }
        if(s.startsWith("@")) {
            s = s.substring(1);
        }
        if(!new File(s).exists()) {
            if(s.length() > 69) {
                s = s.substring(0, 66) + "...";
            }
            return "[string \'" + s + "\']";
        }
        return s;
    }

    public static int b(int v) [...] // Inlined contents

    public static int c(int v) {
        return v >>> 6 & 0x3FFFFFF;
    }

    public static int d(int v) [...] // Inlined contents

    public static int e(int v) [...] // Inlined contents

    public static int f(int v) [...] // Inlined contents

    public static int g(int v) [...] // Inlined contents

    public static boolean h(int v) {
        return (v & 0x100) != 0;
    }

    public static int i(int v) [...] // Inlined contents

    public static int j(int v) {
        return v | 0x100;
    }

    public static int k(int v) {
        return m.a[v] & 3;
    }

    public static int l(int v) {
        return m.a[v] >>> 4 & 3;
    }

    public static int m(int v) {
        return m.a[v] >>> 2 & 3;
    }

    public static boolean n(int v) {
        return (m.a[v] & 0x40) != 0;
    }

    public static boolean o(int v) {
        return (m.a[v] & 0x80) != 0;
    }
}

