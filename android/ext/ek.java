package android.ext;

import android.content.SharedPreferences;
import java.text.DecimalFormat;

public class ek {
    private static int a;
    private static el b;
    private static final DecimalFormat c;
    private static final DecimalFormat d;

    static {
        ek.b = new el(0, 0L, 0L, 0L, 0, 0L, 0, 0, 0, 0.0, 0);
        ek.c = new DecimalFormat("0.0#######E0");
        ek.d = new DecimalFormat("###,###,##0.0##########");
    }

    public static int a() [...] // 潜在的解密器

    public static int a(long v) {
        return (0xFFFFFFFF80000000L & v) == 0L ? ((int)(v & 0x7FFFFFFFL)) : 0x80000000 | ((int)(v & 0x7FFFFFFFL));
    }

    public static int a(String s) {
        String s1 = s.trim();
        Integer integer0 = null;
        int v = 10;
        if(s1.indexOf(46) != -1) {
            integer0 = Float.floatToRawIntBits(Float.parseFloat(s1));
        }
        int v1 = s1.length();
        if(v1 >= 1) {
            int v2 = s1.charAt(v1 - 1);
            if(v2 == 104) {
                v = 16;
                s1 = s1.substring(0, v1 - 1);
            }
            if(v2 == 102) {
                s1 = s1.substring(0, v1 - 1);
                integer0 = Float.floatToRawIntBits(Float.parseFloat(s1));
            }
        }
        if(integer0 == null) {
            integer0 = ek.a(ps.a(s1, v));
        }
        return (int)integer0;
    }

    public static el a(long v, long v1, String s, String s1, int v2, String s2, int v3) {
        int v11;
        int v10;
        int v4 = v == 0L ? 0 : 1;
        if(v1 != -1L) {
            v4 |= 2;
        }
        long v5 = 0L;
        int v6 = 0;
        if(s != null) {
            v4 |= 4;
            pv pv0 = ps.a(null, s.trim(), 0x7F, false);
            v5 = pv0.a;
            v6 = pv0.c;
        }
        long v7 = 0L;
        int v8 = 0;
        if(s1 != null) {
            v4 |= 8;
            pv pv1 = ps.a(null, s1.trim(), 0x7F, false);
            v7 = pv1.a;
            v8 = pv1.c;
        }
        if(v2 != 0) {
            v4 |= 16;
        }
        int v9 = 0;
        double f = 0.0;
        if(s2 == null) {
            v11 = v4;
        }
        else {
            String s3 = s2.trim();
            if(s3.length() <= 0 || s3.charAt(0) != 33) {
                v10 = 0x20000000;
            }
            else {
                s3 = s3.substring(1);
                v10 = 0x10000000;
            }
            f = Double.longBitsToDouble(ps.a(null, s3, 0x40, false).a);
            v9 = v10;
            v11 = v4 | 0x20;
        }
        if(v3 != 0) {
            v11 |= 0x40;
        }
        return new el(v11, v, v1, v5, v6, v7, v8, v2, v9, f, v3);
    }

    public static String a(double f) {
        double f1 = Math.abs(f);
        return (0.000001 >= f1 || f1 >= 10000000000.0) && f1 != 0.0 ? ek.c.format(f).replace('E', 'e') : ek.d.format(f).replace('E', 'e');
    }

    public static String a(float f) {
        return ek.a(f);
    }

    public static void a(byte b, int v, int v1, el el0) {
        MainService.instance.k.a(b, v, v1, el0.a, el0.b, el0.c, el0.d, el0.e, el0.f, el0.g, el0.h, el0.i, el0.j, el0.k);
    }

    public static void a(int v) {
        ek.a = Math.min(Math.max(1, v), 100000);
    }

    public static void a(MainService mainService0) {
        int v;
        SharedPreferences sharedPreferences0 = Tools.s();
        try {
            v = ek.a(sharedPreferences0.getString(qk.b(0x7F0B010B), "100"));  // id:eMaxShow
        }
        catch(NumberFormatException unused_ex) {
            v = 100;
        }
        ek.a(v);
    }

    public static void a(qm qm0, boolean z) {
        qm0.write("gg.getResults(");
        qm0.write("0");
        if(z) {
            el el0 = ek.b;
            int v = el0.a;
            qm0.write(", ");
            qm0.write("nil");
            qm0.write(", ");
            if((v & 1) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, el0.b);
            }
            qm0.write(", ");
            if((v & 2) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, el0.c);
            }
            qm0.write(", ");
            if((v & 4) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, d.b(0L, el0.d, el0.e));
            }
            qm0.write(", ");
            if((v & 8) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, d.b(0L, el0.f, el0.g));
            }
            qm0.write(", ");
            if((v & 16) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, qm0.a.b, el0.h);
            }
            qm0.write(", ");
            if((v & 0x20) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, String.valueOf((el0.i == 0x10000000 ? "|" : "")) + el0.j);
            }
            qm0.write(", ");
            if((v & 0x40) == 0) {
                qm0.write("nil");
            }
            else {
                Script.Consts.a(qm0, qm0.a.h, el0.k);
            }
        }
        qm0.write(")\n");
    }

    public static void a(String s, String s1, String s2, String s3, int v, String s4, int v1) {
        ek.b = ek.a((s == null ? 0L : ps.a(null, s.trim() + 'h', 0x7F, false).a), (s1 == null ? -1L : ps.a(null, s1.trim() + 'h', 0x7F, false).a), s2, s3, v, s4, v1);
    }

    public static String b(int v) {
        return ek.a(Float.intBitsToFloat(v));
    }

    public static String b(long v) {
        return ek.a(Double.longBitsToDouble(v));
    }

    public static boolean b() [...] // 潜在的解密器

    public static String c(long v) {
        return ek.b(((int)v));
    }

    public static void c() {
        ek.a(((byte)0), ((byte)0), ((byte)0), ek.b);
    }
}

