package android.ext;

import android.content.DialogInterface;
import android.view.View.OnClickListener;
import java.util.Arrays;

public class ra extends re implements View.OnClickListener {
    public static String a;

    static {
        ra.a = null;
    }

    public ra() {
        super(0x7F070102, 0x7F020034);  // string:search_known_value "Known (exact) search"
    }

    public static int a(String s, int v, boolean z) {
        try {
            rb rb0 = ra.b(s, v, z);
            int v1 = rb0.c.length - 1;
            int v2 = 0;
            for(int v3 = 0; true; v3 = v4 + v3) {
                if(v2 >= v1) {
                    return v3 + 1;
                }
                int v4 = d.d(rb0.c[v2]);
                ++v2;
            }
        }
        catch(NumberFormatException unused_ex) {
            return 2;
        }
    }

    public static rc a(pv pv0, String s, int v, int v1) {
        String s1 = s.trim();
        String s2 = "~~";
        if(s1.contains("~~")) {
            v1 = v1 == 0x20000000 ? 0x10000000 : 0x20000000;
        }
        else {
            s2 = "~";
        }
        String[] arr_s = s1.split(s2);
        if(arr_s.length > 2) {
            throw new NumberFormatException(qk.a(0x7F070189) + " \'" + s2 + '\'');  // string:too_many "Too many"
        }
        if(arr_s.length != 2) {
            arr_s = (String[])Arrays.copyOf(arr_s, 2);
        }
        long[] arr_v = new long[2];
        int[] arr_v1 = new int[2];
        for(int v2 = 1; v2 >= 0; --v2) {
            String s3 = arr_s[v2];
            String s4 = s3 == null ? "" : s3.trim();
            pv0 = ps.a(pv0, s4, (v2 == 1 ? v : arr_v1[1]), false);
            if(v == 0x7F && pv0.c == 0x40 && "BWDXFQEAbwdxfqea".indexOf(s4.charAt(s4.length() - 1)) == -1) {
                pv0.c |= 16;
            }
            arr_v[v2] = pv0.a;
            arr_v1[v2] = pv0.c;
        }
        int v3 = arr_v1[1] & arr_v1[0];
        String s5 = v3 == 0 ? "" + qk.a(0x7F07018D) + '\n' : "";  // string:range_bounds_diff_types "Range bounds must be the same type."
        if(s5.length() > 0) {
            throw new NumberFormatException(s5);
        }
        if(v == 0x7F && (v3 & 0x20) == 0) {
            for(int v4 = 0; v4 < 2; ++v4) {
                if((arr_v1[v4] & 0x20) != 0) {
                    arr_v[v4] = Double.doubleToRawLongBits(arr_v[v4]);
                }
            }
        }
        rc rc0 = new rc();
        rc0.a = arr_v[0];
        rc0.b = arr_v[1];
        rc0.c = v3;
        rc0.d = v1;
        ra.a(rc0, s1);
        return rc0;
    }

    public static rd a(String s, boolean z) {
        if(!ps.d(s) && ps.e(s) == 0 && (s.indexOf(88) != -1 || s.indexOf(120) != -1)) {
            rd rd0 = new rd();
            String[] arr_s = s.split("[Xx]");
            String s1 = arr_s.length == 2 ? arr_s[1] : "";
            int v = (int)ps.a(null, s1, 2, false).a;
            rd0.a = arr_s.length <= 0 ? "" : arr_s[0];
            if(z && (v < 1 || v > 0x1000)) {
                pt pt0 = new pt(Tools.a(qk.a(0x7F070122), new Object[]{s1}) + " [1; 4096]");  // string:number_out_of_range "Number \'__s__\' out of possible range:"
                pt0.a(s1);
                throw pt0;
            }
            rd0.b = v;
            return rd0;
        }
        return null;
    }

