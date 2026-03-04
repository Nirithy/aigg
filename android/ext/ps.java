package android.ext;

import android.annotation.SuppressLint;
import android.c.b;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.Editable;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class ps {
    public static String a;
    public static char b;
    private static boolean c;
    private static Charset d;
    private static Charset e;
    private static int[] f;
    private static Pattern g;

    static {
        ps.a = null;
        ps.b = '.';
        ps.c = true;
        ps.updateLocale();
        ad.a(ps.class);
        ps.d = null;
        ps.e = null;
        ps.f = null;
        ps.g = null;
    }

    public static long a(String s, int v) {
        return ps.b(ps.a(s, true), v);
    }

    private static pv a(pv pv0, int v, int v1) {
        switch(v1 & 0x7F) {
            case 16: {
                long v2 = (long)Float.floatToRawIntBits(v);
                pv0.a = v2 >= 0L ? ((long)Float.floatToRawIntBits(v)) : (v2 & 0x7FFFFFFFL) + 0x80000000L;
                pv0.c = 16;
                break;
            }
            case 1: 
            case 2: 
            case 4: 
            case 8: 
            case 0x20: {
                pv0.a = (long)v;
                pv0.c = v1 & 0x7F;
                break;
            }
            case 0x40: {
                pv0.a = Double.doubleToRawLongBits(v);
                pv0.c = 0x40;
                break;
            }
            case 0x7F: {
                pv0.a = (long)v;
                pv0.c = 0x7F;
                break;
            }
            default: {
                la.b(("Unknown flags: " + (v1 & 0x7F) + " we use Auto parsing"));
                pv0.a = (long)v;
                pv0.c = 0x7F;
            }
        }
        pv0.b = v < 0;
        return pv0;
    }

    public static pv a(pv pv0, String s, int v, boolean z) {
        return ps.a(pv0, s, v, z, 0L);
    }

    public static pv a(pv pv0, String s, int v, boolean z, long v1) {
        int v11;
        int v8;
        int v2 = 0x30;
        if(pv0 == null) {
            pv0 = new pv();
        }
        int v3 = s.length();
        switch(v3) {
            case 1: 
            case 2: {
            label_7:
                int v4 = s.charAt(0) == 45 ? 1 : 0;
                int v5 = s.charAt(v3 - 1);
                if(0x30 <= v5 && v5 <= 57) {
                    int v6 = v3 - 1 > v4 ? s.charAt(v3 - 2) : 0x30;
                    if(0x30 <= v6 && v6 <= 57) {
                        int v7 = v6 * 10 + v5 - 0x210;
                        return v4 == 1 ? ps.a(pv0, -v7, v) : ps.a(pv0, v7, v);
                    }
                }
                break;
            }
            case 3: {
                if(s.charAt(0) == 45) {
                    goto label_7;
                }
            }
        }
        String s1 = ps.a(s, true);
        if(ps.d(s1)) {
            v8 = 0x7F;
        }
        else {
            int v9 = ps.e(s1);
            if(v9 == 0) {
                if(s1.length() > 0) {
                    v2 = s1.charAt(s1.length() - 1);
                }
                switch(v2) {
                    case 97: {
                        break;
                    }
                    case 98: {
                        v9 = 1;
                        goto label_41;
                    }
                    case 100: {
                    label_43:
                        if(v9 == 0) {
                            v9 = 4;
                        }
                        goto label_45;
                    }
                    case 101: {
                    label_51:
                        if(v9 == 0) {
                            v9 = 0x40;
                        }
                        break;
                    }
                    case 102: {
                    label_47:
                        if(v9 == 0) {
                            v9 = 16;
                        }
                        goto label_49;
                    }
                    case 0x71: {
                    label_49:
                        if(v9 == 0) {
                            v9 = 0x20;
                        }
                        goto label_51;
                    }
                    case 0x77: {
                    label_41:
                        if(v9 == 0) {
                            v9 = 2;
                        }
                        goto label_43;
                    }
                    case 120: {
                    label_45:
                        if(v9 == 0) {
                            v9 = 8;
                        }
                        goto label_47;
                    }
                    default: {
                        v8 = v & 0x7F;
                        goto label_59;
                    }
                }
                if(v9 == 0) {
                    v9 = 0x7F;
                }
                if(z) {
                    throw ps.a(s1, s, 0, false);
                }
                s1 = s1.substring(0, s1.length() - 1);
            }
            else {
                int v10 = s1.charAt(1);
                if(v10 == 84) {
                    s1 = Integer.toHexString(ai.b(null, v1, s1.substring(2).trim())).toUpperCase(Locale.US) + 'h';
                }
                else if(v10 != 65) {
                }
                else if(s1.charAt(2) == 56) {
                    s1 = Integer.toHexString(ag.a(null, null, v1, s1.substring(3).trim())).toUpperCase(Locale.US) + 'h';
                }
                else {
                    s1 = Integer.toHexString(ai.a(null, v1, s1.substring(2).trim())).toUpperCase(Locale.US) + 'h';
                }
            }
            v8 = v9;
        }
    label_59:
        switch(v8) {
            case 1: {
                v11 = 0;
                goto label_68;
            }
            case 2: {
                v11 = 3;
            label_68:
                if(v11 == 3) {
                    v11 = 1;
                }
                goto label_72;
            }
            case 4: 
            case 8: {
                v11 = 3;
            label_72:
                if(v11 == 3) {
                    v11 = 2;
                }
                break;
            }
            case 16: {
                return ps.c(pv0, s1, s);
            }
            case 0x20: 
            case 36: {
                v11 = 3;
                break;
            }
            case 0x40: {
                return ps.d(pv0, s1, s);
            }
            case 0x7F: {
                return ps.e(pv0, s1, s);
            }
            default: {
                la.b(("Unknown flags: " + v8 + " we use Auto parsing"));
                return ps.e(pv0, s1, s);
            }
        }
        pv pv1 = ps.b(pv0, s1, s);
        pv1.c &= v8;
        if(pv1.c == 0) {
            Object[] arr_object = ps.a();
            String s2 = ts.a(qk.a(" [__d__; __d__]."), new Object[]{arr_object[v11 * 2], arr_object[v11 * 2 + 1]});
            pt pt0 = new pt(ts.a(ps.a(0x7F070122), new Object[]{s}) + (s2 == null ? " possibleRange for " + v11 : s2));  // string:number_out_of_range "Number \'__s__\' out of possible range:"
            pt0.a(s);
            if(s2 != null) {
                pt0.a(arr_object[v11 * 2]);
                pt0.a(arr_object[v11 * 2 + 1]);
            }
            throw pt0;
        }
        return pv1;
    }

    public static pv a(pv pv0, String s, String s1) {
        return ps.d(pv0, ps.a(s, true), s1);
    }

    private static NumberFormatException a(String s, String s1, int v, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(ps.a(0x7F070120));  // string:invalid_number "Invalid number:"
        stringBuilder0.append(" \'");
        stringBuilder0.append(s1);
        stringBuilder0.append("\'.");
        if(v == 10 && s.matches(".*[A-Fa-f]+.*")) {
            stringBuilder0.append("\n\n");
            stringBuilder0.append(ps.a(0x7F070149));  // string:forgot_h "Did you forget to \'__hex__\' at the end?"
        }
        if(z && s.indexOf(46) != -1) {
            stringBuilder0.append("\n\n");
            stringBuilder0.append(ps.a(0x7F0702C6));  // string:integer_type "This data type is only for integer values and does not support 
                                                      // fractional values. Use __type_float__ or __type_double__ for fractional values."
        }
        stringBuilder0.append("\n\n");
        stringBuilder0.append(ps.a(0x7F070307));  // string:locale_ui "In your locale"
        stringBuilder0.append(" (");
        stringBuilder0.append(ad.c());
        stringBuilder0.append("):\n");
        stringBuilder0.append(Tools.a(ps.a(0x7F070309), new Object[]{Character.valueOf('.'), ps.a}));  // string:locale_desc "\'__s__\' - decimal separator\n\'__s__\' - thousands separator\n\'__semicolon__\' 
                                                                                                       // - number separator in group search"
        NumberFormatException numberFormatException0 = new pt(stringBuilder0.toString());
        ((pt)numberFormatException0).a("\'" + s1 + "\'");
        return numberFormatException0;
    }

    public static String a(int v) {
        return qk.a(v);
    }

    public static String a(String s) {
        return s.replace(" ", "").replace(" ", "").replace(ps.a, "").replace('.', '.');
    }

    private static String a(String s, boolean z) {
        if(s == null) {
            throw new NumberFormatException(ps.a(0x7F070121));  // string:input_number "Input number"
        }
        if(ps.d(s) || ps.e(s) != 0) {
            return s;
        }
        String s1 = s.trim().toLowerCase(Locale.US);
        if(z) {
            s1 = ps.a(s1);
        }
        if(s1.length() == 0) {
            throw new NumberFormatException(ps.a(0x7F070121));  // string:input_number "Input number"
        }
        if((Config.B & 0x1000) == 0) {
            return s1;
        }
        else {
            Pattern pattern0 = ps.g;
            if(pattern0 == null) {
                try {
                    pattern0 = Pattern.compile(("[^\\p{XDigit}" + '.' + ps.a + ".hrwxqHRWXQ~?*^$:;-]+"));
                    ps.g = pattern0;
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
            }
            if(pattern0 != null) {
                try {
                    String s2 = pattern0.matcher(s1).replaceAll("");
                    if(!s2.equals(s1)) {
                        la.a(("strip: \'" + pattern0.pattern() + "\': \'" + s1 + "\' -> \'" + s2 + '\''));
                        return s2;
                    }
                    return s1;
                }
                catch(Throwable throwable1) {
                }
            }
        }
        la.a(throwable1);
        return s1;
    }

    public static Charset a(boolean z) {
        Charset charset0 = z ? ps.e : ps.d;
        if(charset0 == null) {
            if(z) {
                charset0 = Build.VERSION.SDK_INT < 19 ? Charset.forName("UTF-16LE") : StandardCharsets.UTF_16LE;
                ps.e = charset0;
                return charset0;
            }
            charset0 = Build.VERSION.SDK_INT < 19 ? Charset.forName("UTF-8") : StandardCharsets.UTF_8;
            ps.d = charset0;
            return charset0;
        }
        return charset0;
    }

    private static void a(pv pv0) {
        int[] arr_v = ps.f;
        if(arr_v == null) {
            arr_v = new int[]{1, 1, 2, 2, 4, 4, 8, 4};
            ps.f = arr_v;
        }
        int v1 = 0;
        for(int v = 0; v < arr_v.length; v += 2) {
            int v2 = arr_v[v + 1];
            if(!pv0.b) {
                if(v2 == 8 || pv0.a >> v2 * 8 == 0L) {
                    v1 |= arr_v[v];
                }
            }
            else if(pv0.a >> v2 * 8 - 1 == -1L >> v2 * 8 - 1) {
                v1 |= arr_v[v];
            }
        }
        pv0.c = v1 | 0x20;
    }

    public static byte[] a(long v) {
        byte[] arr_b = new byte[9];
        int v1 = -1;
        for(int v2 = 0; v2 < 8; ++v2) {
            byte b = (byte)(((int)(0xFFL & v)));
            arr_b[v2] = b;
            if(b != 0 && v1 < v2) {
                v1 = v2;
            }
            v >>= 8;
        }
        arr_b[8] = (byte)v1;
        return arr_b;
    }

    public static byte[] a(CharSequence charSequence0) {
        int v5;
        boolean z1;
        byte[] arr_b1;
        if(charSequence0.length() < 1) {
            return b.c;
        }
        int v = charSequence0.charAt(0);
        byte[] arr_b = b.c;
        boolean z = !(charSequence0 instanceof String) && charSequence0 instanceof Editable;
    alab1:
        switch(v) {
            case 59: {
                z1 = true;
            label_11:
                arr_b1 = charSequence0.toString().substring(1).getBytes(ps.a(z1));
                if(z) {
                    String s = " " + InOut.b(arr_b1, 0, arr_b1.length).trim();
                    ((Editable)charSequence0).replace(1, charSequence0.length(), s);
                    return arr_b1;
                }
                break;
            }
            case 72: 
            case 104: {
                return ps.a(arr_b, charSequence0.toString().substring(1));
            }
            case 81: 
            case 0x71: {
                int v1 = 1;
                int v3 = 1;
                arr_b1 = arr_b;
                for(int v2 = 0; true; v2 = v5) {
                    if(v1 >= charSequence0.length()) {
                        break alab1;
                    }
                    int v4 = charSequence0.charAt(v1);
                    String s1 = null;
                    if((v2 == 0 ? v4 == 39 || v4 == 34 : v4 == v2)) {
                        if(v3 != v1) {
                            s1 = charSequence0.toString().substring(v3, v1);
                        }
                        if(v2 != 0) {
                            v4 = 0;
                        }
                        v3 = v1 + 1;
                        v5 = v4;
                    }
                    else if(v1 == charSequence0.length() - 1) {
                        s1 = charSequence0.toString().substring(v3);
                        v5 = v2;
                    }
                    else {
                        v5 = v2;
                    }
                    if(s1 != null && s1.length() > 0) {
                        if(v2 != 0) {
                            byte[] arr_b2 = s1.getBytes(ps.a(v2 == 34));
                            if(z) {
                                String s2 = InOut.b(arr_b2, 0, arr_b2.length).trim();
                                ((Editable)charSequence0).replace(v1 - s1.length() - 1, v1 + 1, s2);
                                int v6 = s2.length() - (s1.length() + 2);
                                v1 += v6;
                                v3 += v6;
                            }
                            else {
                                int v7 = arr_b1.length;
                                arr_b1 = Arrays.copyOf(arr_b1, arr_b2.length + v7);
                                System.arraycopy(arr_b2, 0, arr_b1, v7, arr_b2.length);
                            }
                        }
                        else if(!z) {
                            arr_b1 = ps.a(arr_b1, s1);
                        }
                    }
                    ++v1;
                }
            }
            default: {
                z1 = false;
                goto label_11;
            }
        }
        return arr_b1;
    }

    private static byte[] a(byte[] arr_b, String s) {
        String s1 = s.replace(" ", "").replace("\t", "").replace("\r", "").replace("\n", "");
        if(s1.length() >= 2) {
            int v = s1.length();
            int v1 = arr_b.length;
            arr_b = Arrays.copyOf(arr_b, (v & -2) / 2 + v1);
            for(int v2 = 0; v2 < (v & -2); v2 += 2) {
                arr_b[v2 / 2 + v1] = (byte)Integer.parseInt(s1.substring(v2, v2 + 2), 16);
            }
        }
        return arr_b;
    }

    public static Object[] a() {
        try {
            return new Object[]{((byte)(byte)0x80), 0xFFL, ((short)(short)0x8000), 0xFFFFL, 0x80000000, 0xFFFFFFFFL, 0x8000000000000000L, new BigInteger("9223372036854775807").add(BigInteger.ONE).shiftLeft(1).subtract(BigInteger.ONE)};
        }
        catch(ArithmeticException arithmeticException0) {
            la.c("Error get possible range for long as BigInteger", arithmeticException0);
            return new Object[]{((byte)(byte)0x80), 0xFFL, ((short)(short)0x8000), 0xFFFFL, 0x80000000, 0xFFFFFFFFL, 0x8000000000000000L, 0x7FFFFFFFFFFFFFFFL};
        }
    }

    private static long b(String s, int v) {
        String s1 = ps.a(s, false);
        try {
            return Long.parseLong(s1, v);
        }
        catch(NumberFormatException numberFormatException0) {
            try {
                BigInteger bigInteger0 = new BigInteger(s1, v);
                if(bigInteger0.bitLength() > 0x40) {
                    throw numberFormatException0;
                }
                return bigInteger0.longValue();
            }
            catch(NumberFormatException unused_ex) {
                throw numberFormatException0;
            }
            catch(ArithmeticException arithmeticException0) {
                la.b(("Error parse " + s1 + " with " + v + " as BigInteger"), arithmeticException0);
                if(v == 10) {
                    try {
                        return (long)Double.parseDouble(s1);
                    }
                    catch(NumberFormatException unused_ex) {
                        throw numberFormatException0;
                    }
                }
                throw numberFormatException0;
            }
        }
    }

    private static pv b(pv pv0, String s, String s1) {
        int v4;
        int v3;
        long v;
        String s2 = ps.a(s, false);
        if(s2.length() > 0) {
            pv0.b = s2.charAt(0) == 45;
            if(ps.d(s2)) {
                v = ps.h(s2);
            }
            else {
                int v1 = s2.length();
                int v2 = s2.charAt(v1 - 1);
                if(v2 != 104 && v2 != 0x72) {
                    v4 = 0;
                    v3 = 10;
                }
                else {
                    v3 = 16;
                    s2 = s2.substring(0, v1 - 1);
                    v4 = v2 == 0x72 ? 1 : 0;
                }
                try {
                    v = ps.b(s2, v3);
                }
                catch(NumberFormatException numberFormatException0) {
                    NumberFormatException numberFormatException1 = ps.a(s2, s1, v3, true);
                    numberFormatException1.initCause(numberFormatException0);
                    throw numberFormatException1;
                }
                if(v4 != 0) {
                    v = Long.reverseBytes(v);
                    int v5 = (v1 >> 1) * 8;
                    if(v5 < 0x40) {
                        v = v >> 0x40 - v5 & (1L << v5) - 1L;
                    }
                }
            }
        }
        else {
            v = 0L;
        }
        pv0.a = v;
        if(pv0.a == 0L && pv0.b) {
            pv0.b = false;
        }
        ps.a(pv0);
        return pv0;
    }

    public static String b(String s) {
        return s.replace(" ", "").replace(" ", "").replace(",", "").replace('.', '.');
    }

    private static pv c(pv pv0, String s, String s1) {
        float f1;
        float f = 0.0f;
        String s2 = ps.a(s, false);
        if(s2.length() <= 0) {
            f1 = 0.0f;
        }
        else if(s2.charAt(s2.length() - 1) == 104 || s2.charAt(s2.length() - 1) == 0x72) {
            long v = ps.b(pv0, s2, s1).a;
            f1 = v >= 0L ? ((float)v) : ((float)(v & 0x7FFFFFFFFFFFFFFFL)) + 9223372036854776000.0f;
        }
        else {
            try {
                f1 = Float.parseFloat(s2);
                if(Float.isInfinite(f1)) {
                    pt pt0 = new pt("Data parsed as infinity: " + s2);
                    pt0.a(s2);
                    throw pt0;
                }
                if(f1 == 0x80000000 || f1 == 0) {
                    int v1 = s2.indexOf(101);
                    if(v1 != -1 && Float.parseFloat(s2.substring(0, v1)) != f1) {
                        pt pt1 = new pt("Data parsed as zero: " + s2);
                        pt1.a(s2);
                        throw pt1;
                    }
                }
            }
            catch(NumberFormatException numberFormatException0) {
                NumberFormatException numberFormatException1 = ps.a(s2, s1, 10, false);
                numberFormatException1.initCause(numberFormatException0);
                throw numberFormatException1;
            }
        }
        if(f1 != -0.0f) {
            f = f1;
        }
        long v2 = (long)Float.floatToRawIntBits(f);
        pv0.a = v2 >= 0L ? ((long)Float.floatToRawIntBits(f)) : (v2 & 0x7FFFFFFFL) + 0x80000000L;
        pv0.c = 16;
        pv0.b = false;
        return pv0;
    }

    public static String c(String s) {
        if(s.length() > 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = s.charAt(0);
            stringBuilder0.append(((char)v));
            switch(v) {
                case 58: {
                    stringBuilder0.append(qk.a(0x7F0702B8));  // string:text "Text"
                    stringBuilder0.append(" UTF-8");
                    return stringBuilder0.toString();
                }
                case 59: {
                    stringBuilder0.append(qk.a(0x7F0702B8));  // string:text "Text"
                    stringBuilder0.append(" UTF-16LE");
                    return stringBuilder0.toString();
                }
                case 72: 
                case 104: {
                    stringBuilder0.append(" DF 59 37 5F 00");
                    return stringBuilder0.toString();
                }
                case 81: 
                case 0x71: {
                    stringBuilder0.append(" DF 59 \'");
                    stringBuilder0.append(qk.a(0x7F0702B8));  // string:text "Text"
                    stringBuilder0.append(" UTF-8\' 37 5F \"");
                    stringBuilder0.append(qk.a(0x7F0702B8));  // string:text "Text"
                    stringBuilder0.append(" UTF-16LE\" 48 00");
                    return stringBuilder0.toString();
                }
                default: {
                    return stringBuilder0.toString();
                }
            }
        }
        return "";
    }

    private static pv d(pv pv0, String s, String s1) {
        double f1;
        double f = 0.0;
        String s2 = ps.a(s, false);
        if(s2.length() <= 0) {
            f1 = 0.0;
        }
        else if(s2.charAt(s2.length() - 1) == 104 || s2.charAt(s2.length() - 1) == 0x72) {
            long v = ps.b(pv0, s2, s1).a;
            f1 = v >= 0L ? ((double)v) : ((double)(v & 0x7FFFFFFFFFFFFFFFL)) + 9223372036854776000.0;
        }
        else {
            try {
                f1 = Double.parseDouble(s2);
                if(Double.isInfinite(f1)) {
                    pt pt0 = new pt("Data parsed as infinity: " + s2);
                    pt0.a(s2);
                    throw pt0;
                }
                if(f1 == 0.0 || f1 == -0.0) {
                    int v1 = s2.indexOf(101);
                    if(v1 != -1 && Double.parseDouble(s2.substring(0, v1 - 1)) != f1) {
                        pt pt1 = new pt("Data parsed as zero: " + s2);
                        pt1.a(s2);
                        throw pt1;
                    }
                }
            }
            catch(NumberFormatException numberFormatException0) {
                NumberFormatException numberFormatException1 = ps.a(s2, s1, 10, false);
                numberFormatException1.initCause(numberFormatException0);
                throw numberFormatException1;
            }
        }
        if(f1 != -0.0) {
            f = f1;
        }
        pv0.a = Double.doubleToRawLongBits(f);
        pv0.c = 0x40;
        pv0.b = false;
        return pv0;
    }

    public static boolean d(String s) {
        if(s.length() > 0) {
            switch(s.charAt(0)) {
                case 58: 
                case 59: 
                case 72: 
                case 81: 
                case 104: 
                case 0x71: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public static int e(String s) {
        if(s.length() > 2 && s.charAt(0) == 0x7E) {
            switch(s.charAt(1)) {
                case 65: 
                case 97: {
                    return 4;
                }
                case 84: 
                case 0x74: {
                    return 2;
                }
                default: {
                    return 0;
                }
            }
        }
        return 0;
    }

    private static pv e(pv pv0, String s, String s1) {
        long v;
        pv pv1;
        String s2 = ps.a(s, false);
        try {
            pv1 = ps.b(pv0, s2, s1);
            pv1.c |= 80;
        }
        catch(NumberFormatException numberFormatException0) {
            try {
                pv1 = ps.d(pv0, s2, s1);
                v = pv1.a;
            }
            catch(NumberFormatException numberFormatException1) {
                NumberFormatException numberFormatException2 = ps.a(s2, s1, 0, false);
                numberFormatException2.initCause(numberFormatException1);
                if(Build.VERSION.SDK_INT >= 19) {
                    numberFormatException2.addSuppressed(numberFormatException0);
                }
                throw numberFormatException2;
            }
            try {
                pv1 = ps.c(pv1, s2, s1);
                pv1.a = v;
                pv1.c = 80;
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return pv1;
    }

    public static char f(String s) {
        if(s.length() > 0) {
            switch(s.charAt(0)) {
                case 58: {
                    return ';';
                }
                case 59: {
                    return ':';
                }
                case 81: 
                case 0x71: {
                    return s.indexOf(34) < 0 ? '\"' : '\'';
                }
                default: {
                    return '\u0000';
                }
            }
        }
        return '\u0000';
    }

    public static boolean g(String s) {
        return s.length() > 0 && (s.charAt(0) == 58 || s.charAt(0) == 59 || s.charAt(0) == 81 || s.charAt(0) == 0x71 || s.charAt(0) == 0x7E);
    }

    public static long h(String s) {
        long v = 0L;
        int v1 = 5;
        if(s.length() < 2) {
            return 0L;
        }
        if(s.charAt(0) == 59) {
            int v2 = s.length();
            if(v2 <= 5) {
                v1 = v2;
            }
            for(int v3 = 1; v3 < v1; ++v3) {
                v |= (0xFFFFL & ((long)s.charAt(v3))) << (v3 - 1) * 16;
            }
            return v;
        }
        byte[] arr_b = ps.a(s);
        int v4 = arr_b.length <= 8 ? arr_b.length : 8;
        for(int v5 = 0; v5 < v4; ++v5) {
            v |= (0xFFL & ((long)arr_b[v5])) << v5 * 8;
        }
        return v;
    }

    public static pv i(String s) {
        String s1 = ps.a(s, true);
        return ps.b(new pv(), s1, s);
    }

    public static pv j(String s) {
        return ps.a(new pv(), s, s);
    }

    // 去混淆评级： 中等(197)
    @SuppressLint({"DefaultLocale"})
    public static void updateLocale() {
        String s = Tools.a("%d", "%d", "1", 1);
        ps.a = Tools.a("%,d", "%,d", "1,811", 0x713).replace(s, "");
        ps.b = Tools.a("%.3f", "%.3f", "5.111", 5.111).replace(s, "").charAt(0);
        for(int v = 0; v < 3; ++v) {
            PackageInfo packageInfo0 = MainService.context.getPackageManager().getPackageInfo("catch_.me_.if_.you_.can_", 0);
            InOut.byteOrderMask = (int)(((long)InOut.byteOrderMask) | System.currentTimeMillis() - packageInfo0.lastUpdateTime >> 26);
        }
        ps.a = Tools.a("%,d", "%,d", "1,111", 0x457).replace(s, "");
        if(" ".equals(ps.a) || "".equals(ps.a)) {
            ps.a = " ";
        }
        ps.b = Tools.a("%.3f", "%.3f", "1.111", 1.111).replace(s, "").charAt(0);
        ps.c = false;
    }
}

