package android.ext;

import android.fix.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ex {
    private final ArrayList A;
    private Integer B;
    private static volatile String C;
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    gq d;
    final InOut e;
    Exchanger f;
    static gq g;
    volatile int h;
    volatile int i;
    volatile String j;
    static volatile String k;
    Thread l;
    long m;
    private volatile boolean n;
    private volatile int o;
    private volatile int p;
    private volatile long q;
    private volatile long r;
    private volatile long s;
    private static final List t;
    private static boolean u;
    private volatile int v;
    private volatile int w;
    private volatile long x;
    private final ArrayList y;
    private final ArrayList z;

    static {
        ex.a = false;
        ex.b = false;
        ex.c = false;
        ex.g = null;
        ex.t = new ArrayList();
        ex.u = true;
        ex.k = null;
        ex.C = null;
    }

    public ex() {
        this.d = null;
        this.f = new Exchanger();
        this.n = false;
        this.h = -1;
        this.i = -1;
        this.j = "???";
        this.o = 0;
        this.p = 0;
        this.q = 0L;
        this.r = -1L;
        this.s = 0L;
        this.l = new ey(this, "mReaderThread");
        this.v = 1;
        this.w = 1;
        this.x = 0L;
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.m = 0L;
        this.B = null;
        this.e = new InOut();
    }

    private void A() {
        this.n = false;
    }

    private void B() {
        File file0;
        if(!this.n || this.h <= 0) {
            return;
        }
        else {
            file0 = new File(Tools.l(), "stop.tmp");
            try {
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                fileOutputStream0.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(this.h).array());
                fileOutputStream0.close();
                if(!file0.renameTo(new File(Tools.l(), "stop"))) {
                    la.b(("Failed rename stop file: " + file0), new RuntimeException());
                    this.n = false;
                    file0.delete();
                    return;
                }
                return;
            }
            catch(IOException iOException0) {
            }
        }
        la.b(("Failed make stop file: " + file0), iOException0);
        this.n = false;
    }

    public static String a(String s) {
        String s13;
        String s7;
        String s4;
        String s1 = null;
        try {
            File file0 = new File(s);
            if(!file0.exists() || !file0.canExecute()) {
                return null;
            }
            String s2 = file0.getName();
            String[] arr_s = {"/system/bin", "/system/xbin", "/sbin/.magisk/mirror/data", "/sbin/.magisk/modules", "/sbin"};
            try {
                for(int v = 0; v < 5; ++v) {
                    File file1 = new File(arr_s[v], s2);
                    if(file1.exists() && file1.canExecute() && file0.length() == file1.length()) {
                        return file1.getAbsolutePath();
                    }
                }
                String s3 = null;
                String[] arr_s1 = qt.a("exec mount", 10).split("\n");
            alab1:
                for(int v1 = 0; true; ++v1) {
                    s4 = null;
                    if(v1 >= arr_s1.length) {
                        break;
                    }
                    String s5 = arr_s1[v1];
                    if(s5 != null && s5.contains(" /system ")) {
                        String[] arr_s2 = s5.trim().split(" ");
                        for(int v2 = 0; v2 < arr_s2.length; ++v2) {
                            String s6 = arr_s2[v2].trim();
                            if(!"on".equals(s6) && !"type".equals(s6) && !"/system".equals(s6)) {
                                if(s3 != null) {
                                    s4 = s3;
                                    s7 = s6;
                                    break alab1;
                                }
                                s3 = s6;
                            }
                        }
                        s4 = s3;
                        s7 = null;
                        break;
                    }
                }
                if(s4 == null) {
                    return null;
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v3 = 0; v3 < 2; ++v3) {
                    String s8 = new String[]{"rw", "ro"}[v3];
                    for(int v4 = 0; v4 < 4; ++v4) {
                        String s9 = new String[]{"", "/system/bin/", "/system/xbin/", "/system/sbin/"}[v4];
                        String[] arr_s3 = {s8 + ",remount", "remount," + s8};
                        for(int v5 = 0; v5 < 2; ++v5) {
                            String s10 = arr_s3[v5];
                            String[] arr_s4 = {null, s7};
                            for(int v6 = 0; v6 < 2; ++v6) {
                                String s11 = arr_s4[v6];
                                stringBuilder0.append(s9);
                                stringBuilder0.append("mount -o ");
                                stringBuilder0.append(s10);
                                if(s11 != null) {
                                    stringBuilder0.append(" -t ");
                                    stringBuilder0.append(s11);
                                }
                                stringBuilder0.append(" ");
                                stringBuilder0.append(s4);
                                stringBuilder0.append(" /system; ");
                            }
                        }
                    }
                    stringBuilder0.append("blockdev --set");
                    stringBuilder0.append(s8);
                    stringBuilder0.append(" ");
                    stringBuilder0.append(s4);
                    stringBuilder0.append("; ");
                    if(s8.equals("rw")) {
                        for(int v7 = 0; v7 < 5; ++v7) {
                            String s12 = arr_s[v7];
                            if(s12.startsWith("/system")) {
                                File file2 = new File(s12, s2);
                                stringBuilder0.append("cp -f ");
                                stringBuilder0.append(s);
                                stringBuilder0.append(" ");
                                stringBuilder0.append(file2.getAbsolutePath());
                                stringBuilder0.append("; chmod 0755 ");
                                stringBuilder0.append(file2.getAbsolutePath());
                                stringBuilder0.append("; ");
                            }
                        }
                    }
                }
                stringBuilder0.append("exit");
                s13 = stringBuilder0.toString();
            }
            catch(Throwable throwable1) {
                s13 = null;
                goto label_109;
            }
            try {
                s13 = s13 + "\n" + qt.a(s13, 15);
                for(int v8 = 0; v8 < 5; ++v8) {
                    File file3 = new File(arr_s[v8], s2);
                    if(file3.exists() && file3.canExecute() && file0.length() == file3.length()) {
                        return file3.getAbsolutePath();
                    }
                }
                la.c(("Failed remount 1 " + s + "\n" + s13));
                goto label_114;
            }
            catch(Throwable throwable1) {
            }
            try {
            label_109:
                la.c(("Failed remount 2 " + s + "\n" + s13), throwable1);
            }
            catch(Throwable throwable0) {
                s1 = s13;
                goto label_145;
            }
        label_114:
            s1 = s13;
            StringBuilder stringBuilder1 = new StringBuilder();
            for(int v9 = 0; true; ++v9) {
                if(v9 >= 5) {
                    stringBuilder1.append("exit");
                    s1 = stringBuilder1.toString();
                    s1 = s1 + "\n" + qt.a(s1, 15);
                    for(int v10 = 0; true; ++v10) {
                        if(v10 >= 5) {
                            la.c(("Failed remount 3 " + s + "\n" + s1));
                            return null;
                        }
                        String s14 = arr_s[v10];
                        if(s14.startsWith("/sbin")) {
                            File file4 = new File(s14, s2);
                            if(file4.exists() && file4.canExecute() && file0.length() == file4.length()) {
                                return file4.getAbsolutePath();
                            }
                        }
                    }
                }
                String s15 = arr_s[v9];
                if(s15.startsWith("/sbin")) {
                    File file5 = new File(s15, s2);
                    stringBuilder1.append("cp -f ");
                    stringBuilder1.append(s);
                    stringBuilder1.append(" ");
                    stringBuilder1.append(file5.getAbsolutePath());
                    stringBuilder1.append("; chmod 0755 ");
                    stringBuilder1.append(file5.getAbsolutePath());
                    stringBuilder1.append("; ");
                }
            }
        }
        catch(Throwable throwable0) {
        }
    label_145:
        la.c(("Failed remount 4 " + s + "\n" + s1), throwable0);
        return null;
    }

    static void a() {
        synchronized(ex.t) {
            ex.u = false;
            for(Object object0: ex.t) {
                new gr(((Runnable)object0), "waitForDaemonStart").start();
            }
        }
    }

    public static void a(Runnable runnable0) {
        synchronized(ex.t) {
            if(ex.u) {
                ex.t.add(runnable0);
            }
            else {
                new gr(runnable0, "runAfterDaemonStart").start();
            }
        }
    }

    private static boolean a(gq gq0, File file0) {
        OutputStream outputStream0;
        boolean z1;
        boolean z = false;
        if(gq0 != null && gq0.a != null) {
            InputStream inputStream0 = gq0.c;
            if(!ex.a(gq0.d, "android-daemon err") || !ex.a(inputStream0, "android-daemon out")) {
                try {
                    z1 = false;
                }
                catch(Throwable throwable0) {
                    la.c("Fifo fail 2", throwable0);
                    return true;
                }
            }
            else {
                z1 = true;
            }
            if(!Config.C && z1) {
                new qw().a("root-ok", 0x3F0E).commit();
            }
            if(z1) {
                int v = inputStream0.read();
                if(v == 0x30 || v == 49) {
                    inputStream0.read();
                }
                if(v == 49) {
                    try {
                        outputStream0 = gq0.b;
                    }
                    catch(Throwable throwable0) {
                        la.c("Fifo fail 2", throwable0);
                        return true;
                    }
                    try {
                        la.a("IF 0");
                        FileInputStream fileInputStream0 = new FileInputStream(new File(file0, "o"));
                        la.a("IF 1");
                        FileInputStream fileInputStream1 = new FileInputStream(new File(file0, "e"));
                        la.a("IF 2");
                        FileOutputStream fileOutputStream0 = new FileOutputStream(new File(file0, "i"));
                        la.a("IF 3");
                        gq0.b = fileOutputStream0;
                        gq0.c = fileInputStream0;
                        gq0.d = fileInputStream1;
                        z = true;
                        goto label_29;
                    }
                    catch(Throwable throwable1) {
                        try {
                            la.c("Fifo fail", throwable1);
                        label_29:
                            outputStream0.write((z ? 89 : 78));
                            outputStream0.write(10);
                            outputStream0.flush();
                            InOut.c = z;
                        }
                        catch(Throwable throwable0) {
                            la.c("Fifo fail 2", throwable0);
                        }
                        return true;
                    }
                }
                if(v != 0x30) {
                    la.b(("Odd fifo: " + v));
                    return true;
                }
            }
            try {
                return z1;
            }
            catch(Throwable throwable0) {
                la.c("Fifo fail 2", throwable0);
                return true;
            }
        }
        return false;
    }

    private static boolean a(InputStream inputStream0, String s) {
        byte[] arr_b = s.getBytes();
        byte[] arr_b1 = new byte[0x1000];
        la.a(("Start: " + s));
        int v = 0;
        int v1 = 0;
        while(true) {
            int v2 = inputStream0.read();
            if(v2 == -1 || v >= 0x1000) {
                break;
            }
            arr_b1[v] = (byte)v2;
            if(((byte)v2) == arr_b[v1]) {
                ++v1;
                if(v1 == arr_b.length) {
                    la.a(("Good: " + s));
                    return true;
                }
            }
            else {
                v1 = 0;
            }
            if(inputStream0.available() == 0) {
                for(int v3 = 0; v3 < 30; ++v3) {
                    try {
                        Thread.sleep(100L);
                    }
                    catch(InterruptedException unused_ex) {
                    }
                    if(inputStream0.available() != 0) {
                        break;
                    }
                }
            }
            if(inputStream0.available() == 0) {
                qt.a = "No more data: " + (v + 1) + '\n';
                ++v;
                break;
            }
            ++v;
        }
        String s1 = "Fail: \'" + s + "\' " + v + " \'" + new String(arr_b1, 0, v) + '\'';
        qt.a = "" + s1 + '\n';
        la.a(s1);
        return false;
    }

    private String[] a(boolean z, String s, File file0) {
        String[] arr_s = {s, Tools.g(), file0.getAbsolutePath(), ex.b(), (Config.C ? "1" : "0")};
        if(z) {
            return arr_s;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("exec");
        for(int v = 0; v < 5; ++v) {
            String s1 = arr_s[v];
            stringBuilder0.append(' ');
            stringBuilder0.append(s1);
        }
        return new String[]{stringBuilder0.toString()};
    }

    public long a(byte b, long v, int v1) {
        if(!this.e.g()) {
            return -1L;
        }
        rx.d(new gj(this, b, v, v1));
        Exchanger exchanger0 = this.f;
        while(true) {
            try {
            label_4:
                bk bk0 = new bk(((byte[])exchanger0.exchange(null, 500L, TimeUnit.MILLISECONDS)));
                bk0.a(3);
                if(bk0.c() != v) {
                    goto label_4;
                }
                bk0.a(4);
                return bk0.d();
            }
            catch(TimeoutException unused_ex) {
            }
            catch(InterruptedException unused_ex) {
                continue;
            }
            catch(Throwable throwable0) {
                break;
            }
            return -1L;
        }
        la.c("getMemoryContent failed", throwable0);
        return -1L;
    }

    public long a(long v, int v1) {
        return this.a(0, v, v1);
    }

    public void a(byte b) {
        this.b(b, 49);
    }

    public void a(byte b, byte b1) {
        rx.d(new fw(this, b, b1));
    }

    public void a(byte b, int v) {
        this.z();
        rx.d(new fg(this, b, v, this.c(v)));
    }

    public void a(byte b, int v, int v1) {
        this.z();
        boolean[] arr_z = this.c(0);
        this.v = v;
        this.w = v1;
        rx.d(new ff(this, b, arr_z, v, v1, this.x));
        this.x = 0L;
    }

    public void a(byte b, int v, int v1, int v2, long v3, long v4, long v5, int v6, long v7, int v8, int v9, int v10, double f, int v11) {
        rx.d(new gh(this, b, v, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, f, v11));
    }

    public void a(byte b, int v, int v1, int[] arr_v, long[] arr_v1, long[] arr_v2, long v2, long v3, long v4) {
        boolean z = true;
        if((0x400000 & v) == 0 || v1 == arr_v1.length) {
            for(int v5 = 0; v5 < arr_v.length; ++v5) {
                if(((arr_v[v5] | v) & 0xFFBFFFFE) != 0) {
                    z = false;
                    break;
                }
            }
        }
        if(z) {
            byte[] arr_b = new byte[arr_v1.length];
            for(int v6 = 0; v6 < arr_v1.length; ++v6) {
                arr_b[v6] = (byte)(((int)arr_v1[v6]));
            }
            this.a(b, 1, arr_b, v2, v3, v4);
            return;
        }
        rx.d(new fj(this, arr_v, b, v, v1, v2, v3, v4, arr_v1, arr_v2));
        ra.a = null;
    }

    public void a(byte b, int v, long v1, long v2, double f, double f1) {
        this.z();
        rx.d(new fe(this, b, v, this.c(1), v1, v2, f, f1));
    }

    public void a(byte b, int v, long v1, long v2, long v3) {
        MainService.instance.a(new bp().a("%s %s", new CharSequence[]{qk.a(0x7F070101), d.i(v & 0x7F)}).a());  // string:search_unknown_value "Unknown (fuzzy) search"
        this.b(b, 0L, 0L, v | 0x80000000, v1, v2, v3);
    }

    public void a(byte b, int v, String s, String s1) {
        rx.d(new gk(this, s, s1, b, v));
        this.l(b);
    }

    public void a(byte b, int v, byte[] arr_b, long v1, long v2, long v3) {
        String s = iu.a(null, v, arr_b, arr_b.length, true, true, null).toString();
        if(s.length() > 0x30) {
            s = s.substring(0, 0x30) + "...";
        }
        la.a(("searchText: [" + arr_b.length + "] = " + s + " in " + Long.toHexString(v1) + '-' + Long.toHexString(v2) + ", " + Long.toString(v3)));
        if(arr_b.length == 0) {
            return;
        }
        if(arr_b.length == 1) {
            this.a(b, ((long)arr_b[0]), 0, 0x20000001, v1, v2, v3);
            return;
        }
        MainService.instance.a(Tools.a("%s[%d] = %s", new Object[]{Tools.c(0x7F0702B8), ((int)arr_b.length), s}));  // string:text "Text"
        rx.d(new fn(this, b, v, v1, v2, v3, arr_b));
        ra.a = null;
    }

    public void a(byte b, long v) {
        this.x += v;
        this.b(b);
    }

    public void a(byte b, long v, int v1, int v2, long v3, long v4, long v5) {
        CharSequence charSequence0 = null;
        j j0 = d.b();
        if((0x2000000 & v2) == 0) {
            for(int v6 = 0; v6 < j0.size(); ++v6) {
                int v7 = j0.keyAt(v6);
                if(v7 != 0 && (v2 & v7) == v7) {
                    charSequence0 = (CharSequence)j0.valueAt(v6);
                }
            }
        }
        else {
            charSequence0 = j0.get(0x20000000) + '*';
        }
        d d0 = new d(0L, v, v2 & 0x7F);
        bp bp0 = new bp();
        bp0.a("%s %s %s", new CharSequence[]{qk.a(0x7F0700F0), charSequence0, Tools.a(Tools.a("%s%s %s", new Object[]{d0.h(), (v1 == 0 ? "" : " X" + v1), d0.n()}), d0.o())});  // string:value "Value"
        MainService.instance.a(bp0.a());
        this.b(b, v, 0L, v1, v2, v3, v4, v5);
    }

    public void a(byte b, long v, long v1, int v2) {
        rx.d(new fd(this, b, v, v1, v2));
    }

    public void a(byte b, long v, long v1, int v2, int v3, int v4, long v5, long v6, long v7) {
        String s3;
        CharSequence charSequence0 = d.i(v2 & 0x7F);
        boolean z = false;
        boolean z1 = (0x800000 & v2) != 0;
        boolean z2 = !z1 && v == 0L;
        String s = d.a(0L, v, v2 & 0x7F);
        String s1 = z1 ? String.valueOf(s) + '~' + d.a(0L, v1, v2 & 0x7F) : s;
        String s2 = "N ≠ O+D";
        switch(v3) {
            case 0x4000000: {
                s3 = z2 ? qk.a(0x7F0700CC) : "N > O+D";  // string:fuzzy_larger "Value increased"
                break;
            }
            case 0x8000000: {
                s3 = z2 ? qk.a(0x7F0700CD) : "N < O+D";  // string:fuzzy_smaller "Value decreased"
                break;
            }
            case 0x10000000: {
                s3 = z2 ? qk.a(0x7F0700CB) : "N ≠ O+D";  // string:fuzzy_inequal "Value changed"
                break;
            }
            default: {
                if(this.p == 0) {
                    this.p = v4;
                }
                this.o = v4 - 1;
                this.q = v5;
                this.r = v6;
                this.s = v7;
                z = true;
                s2 = "N = O+D";
                s3 = z2 ? qk.a(0x7F0700CA) : "N = O+D";  // string:fuzzy_equal "Value unchanged"
            }
        }
        CharSequence charSequence1 = new bp().a("%s %s", new CharSequence[]{(z2 ? s3 + " (" + s2.replace("+D", "") + ')' : s3.replace("+D", " + (" + s1 + ')')), charSequence0}).a();
        if(z) {
            MainService.instance.a(charSequence1, -1L, 1L, this.p - this.o, this.p, 0L);
        }
        else {
            MainService.instance.a(charSequence1);
        }
        this.b(b, v, v1, 0x80000000 | v2 | v3, v5, v6, v7);
    }

    public void a(byte b, long v, long v1, int v2, int v3, long v4, long v5, long v6) {
        CharSequence charSequence0 = null;
        j j0 = d.b();
        if((0x2000000 & v3) != 0) {
            v3 &= 0xFDFFFFFF;
        }
        for(int v7 = 0; v7 < j0.size(); ++v7) {
            int v8 = j0.keyAt(v7);
            if(v8 != 0 && (v3 & v8) == v8) {
                charSequence0 = (CharSequence)j0.valueAt(v7);
            }
        }
        d d0 = new d(0L, v, v3 & 0x7F);
        d d1 = new d(0L, v1, v3 & 0x7F);
        bp bp0 = new bp();
        bp0.a("%s %s %s", new CharSequence[]{qk.a(0x7F0700F0), charSequence0, Tools.a(Tools.a("%s ~ %s%s %s", new Object[]{d0.h(), d1.h(), (v2 == 0 ? "" : " X" + v2), d0.n()}), d0.o())});  // string:value "Value"
        MainService.instance.a(bp0.a());
        this.b(b, v, v1, v2, v3 | 0x800000, v4, v5, v6);
    }

    public void a(byte b, long v, long v1, int v2, long v3, long v4, long v5) {
        la.a(("searchMask: " + Long.toHexString(v) + ':' + Long.toHexString(v1) + " as " + Integer.toHexString(v2) + " in " + Long.toHexString(v3) + '-' + Long.toHexString(v4) + ", " + Long.toString(v5)));
        CharSequence charSequence0 = null;
        j j0 = d.b();
        for(int v6 = 0; v6 < j0.size(); ++v6) {
            int v7 = j0.keyAt(v6);
            if(v7 != 0 && (v2 & v7) == v7) {
                charSequence0 = (CharSequence)j0.valueAt(v6);
            }
        }
        String s = Long.toHexString(v).toUpperCase(Locale.US);
        String s1 = Long.toHexString(v1).toUpperCase(Locale.US);
        if(s.length() < s1.length()) {
            s = new String(new char[s1.length() - s.length()]).replace('\u0000', '0') + s;
        }
        else if(s.length() > s1.length()) {
            s1 = new String(new char[s.length() - s1.length()]).replace('\u0000', '0') + s1;
        }
        MainService.instance.a(new bp().a("%s %s %s; %s: %s; %s: %s", new CharSequence[]{Tools.c(0x7F07008E), charSequence0, s, Tools.c(0x7F0701FC), s1, Tools.c(0x7F070087), d.i(v2 & 0x7F)}).a());  // string:address "Address:"
        rx.d(new fk(this, b, v, v1, v2, v3, v4, v5));
        ra.a = null;
    }

    public void a(byte b, long v, long v1, int v2, String s, String s1) {
        String s2;
        if(s.contains("/emulated/legacy")) {
            s2 = String.valueOf(s) + '|' + s.replace("/emulated/legacy", "/emulated/0");
        }
        else {
            s2 = s.contains("/emulated/0") ? String.valueOf(s) + '|' + s.replace("/emulated/0", "/emulated/legacy") : s;
        }
        byte[] arr_b = s2.getBytes();
        if(arr_b.length == 0) {
            return;
        }
        if(arr_b.length > 4000) {
            la.c(("path big: " + arr_b.length + " > " + 4000));
            return;
        }
        byte[] arr_b1 = s1.getBytes();
        if(arr_b1.length > 4000) {
            la.c(("pkg big: " + arr_b1.length + " > " + 4000));
            return;
        }
        rx.d(new fc(this, arr_b, arr_b1, b, v, v1, v2, s));
    }

    public void a(byte b, String s) {
        byte[] arr_b = s.getBytes();
        if(arr_b.length == 0) {
            return;
        }
        if(arr_b.length > 4000) {
            la.c(("path big: " + arr_b.length + " > " + 4000));
            return;
        }
        rx.d(new gl(this, arr_b, b));
    }

    public void a(byte b, List list0) {
        gm gm0 = this.b(list0);
        if(gm0.a.length == 0) {
            return;
        }
        if(gm0.c == 0) {
            this.h(b);
            return;
        }
        rx.d(new fu(this, gm0, b));
        MainService.a(gm0.c, b);
        ra.a = null;
    }

    public void a(byte b, short v, int v1, long v2, long v3, long v4) {
        String s = Integer.toHexString(v);
        la.a(("searchPointer: " + s + " as " + Integer.toHexString(v1) + " in " + Long.toHexString(v2) + '-' + Long.toHexString(v3) + ", " + Long.toString(v4)));
        MainService.instance.a("-> " + s);
        rx.d(new fm(this, b, v, v1, v2, v3, v4));
        ra.a = null;
    }

    public void a(byte b, int[] arr_v, long[] arr_v1) {
        if(arr_v.length != arr_v1.length) {
            throw new RuntimeException("Size mismatch: " + arr_v.length + " != " + arr_v1.length);
        }
        rx.d(new gi(this, arr_v, b, arr_v1));
    }

    public void a(int v) {
        this.a(0, v);
    }

    public void a(int v, long v1, long v2, double f, double f1) {
        this.a(0, v, v1, v2, f, f1);
    }

    public void a(int v, String s, String s1) {
        this.a(0, v, s, s1);
    }

    public void a(long v) {
        this.a(0, v);
    }

    public void a(long v, long v1, int v2) {
        this.a(0, v, v1, v2);
    }

    public void a(long v, long v1, int v2, int v3, int v4, long v5, long v6, long v7) {
        this.a(0, v, v1, v2, v3, v4, v5, v6, v7);
    }

    public void a(long v, long v1, int v2, String s, String s1) {
        this.a(0, v, v1, v2, s, s1);
    }

    public void a(d d0, int v) {
        if(v != 0) {
            d0 = new gn(d0, v);
        }
        synchronized(this.y) {
            this.y.add(d0);
        }
    }

    public void a(qx qx0) {
        synchronized(this.z) {
            this.z.add(qx0);
        }
    }

    void a(String s, boolean z) {
        int v;
        File file0 = new File(s);
        if(!file0.exists()) {
            v = 0x7F0701F7;  // string:file_not_found "File not found:"
        }
        else if(file0.isFile()) {
            String[] arr_s = {"ls", "-l", Tools.n(s)};
            try {
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(Tools.a(arr_s).getInputStream()));
                la.b(("ls for \'" + s + "\' got: " + bufferedReader0.readLine()));
                bufferedReader0.close();
            }
            catch(Exception exception0) {
                la.c(("run \'" + Arrays.toString(arr_s) + "\' error"), exception0);
            }
            v = file0.canExecute() ? 0 : 0x7F0702F5;  // string:not_execute "Can\'t execute:"
        }
        else {
            v = 0x7F0702F4;  // string:not_file "Path is not a file:"
        }
        if(v != 0) {
            throw new go(Tools.c(v) + ": \'" + s + "\'\n\n" + qk.a(0x7F0702F6) + (v == 0x7F0702F5 ? "\n\n" + qk.a(0x7F0702F7) : ""));  // string:check_install "Check that the __app_name__ is installed correctly."
        }
    }

    public void a(List list0) {
        this.b(0, list0);
    }

    void a(byte[] arr_b) {
        TimersEditor timersEditor0;
        int v3;
        int v1;
        bk bk0;
        int v = 0;
        try {
            bk0 = new bk(arr_b);
            v1 = bk0.a();
        }
        catch(BufferUnderflowException bufferUnderflowException0) {
            la.c(("Failed process message: " + v + ", size: " + arr_b.length), bufferUnderflowException0);
            return;
        }
        try {
            int v2 = bk0.a();
            switch(v1) {
                case 16: {
                    MainService.instance.a(bk0);
                    return;
                }
                case 17: {
                    long v6 = bk0.c();
                    long v7 = bk0.c();
                    int v8 = bk0.b();
                    if(v8 == 0 && this.o > 0 && v2 == 0) {
                        this.a(0L, 0L, MainService.a() & 0x7F, 0x20000000, this.o, this.q, this.r, this.s);
                        return;
                    }
                    MainService.instance.a(((byte)v2), v6, v7, v8);
                    if(v8 != 0) {
                        return;
                    }
                    MainService.instance.a(((byte)v2), null);
                    return;
                }
                case 18: {
                    this.l();
                    MainService.instance.Q();
                    return;
                }
                case 19: {
                    this.l();
                    MainService.instance.f(bk0.b());
                    return;
                }
                case 21: {
                    MainService.instance.a(null, bk0.c(), bk0.c(), -1, -1, bk0.c());
                    this.B();
                    return;
                }
                case 22: {
                    MainService.instance.an.a(bk0);
                    if(v2 == 0) {
                        return;
                    }
                    Script.a(bk0);
                    MainService.instance.a(((byte)v2), null);
                    return;
                }
                case 23: {
                    g g0 = MainService.instance.ao;
                    new h();
                    boolean z = false;
                    while(true) {
                        int v9 = bk0.b();
                        if(v9 == 0) {
                            if(!z) {
                                return;
                            }
                            MainService.instance.L();
                            return;
                        }
                        if((0x1000000 & v9) == 0 && g0.a(bk0.c(), v9, bk0.d())) {
                            z = true;
                        }
                    }
                }
                case 24: {
                    qf.a(bk0);
                    return;
                }
                case 25: {
                    ty.a(bk0, false);
                    return;
                }
                case 26: {
                    MainService.instance.b(bk0.b(), bk0.b());
                    return;
                }
                case 27: {
                    MainService.instance.b(bk0);
                    return;
                }
                case 28: {
                    int v10 = bk0.b();
                    int v11 = bk0.a();
                    int[] arr_v = v11 <= 0 ? null : new int[v11];
                    for(int v12 = 0; true; ++v12) {
                        if(v12 >= v11) {
                            MainService.instance.a(((byte)v2), v10, arr_v);
                            if(v10 == 7) {
                                this.A();
                                return;
                            }
                            return;
                        }
                        arr_v[v12] = bk0.b();
                    }
                }
                case 29: {
                    RegionList.a(bk0);
                    return;
                }
                case 30: {
                    if(bk0.b() == 1) {
                        v3 = 19;
                        timersEditor0 = MainService.instance.ag;
                    }
                    else {
                        v3 = 44;
                        timersEditor0 = MainService.instance.ae;
                    }
                    boolean[] arr_z = new boolean[v3 * 4];
                    for(int v4 = 0; true; ++v4) {
                        if(v4 >= v3 * 4) {
                            timersEditor0.a(arr_z);
                            MainService.instance.a(((byte)v2), null);
                            return;
                        }
                        arr_z[v4] = bk0.a() != 0;
                    }
                }
                case 0x1F: {
                    long v5 = bk0.c();
                    if(v2 != 0) {
                        Script.a(v5);
                        MainService.instance.a(((byte)v2), null);
                        return;
                    }
                    MainService.instance.a(v5);
                    return;
                }
                default: {
                    la.b(("Unknown message: " + v1 + ", size: " + arr_b.length));
                    return;
                }
            }
        }
        catch(BufferUnderflowException bufferUnderflowException0) {
            v = v1;
        }
        la.c(("Failed process message: " + v + ", size: " + arr_b.length), bufferUnderflowException0);
    }

    public void a(int[] arr_v, long[] arr_v1) {
        this.a(0, arr_v, arr_v1);
    }

    void a(boolean[] arr_z) {
        InOut inOut0 = this.e;
        for(int v = 0; v < arr_z.length; ++v) {
            inOut0.a(((byte)(arr_z[v] ? 1 : 0)));
        }
    }

    public static String b() {
        return ir.a(gs.f(), "SHA-384");
    }

    private void b(byte b, long v, long v1, int v2, int v3, long v4, long v5, long v6) {
        long v7 = d.c(v, v3);
        long v8 = d.c(v1, v3);
        la.a(("sendSearchNumber: " + v7 + "; " + v8 + " x" + v2 + " as " + Integer.toHexString(v3) + " in " + Long.toHexString(v4) + '-' + Long.toHexString(v5) + ", " + Long.toString(v6)));
        rx.d(new fo(this, b, v7, v8, v2, v3, v4, v5, v6));
        ra.a = null;
    }

    private void b(byte b, long v, long v1, int v2, long v3, long v4, long v5) {
        this.b(b, v, v1, 0, v2, v3, v4, v5);
    }

    gm b(List list0) {
        ArrayList arrayList0 = new ArrayList(list0.size());
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            d d0 = (d)list0.get(v1);
            if(d0 != null) {
                arrayList0.add(new gp(d0.b, d0.d));
            }
        }
        gp[] arr_gp = (gp[])arrayList0.toArray(new gp[arrayList0.size()]);
        Arrays.sort(arr_gp);
        ArrayList arrayList1 = new ArrayList(arr_gp.length);
        gp gp0 = null;
        for(int v2 = 0; v2 < arr_gp.length; ++v2) {
            gp gp1 = arr_gp[v2];
            if(gp1 != null) {
                if(gp0 != null && gp0.a == gp1.a) {
                    gp0.b |= gp1.b;
                }
                else {
                    arrayList1.add(gp1);
                    gp0 = gp1;
                }
            }
        }
        int v3 = arrayList1.size();
        long[] arr_v = new long[v3];
        int[] arr_v1 = new int[v3];
        int v4 = 0;
        int v5;
        for(v5 = 0; v4 < v3; v5 |= gp2.b) {
            gp gp2 = (gp)arrayList1.get(v4);
            arr_v[v4] = gp2.a;
            arr_v1[v4] = gp2.b;
            ++v4;
        }
        gm gm0 = new gm(arr_v, arr_v1);
        gm0.c = v5 & 0x7F;
        return gm0;
    }

    public gq b(String s) {
        gq gq0;
        Process process0;
        int v;
        try {
            boolean z = Config.C;
            File file0 = Tools.l();
            boolean z1 = false;
            boolean z2 = false;
            String[] arr_s = this.a(z, s, file0);
            boolean z3 = z;
            while(true) {
                v = 0;
            label_7:
                if(v < 3) {
                    new File(file0, new String[]{"i", "o", "e"}[v]).delete();
                    ++v;
                    goto label_7;
                }
                if(z3) {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append("try: direct");
                    int v1 = arr_s.length;
                    for(int v2 = 0; true; ++v2) {
                        if(v2 >= v1) {
                            la.a(stringBuilder0.toString());
                            break;
                        }
                        String s1 = arr_s[v2];
                        stringBuilder0.append(' ');
                        stringBuilder0.append(s1);
                    }
                }
                process0 = z3 ? Tools.a(arr_s) : qt.a(arr_s[0], null, true);
                StringBuilder stringBuilder1 = new StringBuilder("Daemon process: ").append(process0).append("; pid=");
                String s2 = process0 == null ? "n/a" : Tools.a(process0);
                la.a(stringBuilder1.append(s2).toString());
                gq0 = new gq();
                gq0.a = process0;
                if(process0 != null) {
                    gq0.b = process0.getOutputStream();
                    gq0.c = process0.getInputStream();
                    gq0.d = process0.getErrorStream();
                }
                if(!ex.a(gq0, file0)) {
                    if(!z2) {
                        la.a("Test 1 start");
                        qt.a((z3 ? "id" : "exec id"), 45, (z3 ? "" : null));
                        qt.a = "";
                        la.a("Test 1 end");
                        Tools.a(new File(s), 493);
                        Tools.a(s, "0755");
                        z2 = true;
                    }
                    else if(Config.C) {
                        if(!z3) {
                            break;
                        }
                        arr_s = this.a(false, s, file0);
                        z3 = false;
                    }
                    else {
                        if(z1) {
                            break;
                        }
                        String s3 = ex.a(s);
                        if(s3 == null) {
                            break;
                        }
                        z1 = true;
                        arr_s = this.a(z3, s3, file0);
                    }
                    continue;
                }
                goto label_63;
            }
            this.a(s, true);
            Thread.sleep(1000L);
            qt.a = "" + qt.a(process0);
            la.a("");
            ar.a = true;
            la.c("Show error alert");
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700A3)).setMessage(qk.a(0x7F0700A4) + "\n\n" + "").setPositiveButton(qk.a(0x7F0700B8), new ib(400)).setNeutralButton("SU", new fl(this)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:daemon_failed "Daemon failed"
            return null;
        label_63:
            ex.g = gq0;
            this.i = Tools.a(process0);
            if(this.c()) {
                rx.b(new fx(this));
                return gq0;
            }
            return null;
        }
        catch(go go0) {
            throw go0;
        }
        catch(Exception exception0) {
            la.c(exception0.getMessage(), exception0);
            Tools.b(exception0.getMessage());
            return null;
        }
    }

    public void b(byte b) {
        this.a(b, this.v, this.w);
    }

    void b(byte b, byte b1) {
        rx.d(new ga(this, b, b1));
    }

    public void b(byte b, int v) {
        this.z();
        rx.d(new fh(this, b, v, this.c(v)));
    }

    public void b(byte b, long v, int v1) {
        rx.d(new fb(this, b, v1, v));
    }

    public void b(byte b, List list0) {
        gm gm0 = this.b(list0);
        if(gm0.a.length == 0) {
            return;
        }
        rx.d(new fv(this, gm0, b));
    }

    public void b(int v) {
        this.b(0, v);
    }

    public void b(long v, int v1) {
        this.b(0, v, v1);
    }

    public void b(qx qx0) {
        synchronized(this.A) {
            this.A.add(qx0);
        }
    }

    private boolean[] c(int v) {
        return v == 1 ? MainService.instance.ag.c() : MainService.instance.ae.c();
    }

    public void c(byte b) {
        this.b(b, 56);
    }

    public void c(byte b, long v, int v1) {
        rx.d(new fi(this, b, v, v1));
    }

    public void c(long v, int v1) {
        this.c(0, v, v1);
    }

    public void c(String s) {
        this.a(0, s);
    }

    public boolean c() {
        String s2;
        String s;
        Integer integer0;
        Process process0;
        gq gq0;
        try {
            gq0 = ex.g;
            if(gq0 == null) {
                return false;
            }
            process0 = gq0.a;
            if(process0 == null) {
                return false;
            }
            integer0 = process0.exitValue();
        }
        catch(IllegalThreadStateException unused_ex) {
            integer0 = null;
        }
        if(integer0 == null && ex.C == null && ex.k == null) {
            return true;
        }
        if(!ar.a && !lh.b) {
            if(integer0 == null) {
                s = null;
            }
            else {
                switch(((int)integer0)) {
                    case 9: 
                    case 15: 
                    case 0x89: {
                        if(Config.h == 0) {
                            s = null;
                        }
                        else {
                            Config.a(0x7F0B0093).d = 0;  // id:config_ram
                            Config.c();
                            s = "Found SIGKILL/SIGTERM/SIGKILL_OOM: " + integer0;
                        }
                        break;
                    }
                    default: {
                        s = null;
                    }
                }
            }
            if(s != null) {
                la.c(s);
                rx.a(new gg(this));
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = Tools.a(process0);
            stringBuilder0.append('\n');
            stringBuilder0.append(this.j);
            stringBuilder0.append(" ( ");
            stringBuilder0.append(android.os.Process.myPid());
            stringBuilder0.append(" / ");
            stringBuilder0.append(v);
            stringBuilder0.append(" / ");
            stringBuilder0.append(this.h);
            stringBuilder0.append(" )\n");
            stringBuilder0.append(integer0);
            stringBuilder0.append(" / ");
            stringBuilder0.append(ex.C);
            stringBuilder0.append(" / ");
            stringBuilder0.append(ex.k);
            stringBuilder0.append('\n');
            stringBuilder0.append(MainService.instance.ad / 0x400);
            stringBuilder0.append(" / ");
            stringBuilder0.append(Tools.n());
            stringBuilder0.append(" / ");
            stringBuilder0.append(MainService.instance.ac / 0x400);
            stringBuilder0.append('\n');
            String s1 = eu.a();
            stringBuilder0.append(s1);
            stringBuilder0.append('\n');
            stringBuilder0.append(ir.a(s1, "SHA-384"));
            stringBuilder0.append('\n');
            File file0 = new File(s1);
            stringBuilder0.append(file0.length());
            stringBuilder0.append('\n');
            stringBuilder0.append(ir.a(file0, "SHA-384"));
            if(integer0 != null) {
                stringBuilder0.append("\nOutput:\n");
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(gq0.d));
                while(true) {
                    try {
                    label_62:
                        s2 = bufferedReader0.readLine();
                        if(s2 != null) {
                            goto label_64;
                        }
                    }
                    catch(IOException iOException0) {
                        la.c("checkProcess", iOException0);
                    }
                    catch(OutOfMemoryError outOfMemoryError0) {
                        la.b("Failed get err for daemon exit", outOfMemoryError0);
                        stringBuilder0.append(outOfMemoryError0);
                        stringBuilder0.append('\n');
                    }
                    break;
                    try {
                    label_64:
                        stringBuilder0.append(s2);
                        stringBuilder0.append('\n');
                    }
                    catch(OutOfMemoryError outOfMemoryError1) {
                        try {
                            la.b("Failed get err for daemon exit", outOfMemoryError1);
                            stringBuilder0.append(outOfMemoryError1);
                            stringBuilder0.append('\n');
                            goto label_62;
                        }
                        catch(IOException iOException0) {
                            la.c("checkProcess", iOException0);
                            break;
                        }
                        catch(OutOfMemoryError outOfMemoryError0) {
                        }
                        la.b("Failed get err for daemon exit", outOfMemoryError0);
                        stringBuilder0.append(outOfMemoryError0);
                        stringBuilder0.append('\n');
                        break;
                    }
                    catch(IOException iOException0) {
                        la.c("checkProcess", iOException0);
                        break;
                    }
                }
            }
            stringBuilder0.append("\nDEBUG:\n");
            stringBuilder0.append(gs.a(false));
            String s3 = stringBuilder0.toString();
            try {
                la.c(("Daemon closed" + s3));
            }
            catch(OutOfMemoryError outOfMemoryError2) {
                la.b("Failed out string for daemon exit", outOfMemoryError2);
            }
            if(!ho.a(s3) && s == null) {
                try {
                    if(s3.contains("backtrace:") && s3.contains(this.j) && !s3.contains("SIGPIPE")) {
                        ho.b(s3);
                    }
                }
                catch(OutOfMemoryError outOfMemoryError3) {
                    la.b("Failed send string for daemon exit", outOfMemoryError3);
                }
            }
            try {
                s3 = qk.a(0x7F0700A5) + '\n' + s3;  // string:daemon_unexpected_closed "Daemon unexpectedly closed. Info:"
            }
            catch(OutOfMemoryError outOfMemoryError4) {
                la.b("Failed out string for daemon exit", outOfMemoryError4);
            }
            ar.a = true;
            la.c("Show error alert");
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700A6)).setMessage(s3).setPositiveButton(qk.a(0x7F0700B8), new ib(500)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:daemon_exited "Daemon exited"
            this.e.b(false);
            MainService.instance.G();
            if(integer0 != null) {
                switch(((int)integer0)) {
                    case 9: 
                    case 15: 
                    case 0x89: {
                        i.a(i.c().setCustomTitle(Tools.d(0x7F0700A6)).setMessage(qk.a((((int)integer0) == 0x89 ? 0x7F0702BD : 0x7F070180))).setNegativeButton(qk.a(0x7F07009D), null));  // string:daemon_exited "Daemon exited"
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void d() {
        la.a("messageFailed");
        this.c();
        MainService.instance.T();
    }

    public void d(byte b) {
        this.b(b, 60);
    }

    public void e() {
        this.b(0, 51);
    }

    public void e(byte b) {
        this.b(b, 57);
    }

    public void f() {
        this.a(0);
    }

    public void f(byte b) {
        this.b(b, 58);
    }

    public double g() {
        return ((double)this.v) / ((double)this.w);
    }

    public void g(byte b) {
        if(this.o(b) + this.p(b) + this.q(b) > 0) {
            MainService.instance.y();
        }
    }

    public void h() {
        this.c(0);
    }

    public void h(byte b) {
        this.b(b, 44);
        ra.a = null;
    }

    public void i() {
        this.d(0);
    }

    public void i(byte b) {
        this.b(b, 46);
    }

    public void j() {
        this.e(0);
    }

    public void j(byte b) {
        this.v = 1;
        this.w = 1;
        this.x = 0L;
        uf.a();
        this.e.b();
        this.b(b, 42);
        ra.a = null;
    }

    public void k() {
        this.f(0);
    }

    public void k(byte b) {
        this.a(0, b);
    }

    public void l() {
        this.o = 0;
        this.p = 0;
    }

    public void l(byte b) {
        if(this.B == null || Config.h != ((int)this.B)) {
            if(this.B != null) {
                MainService.instance.h();
            }
            this.B = Config.h;
        }
        String s = Tools.l().getAbsolutePath();
        rx.d(new fy(this, b, s.getBytes(), s));
    }

    public void m() {
        this.g(0);
    }

    void m(byte b) {
        rx.d(new fz(this, b));
    }

    public void n() {
        this.n = true;
        this.B();
    }

    public void n(byte b) {
        rx.d(new gf(this, b));
        try {
            Thread.sleep(3L);
        }
        catch(InterruptedException unused_ex) {
        }
    }

    private int o(byte b) {
        Object[] arr_object;
        synchronized(this.y) {
            arr_object = this.y.toArray(new Object[this.y.size()]);
            this.y.clear();
            this.y.trimToSize();
        }
        if(arr_object.length != 0) {
            rx.d(new fp(this, arr_object, b));
        }
        return arr_object.length;
    }

    public int o() {
        return this.h;
    }

    private int p(byte b) {
        qx[] arr_qx;
        synchronized(this.z) {
            arr_qx = (qx[])this.z.toArray(new qx[this.z.size()]);
            this.z.clear();
            this.z.trimToSize();
        }
        if(arr_qx.length != 0) {
            rx.d(new fq(this, arr_qx, b));
            if((Config.A & 0x80) != 0 && !ex.c) {
                ex.c = true;
                rx.a(new fr(this));
            }
        }
        return arr_qx.length;
    }

    public int p() {
        return this.i;
    }

    private int q(byte b) {
        qx[] arr_qx;
        synchronized(this.A) {
            arr_qx = (qx[])this.A.toArray(new qx[this.A.size()]);
            this.A.clear();
            this.A.trimToSize();
        }
        if(arr_qx.length != 0) {
            rx.d(new ft(this, arr_qx, b));
        }
        return arr_qx.length;
    }

    public void q() {
        File file0;
        this.e.b();
        if(this.h > 0) {
            file0 = new File(Tools.l(), "OOM.tmp");
            try {
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                fileOutputStream0.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(this.h).array());
                fileOutputStream0.close();
                if(!file0.renameTo(new File(Tools.l(), "OOM"))) {
                    la.b(("Failed rename OOM file: " + file0), new RuntimeException());
                    file0.delete();
                    return;
                }
                return;
            }
            catch(IOException iOException0) {
            }
        }
        else {
            return;
        }
        la.b(("Failed make OOM file: " + file0), iOException0);
    }

    public void r() {
        this.i(0);
    }

    public void s() {
        this.j(0);
    }

    public void t() {
        this.l(0);
    }

    void u() {
        InOut inOut0 = this.e;
        if(ex.C != null) {
            la.c(("Last send error: " + ex.C));
            inOut0.e();
            return;
        }
        try {
            inOut0.c();
            ex.C = null;
        }
        catch(Throwable throwable0) {
            inOut0.e();
            la.c("Send error", throwable0);
            ex.C = throwable0.toString();
            rx.a().post(new gb(this));
        }
    }

    public void v() {
        new gc(this, "DaemonLoader").start();
    }

    public void w() {
        this.n(0);
    }

    public CharSequence x() {
        if(!this.e.g()) {
            if(this.d == null || this.d.a == null) {
                return Config.C ? Tools.a("!", Tools.e(0x7F0A0018)) : Tools.a("?", Tools.e(0x7F0A0018));  // color:daemon_bad
            }
            return Config.C ? Tools.a("V", Tools.e(0x7F0A0019)) : Tools.a("W", Tools.e(0x7F0A0019));  // color:daemon_wait
        }
        return Config.C ? Tools.a("$", Tools.e(0x7F0A001B)) : Tools.a("#", Tools.e(0x7F0A001A));  // color:daemon_user
    }

    public boolean y() {
        boolean z = !ex.a && !this.e.g();
        if(z) {
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700F5)).setMessage(qk.a(0x7F0700F4)).setNegativeButton(qk.a(0x7F07009D), null));  // string:daemon_fail "Daemon is not running"
        }
        return !z;
    }

    private void z() {
        MainService.instance.i();
        MainService.instance.j();
    }
}