    private static void a(rc rc0, String s) {
        int v = 0x20000000;
        int v1 = rc0.c & 0x7F;
        long v2 = 1L << d.d(v1) * 8 - 1;
        if(Integer.bitCount(v1) == 1 && (v1 != 16 && v1 != 0x40) && s.indexOf(45) == -1 && (rc0.a & v2) == 0L && (v2 & rc0.b) != 0L) {
            la.a(("unsigned search 3: \'" + s + "\' " + rc0.a + ' ' + rc0.b + ' ' + Integer.toHexString(v1) + ' ' + Integer.toHexString(rc0.d)));
            long v3 = rc0.b;
            rc0.b = rc0.a;
            rc0.a = v3;
            if(rc0.d == 0x20000000) {
                v = 0x10000000;
            }
            rc0.d = v;
            la.a(("unsigned search 4: \'" + s + "\' " + rc0.a + ' ' + rc0.b + ' ' + Integer.toHexString(v1) + ' ' + Integer.toHexString(rc0.d)));
        }
    }

    public static boolean a(byte b, int v, byte[] arr_b, long v1, long v2, boolean z, long v3) {
        int v4 = v & 0x7F;
        MainService mainService0 = MainService.instance;
        if(mainService0.aj != 0L && !z) {
            v4 &= MainService.a() & 0x7F;
        }
        if(v4 == 0) {
            mainService0.a(b);
            return true;
        }
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L && z) {
            mainService0.a(b);
        }
        if(mainService0.aj == 0L) {
            mainService0.ak = false;
            mainService0.k.l(b);
        }
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, v4, arr_b, v1, v2, v3);
        MainService.a(v4, b);
        return false;
    }

    private static boolean a(byte b, long v, long v1, int v2, int v3, long v4, long v5, boolean z, long v6) {
        MainService mainService0 = MainService.instance;
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L && z) {
            mainService0.a(b);
        }
        if(mainService0.aj == 0L) {
            mainService0.ak = false;
            mainService0.k.l(b);
        }
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, v, v1, v2, v3, v4, v5, v6);
        MainService.a(v3, b);
        return false;
    }

    public static boolean a(byte b, String s, int v, boolean z, int v1, long v2, long v3, boolean z1, long v4) {
        String s1;
        int v10;
        int v5 = v & 0x7F;
        int v6 = v1 & 0x3C000000;
        MainService mainService0 = MainService.instance;
        if(ps.d(s)) {
            boolean z2 = ra.a(b, (s.charAt(0) == 59 ? 2 : 1), ps.a(s), v2, v3, z1, v4);
            ra.a = s;
            return z2;
        }
        if(s.indexOf(59) != -1) {
            return ra.a(b, s, v5, s.contains("::"), z, v6, v2, v3, z1, v4);
        }
        if(s.indexOf(0x7E) != -1 && ps.e(s) == 0) {
            return ra.b(b, s, v5, z, v6, v2, v3, z1, v4);
        }
        if(mainService0.aj != 0L && !z1) {
            v5 &= MainService.a() & 0x7F;
        }
        if(v5 == 0) {
            mainService0.a(b);
            return true;
        }
        rd rd0 = ra.a(s, true);
        int v7 = rd0 == null ? 0 : rd0.b;
        if(rd0 != null) {
            s = rd0.a;
        }
        pv pv0 = new pv();
        long v8 = d.a(pv0, s, v5);
        int v9 = pv0.c & v5;
        if(Integer.bitCount(v9) > 1) {
            v10 = d.a(v9, v8, pv0.b);
        }
        else {
            if(!z && (v9 != 16 && v9 != 0x40) && (v6 == 0x4000000 || v6 == 0x8000000) && s.indexOf(45) == -1 && (1L << d.d(v9) * 8 - 1 & v8) != 0L) {
                la.a(("unsigned search 1: \'" + s + "\' " + Integer.toHexString(v9) + ' ' + false + ' ' + Integer.toHexString(v6)));
                if(v6 == 0x8000000) {
                    s1 = s + "~0";
                    v6 = 0x10000000;
                }
                else if(v6 == 0x4000000) {
                    s1 = s + "~-1";
                    v6 = 0x20000000;
                }
                else {
                    s1 = s;
                }
                la.a(("unsigned search 2: \'" + s1 + "\' " + Integer.toHexString(v9) + ' ' + false + ' ' + Integer.toHexString(v6)));
                return ra.a(b, s1, v9, ((byte)false), v6, v2, v3, z1, v4);
            }
            v10 = v9;
        }
        if(z && v7 == 0) {
            v6 = 0x2000000;
        }
        int v11 = v6 | v10;
        if(v7 != 0) {
            if(z) {
                throw new NumberFormatException(Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F070224), qk.a(0x7F070117)}));  // string:does_not_support "\"__s__\" does not support \"__s__\"."
            }
            v11 |= 0x200000;
        }
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L && z1) {
            mainService0.a(b);
        }
        if(mainService0.aj == 0L) {
            mainService0.ak = false;
            mainService0.k.l(b);
        }
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, v8, v7, v11, v2, v3, v4);
        MainService.a(v10, b);
        return false;
    }

    private static boolean a(byte b, String s, int v, boolean z, boolean z1, int v1, long v2, long v3, boolean z2, long v4) {
        int v5;
        rb rb0 = ra.b(s.trim(), v, z);
        String s1 = z1 ? "" + Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F07012F), qk.a(0x7F070117)}) + '\n' : "";  // string:does_not_support "\"__s__\" does not support \"__s__\"."
        if(v1 == 0x10000000 || v1 == 0x20000000) {
            v5 = (z ? 0x400000 : 0) | v1;
        }
        else {
            s1 = s1 + Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F07012F), d.b().get(v1)}) + '\n';  // string:does_not_support "\"__s__\" does not support \"__s__\"."
            v5 = z ? 0x400000 : 0;
        }
        if(s1.length() > 0) {
            throw new NumberFormatException(s1);
        }
        return ra.a(b, rb0.a, rb0.b, rb0.c, rb0.d, v5, v2, v3, z2, v4);
    }

    public static boolean a(byte b, short v, long v1, long v2, long v3) {
        MainService mainService0 = MainService.instance;
        if(mainService0.aj == 0L) {
            mainService0.a(b);
            return true;
        }
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        mainService0.b(b);
        mainService0.al = false;
        int v4 = mainService0.ap == null || !mainService0.ap.n ? 4 : 0x20;
        mainService0.k.a(b, v, v4, v1, v2, v3);
        MainService.a(v4, b);
        return false;
    }

    private static boolean a(byte b, long[] arr_v, long[] arr_v1, int[] arr_v2, int v, int v1, long v2, long v3, boolean z, long v4) {
        MainService mainService0 = MainService.instance;
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L && z) {
            mainService0.a(b);
        }
        if(mainService0.aj == 0L) {
            mainService0.ak = false;
            mainService0.k.l(b);
        }
        mainService0.i();
        mainService0.al = false;
        mainService0.k.a(b, v1, v, arr_v2, arr_v, arr_v1, v2, v3, v4);
        int v5 = 0;
        for(int v6 = 0; v6 < arr_v2.length; ++v6) {
            v5 |= arr_v2[v6];
        }
        MainService.a(v5, b);
        return false;
    }

    public static boolean a(String s, int v, boolean z, int v1, long v2, long v3, boolean z1, long v4) {
        String s1 = ra.c(s);
        boolean z2 = ra.a(((byte)0), s1, v, z, v1, v2, v3, z1, v4);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            if(z1) {
                qm0.write("\ngg.clearResults()\n");
            }
            if(!z1 && MainService.instance.aj != 0L) {
                qm0.write("gg.refineNumber(");
            }
            else {
                qm0.write("gg.searchNumber(");
            }
            Script.Consts.b(qm0, s1);
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.b, v);
            qm0.write(", ");
            qm0.write(Boolean.toString(z));
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.d, v1);
            qm0.write(", ");
            Script.Consts.a(qm0, v2);
            qm0.write(", ");
            Script.Consts.a(qm0, v3);
            qm0.write(", ");
            qm0.write(Long.toString(v4));
            qm0.write(")\n");
        }
        return z2;
    }

    @Override  // android.ext.re
    public void a(DialogInterface dialogInterface0, int v) {
        boolean z = true;
        String s = this.h.f();
        boolean z1 = this.h.k();
        int v1 = this.h.e();
        long v2 = this.h.d(0);
        long v3 = this.h.d(1);
        if(this.g != -3) {
            z = false;
        }
        ra.a(s, v, z1, v1, v2, v3, z, this.h.p());
    }

    public void a(String s) {
        if(s == null) {
            s = "";
        }
        this.b = s;
        this.c().performClick();
    }

    private static rb b(String s, int v, boolean z) {
        String[] arr_s = s.trim().split((z ? "::" : ":"));
        if(arr_s.length > 2) {
            throw new NumberFormatException(qk.a(0x7F070189) + " \'" + (z ? "::" : ":") + '\'');  // string:too_many "Too many"
        }
        long v1 = arr_s.length == 1 ? 0x200L : ps.i(arr_s[1]).a;
        if(((int)v1) < 2 || ((int)v1) > 0x10000) {
            pt pt0 = new pt(Tools.a(qk.a(0x7F07011D), new Object[]{2, 0x10000}) + ' ' + ((int)v1));  // string:invalid_area "Group size must be between __d__ and __d__:"
            pt0.a(0x10000L);
            throw pt0;
        }
        String[] arr_s1 = arr_s[0].split(";");
        if(arr_s1.length < 2) {
            throw new NumberFormatException(qk.a(0x7F07011E));  // string:union_need_two_numbers "For group search there must be at least two numbers"
        }
        if(arr_s1.length > 0x40) {
            throw new NumberFormatException(Tools.c(0x7F07011F) + ": " + 0x40);  // string:too_many_union_numbers "Too many numbers, more than:"
        }
        rb rb0 = new rb(arr_s1.length);
        pv pv0 = null;
        for(int v2 = 0; v2 < arr_s1.length; ++v2) {
            if(arr_s1[v2].indexOf(0x7E) == -1) {
                pv0 = ps.a(pv0, arr_s1[v2], v, false);
                rb0.a[v2] = pv0.a;
                rb0.b[v2] = 0L;
                rb0.c[v2] = pv0.c;
            }
            else {
                rc rc0 = ra.a(pv0, arr_s1[v2], v, 0x20000000);
                rb0.a[v2] = rc0.a;
                rb0.b[v2] = rc0.b;
                rb0.c[v2] = rc0.d | rc0.c;
            }
        }
        rb0.d = (int)v1;
        return rb0;
    }

    private static boolean b(byte b, String s, int v, boolean z, int v1, long v2, long v3, boolean z1, long v4) {
        String s1 = s.trim();
        rd rd0 = ra.a(s1, true);
        int v5 = rd0 == null ? 0 : rd0.b;
        if(rd0 != null) {
            s1 = rd0.a;
        }
        rc rc0 = ra.a(null, s1, v, v1);
        String s2 = z ? "" + Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F07018A), qk.a(0x7F070117)}) + '\n' : "";  // string:does_not_support "\"__s__\" does not support \"__s__\"."
        if(v1 != 0x10000000 && v1 != 0x20000000) {
            s2 = s2 + Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F07018A), d.b().get(v1)}) + '\n';  // string:does_not_support "\"__s__\" does not support \"__s__\"."
        }
        if(s2.length() > 0) {
            throw new NumberFormatException(s2);
        }
        if(v5 != 0) {
            rc0.c |= 0x200000;
        }
        return ra.a(b, rc0.a, rc0.b, v5, rc0.c | rc0.d, v2, v3, z1, v4);
    }

    public void b(String s) {
        this.c().performClick();
        MemoryRange memoryRange0 = this.h.d;
        memoryRange0.setType(2);
        memoryRange0.setAddress(s);
    }

    @Override  // android.ext.re
    public void onDismiss(DialogInterface dialogInterface0) {
        this.b = this.h.f();
        this.c = this.h.e();
        MainService.ai = this.h.d();
        super.onDismiss(dialogInterface0);
    }
}

