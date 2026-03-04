package android.ext;

import android.content.res.Resources;
import android.lang.ProcessBuilder;
import android.os.Build.VERSION;
import android.system.ErrnoException;
import android.system.Os;
import catch_.me_.if_.you_.can_.R.raw;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class eu {
    public static StringBuilder a;
    public static StringBuilder b;
    private final String c;
    private static volatile String d;
    private static volatile String e;
    private static volatile int f;
    private static volatile char g;
    private static volatile char h;

    static {
        eu.d = null;
        eu.e = null;
        eu.f = 100;
        eu.g = 'i';
        eu.h = 'g';
        eu.a = new StringBuilder();
        eu.b = new StringBuilder();
    }

    public eu() {
        this.c = this.g();
    }

    public static String a() {
        if(eu.d == null) {
            eu.d = new eu().c;
        }
        return eu.d;
    }

    private static String a(String s) {
        for(int v = 0; v < 13; ++v) {
            File file0 = new File(s, eu.c(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'd'}[v]));
            if(file0.exists()) {
                String s1 = file0.getAbsolutePath();
                if(!Tools.d(s1)) {
                    la.a(("Can not execute " + s1));
                }
            }
        }
        return s;
    }

    // 去混淆评级： 低(30)
    public static String a(boolean z) {
        new StringBuilder("/lib");
        return z ? "/libg.so" : "/libi.so";
    }

    private static void a(char c) {
        eu.b(Character.toString(c));
    }

    private static void a(ArrayList arrayList0, String s, String s1, boolean z) {
        File file0 = new File(s);
        if(!z || file0.exists()) {
            arrayList0.add(new File(s + "/files", s1));
            arrayList0.add(new File(s + "/cache", s1));
            arrayList0.add(new File(s + "/files"));
            arrayList0.add(new File(s + "/cache"));
            arrayList0.add(file0);
        }
    }

    private boolean a(char c, int v) {
        switch(c) {
            case 0x30: {
                return 101 == v;
            }
            case 49: {
                return 101 == v;
            }
            case 50: {
                return 102 == v;
            }
            case 53: {
                return 105 == v;
            }
            case 55: {
                return 104 == v;
            }
            case 56: {
                return 104 == v;
            }
            case 97: {
                return 103 == v;
            }
            case 98: {
                return 103 == v;
            }
            default: {
                throw new RuntimeException("Unknown lib: " + c);
            }
        }
    }

    private boolean a(File file0) {
        if(file0 == null) {
            return true;
        }
        if(!file0.exists()) {
            file0.mkdirs();
            return !file0.exists();
        }
        return false;
    }

    public static int b() {
        eu.a();
        return eu.f;
    }

    private void b(char c) {
        eu.a(c);
        switch(c) {
            case 0x30: 
            case 49: {
            label_8:
                eu.a('3');
                eu.a('e');
                eu.g = 'e';
                eu.a('j');
                break;
            }
            case 50: {
                eu.b("01");
                eu.a('4');
                eu.a('f');
                eu.h = 'f';
                eu.a('k');
                goto label_8;
            }
            case 53: {
                eu.b("08");
                eu.a('6');
                eu.a('g');
                eu.h = 'g';
                eu.a('l');
                goto label_18;
            }
            case 55: 
            case 56: {
            label_18:
                eu.a('9');
                eu.a('h');
                eu.g = 'h';
                eu.a('n');
                break;
            }
            case 97: 
            case 98: {
                eu.a('d');
                eu.a('i');
                eu.g = 'i';
                eu.a('o');
            }
        }
        try {
            Tools.a("sh", new File(Tools.l(), "sh.jar"));
        }
        catch(Throwable throwable0) {
            la.c("JVM fail", throwable0);
        }
    }

    private static void b(String s) {
        File file0 = new File(eu.d(), "lib" + s + ".so");
        if(!file0.isFile()) {
            la.a(("Extract file " + file0));
            Resources resources0 = Tools.e().getResources();
            int v = qk.a(("ydw" + s), R.raw.class);
            if(v == 0) {
                la.a(("Nothing extract file " + s + ' ' + file0.getAbsolutePath()));
                return;
            }
            try {
                byte[] arr_b = new byte[0x2000];
                InputStream inputStream0 = resources0.openRawResource(v);
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                while(true) {
                    int v1 = inputStream0.read(arr_b);
                    if(v1 <= 0) {
                        fileOutputStream0.close();
                        inputStream0.close();
                        return;
                    }
                    fileOutputStream0.write(arr_b, 0, v1);
                }
            }
            catch(Throwable throwable0) {
                la.a(("Failed extract file " + s + ' ' + file0.getAbsolutePath()), throwable0);
            }
        }
    }

    private static String c(char c) {
        return "lib" + Character.toString(c) + ".so";
    }

    private static String c(String s) [...] // Inlined contents

    public static boolean c() {
        switch(eu.b()) {
            case 101: 
            case 102: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private int d(String s) {
        Tools.d(s);
        boolean z = false;
        try {
            while(true) {
                try {
                    Process process0 = Tools.a(new String[]{Tools.n(s), "1"});
                    if(!Tools.a(process0, 30)) {
                        throw new RuntimeException("timeout: " + 30);
                    }
                    return process0.exitValue();
                }
                catch(IOException iOException0) {
                    if(z) {
                        throw iOException0;
                    }
                    String s1 = iOException0.getMessage();
                    if(s1 == null || s1.indexOf("denied") == -1) {
                        throw iOException0;
                    }
                    Tools.a(s, "0755");
                    z = true;
                }
            }
        }
        catch(Throwable throwable0) {
            la.b(("getArch: " + s), throwable0);
            eu.b.append(throwable0.toString());
            return 100;
        }
    }

    public static String d() {
        if(eu.e == null) {
            File file0 = eu.f();
            if(file0 == null) {
                file0 = Tools.l();
            }
            eu.e = eu.a(file0.getAbsolutePath());
        }
        return eu.e;
    }

    public static void e() {
        char[] arr_c = Build.VERSION.SDK_INT >= 21 ? new char[]{'\u0000', 'q', 'p', 'r', 's', 't'} : new char[]{'\u0000', 'p', 's', 't', 'q', 'r'};
        String s = eu.d();
        int v = 0;
        while(v < 6) {
            if(v == 0) {
                for(int v1 = 1; v1 < 6; ++v1) {
                    if(new File(s, eu.c(arr_c[v1])).exists()) {
                        arr_c[0] = arr_c[v1];
                        break;
                    }
                }
                if(arr_c[0] != 0) {
                    goto label_13;
                }
            }
            else {
            label_13:
                File file0 = new File(s, eu.c(arr_c[v]));
                if(!file0.isFile()) {
                    eu.a(arr_c[v]);
                }
                if(!file0.isFile()) {
                    la.a(("Not a file " + file0 + ' ' + file0.getAbsolutePath()));
                    goto label_29;
                }
                String s1 = file0.getAbsolutePath();
                try {
                    System.load(s1);
                }
                catch(Throwable throwable0) {
                    la.a(("Failed load " + file0 + ' ' + file0.getAbsolutePath()), throwable0);
                    goto label_29;
                }
                try {
                    ProcessBuilder.loaded();
                    return;
                }
                catch(Throwable throwable1) {
                    la.a(("Failed check " + file0 + ' ' + file0.getAbsolutePath()), throwable1);
                }
            }
        label_29:
            ++v;
        }
    }

    private static File f() {
        File file2;
        File file0 = Tools.i();
        File file1 = Tools.h();
        String s = Tools.j();
        ArrayList arrayList0 = new ArrayList(0x40);
        arrayList0.add(Tools.l());
        arrayList0.add(Tools.k());
        arrayList0.add(file0);
        arrayList0.add(file1);
        arrayList0.add(new File(file0.getParentFile(), s));
        arrayList0.add(new File(file1.getParentFile(), s));
        arrayList0.add(file0.getParentFile());
        arrayList0.add(file1.getParentFile());
        String s1 = file0.getAbsolutePath();
        String s2 = s1.startsWith("/data/user/") ? s1.split("/", -1)[3] : "0";
        eu.a(arrayList0, (s1.startsWith("/data/user/") ? "/data/user/" + s2 + "/" : "/data/data/") + y.d, s, false);
        eu.a(arrayList0, "/data/user_de/" + s2 + "/" + y.d, s, false);
        arrayList0.add(new File("/data/data"));
        arrayList0.add(new File("/data"));
        Iterator iterator0 = arrayList0.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                la.b("Failed get dir for fix");
                return null;
            }
            Object object0 = iterator0.next();
            file2 = (File)object0;
            if(file2 == null) {
                continue;
            }
            if(!file2.exists()) {
                file2.mkdirs();
            }
            if(file2.exists()) {
                break;
            }
            try {
                if(Build.VERSION.SDK_INT < 21) {
                    continue;
                }
                String s3 = file2.getAbsolutePath();
                try {
                    if((Os.stat(s3).st_mode & 0x4000) == 0) {
                        continue;
                    }
                }
                catch(Exception exception0) {
                    if(exception0 instanceof ErrnoException) {
                        la.b(("Errno for path \'" + s3 + "\': " + ((ErrnoException)exception0).errno), exception0);
                        continue;
                    }
                    la.b(("Exception for path \'" + s3 + "\'"), exception0);
                    continue;
                }
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                continue;
            }
            return file2;
        }
        return file2;
    }

    private String g() {
        int v4;
        char[] arr_c;
        boolean z = true;
        int v = Build.VERSION.SDK_INT;
        if(v < 16) {
            arr_c = new char[]{'\u0000', '0', '7', 'a', '2', '1', '5', '8', 'b'};
        }
        else {
            arr_c = v >= 21 ? new char[]{'\u0000', '2', '1', '5', '8', 'b', '0', '7', 'a'} : new char[]{'\u0000', '1', '0', '8', '7', 'b', 'a', '2', '5'};
        }
        String s = eu.d();
        int v1 = 0;
        int v2 = !Config.C || Config.G != 1 && (Config.G != 0 || !Config.E.contains("64")) ? 2 : 0;
        while(true) {
            if(v1 >= arr_c.length) {
                if(v2 == 1) {
                    try {
                        File file0 = new File(Tools.r());
                        if(this.a(file0)) {
                            file0 = Tools.e().getExternalCacheDir();
                            if(this.a(file0)) {
                                file0 = Tools.e().getExternalFilesDir(null);
                                if(this.a(file0)) {
                                    file0 = new File("/sdcard");
                                }
                            }
                        }
                        File file1 = new File(file0, "gg_fixer.apk");
                        if(file1.exists()) {
                            file1.delete();
                        }
                        Tools.a("fx", file1);
                        rx.a(new ev(this, file1));
                    }
                    catch(Throwable throwable0) {
                        la.b("Failed extract fx", throwable0);
                    }
                }
                eu.a.append(';');
                String s1 = Tools.n(s);
                try {
                    eu.b.append("\n\n");
                    eu.b.append("ls -l ");
                    eu.b.append(s1);
                    eu.b.append(":\n");
                    BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(Tools.a(new String[]{"ls", "-l", s1}).getInputStream()));
                    String s2;
                    while((s2 = bufferedReader0.readLine()) != null) {
                        if(s2.indexOf("lib") != -1 && s2.indexOf(".so") != -1) {
                            la.a(("ls: " + s2));
                            eu.b.append(s2);
                            eu.b.append('\n');
                        }
                    }
                    bufferedReader0.close();
                }
                catch(Exception exception0) {
                    la.b(("ls: " + s1), exception0);
                    eu.b.append(exception0);
                    eu.b.append('\n');
                }
                eu.b.append('\n');
                return "no_binary_for_your_arch";
            }
            if(v1 == 0) {
                for(int v3 = 1; v3 < arr_c.length; ++v3) {
                    if(new File(s, eu.c(arr_c[v3])).exists()) {
                        arr_c[0] = arr_c[v3];
                        break;
                    }
                }
                if(arr_c[0] != 0) {
                    goto label_57;
                }
            }
            else {
            label_57:
                eu.b.append(arr_c[v1]);
                eu.b.append(": ");
                String s3 = "0" + arr_c[v1];
                File file2 = new File(s, "lib" + s3 + ".so");
                if(!file2.isFile()) {
                    eu.b(s3);
                }
                if(file2.isFile()) {
                    eu.a.append(arr_c[v1]);
                    v4 = this.d(file2.getAbsolutePath());
                    if(this.a(arr_c[v1], v4)) {
                        break;
                    }
                    la.a(("getArch " + arr_c[v1] + ' ' + v4));
                    eu.b.append("; ");
                    eu.b.append(v4);
                    eu.b.append('\n');
                    if(v2 == 0 && (v4 & 0x7F) < 100) {
                        v2 = 1;
                    }
                }
                else {
                    eu.b.append(file2);
                    eu.b.append(" NF.\n");
                    la.a(("Not a file " + file2 + ' ' + file2.getAbsolutePath()));
                }
            }
            ++v1;
        }
        if(v4 != 102 && v4 != 105) {
            z = false;
        }
        InOut.a(z);
        eu.a = new StringBuilder(0);
        eu.b = new StringBuilder(0);
        String s4 = new File(s, eu.c(arr_c[v1])).getAbsolutePath();
        la.a(("Daemon: " + s4));
        eu.f = v4;
        this.b(arr_c[v1]);
        Tools.d(s4);
        return s4;
    }
}

