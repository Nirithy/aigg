package android.ext;

import android.c.a;
import android.c.e;
import android.os.Build.VERSION;
import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class gs {
    public static int a(String s) {
        int v2;
        String[] arr_s = s.replaceAll("[^\\d.]", "").split("\\.", -1);
        int v = 0;
        int v1;
        for(v1 = 0; v < arr_s.length; v1 = v2) {
            try {
                v2 = v1 * 100 + Integer.parseInt(arr_s[v]);
            }
            catch(NumberFormatException numberFormatException0) {
                la.b(("bad part of version: " + arr_s[v] + '(' + s + ')'), numberFormatException0);
                v2 = v1;
            }
            ++v;
        }
        return v1;
    }

    public static String a(boolean z) {
        return gs.a(z, 0);
    }

    private static String a(boolean z, int v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            Process process0 = qt.a((z ? "exec logcat -d -v threadtime " : "exec logcat -d -v brief "), null, true);
            if(process0 == null) {
                stringBuilder0.append("");
            }
            else {
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(process0.getInputStream()));
                String[] arr_s = v <= 0 ? null : new String[v];
            alab1:
                while(true) {
                    int v1 = 0;
                    while(true) {
                        if(Thread.interrupted()) {
                            break alab1;
                        }
                        String s = bufferedReader0.readLine();
                        if(s == null) {
                            break alab1;
                        }
                        boolean z1 = s.contains("AndroidService");
                        if(!z1 && s.contains("android-daemon")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("AndroidRuntime")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("libc")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("Vold")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("DEBUG")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("CRASH")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("*** *** *** *** *** *** ***")) {
                            z1 = true;
                        }
                        if(!z1 && s.contains(Tools.g())) {
                            z1 = true;
                        }
                        if(!z1 && s.contains("--- beginning of ")) {
                            z1 = true;
                        }
                        if(!z1 && android.os.Process.myPid() > 0 && s.contains("2644")) {
                            z1 = true;
                        }
                        int v2 = MainService.instance.k.o();
                        if(!z1 && v2 > 0 && s.contains(Integer.toString(v2))) {
                            z1 = true;
                        }
                        int v3 = MainService.instance.k.p();
                        if(!z1 && v3 > 0 && s.contains(Integer.toString(v3))) {
                            z1 = true;
                        }
                        if(!z1) {
                        }
                        else if(arr_s == null) {
                            stringBuilder0.append(s);
                            stringBuilder0.append('\n');
                        }
                        else {
                            arr_s[v1] = s;
                            if(v1 + 1 >= v) {
                                break;
                            }
                            ++v1;
                        }
                    }
                }
                if(arr_s != null) {
                    for(int v4 = v1; !Thread.interrupted(); v4 = v5) {
                        int v5 = v4 + 1;
                        String s1 = arr_s[v4];
                        if(s1 != null) {
                            stringBuilder0.append(s1);
                            stringBuilder0.append('\n');
                        }
                        if(v5 >= v) {
                            v5 = 0;
                        }
                        if(v5 == v1) {
                            break;
                        }
                    }
                }
            }
        }
        catch(OutOfMemoryError unused_ex) {
            try {
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append(gs.a(z, 500));
            }
            catch(OutOfMemoryError unused_ex) {
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append("OutOfMemoryError\n");
            }
        }
        catch(Throwable throwable0) {
            stringBuilder0.append(throwable0.getMessage());
            stringBuilder0.append('\n');
            la.a("getLogcat fail.", throwable0);
        }
        qt.a = "";
        return stringBuilder0.toString();
    }

    public static void a() {
        Tools.a(0x7F0700A9);  // string:collect_data_to_region_log "Started collection of data to write to the region 
                              // log..."
        new gt("runCollectRegionLog").start();
    }

    public static void b() {
        int v4;
        String s = new File(Tools.r(), "GG_" + Build.VERSION.RELEASE + "_API_" + Build.VERSION.SDK_INT + ".log").getAbsolutePath();
        try {
            BufferedWriter bufferedWriter0 = new BufferedWriter(new FileWriter(s, false));
            bufferedWriter0.write("Thu Mar 05 01:17:12 CST 2026");
            bufferedWriter0.write("\n");
            bufferedWriter0.write("Release: ");
            bufferedWriter0.write(Build.VERSION.RELEASE);
            bufferedWriter0.write("\n");
            bufferedWriter0.write("SDK: ");
            bufferedWriter0.write(Build.VERSION.SDK_INT);
            bufferedWriter0.write("\n");
            try {
                Process process0 = qt.a("echo \"list:\"; ls -l /proc/; for i in /proc/*; do echo \"cat $i/maps:\"; cat $i/maps; done; exit;", null, true);
                if(process0 == null) {
                    bufferedWriter0.write("");
                }
                else {
                    BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(process0.getInputStream()));
                    String s1;
                    while((s1 = bufferedReader0.readLine()) != null) {
                        bufferedWriter0.write(s1);
                        bufferedWriter0.write("\n");
                    }
                    bufferedReader0.close();
                }
                qt.a = "";
                bufferedWriter0.write("current pid: ");
                qh qh0 = MainService.instance.ap;
                String s2 = qh0 == null ? "0" : qh0.f;
                bufferedWriter0.write(s2);
                bufferedWriter0.write("\n");
                bufferedWriter0.write("search results:\n");
                a a0 = MainService.instance.am;
                d d0 = new d();
                synchronized(a0) {
                    int v1 = a0.b();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        a0.a(v2, d0);
                        bufferedWriter0.write(ts.a(8, d0.b) + ' ' + d0.h() + ' ' + d0.n() + " (" + Integer.toBinaryString(d0.d) + ")\n");
                    }
                }
                bufferedWriter0.write("saved list:\n");
                e e0 = MainService.instance.an.b();
                for(int v3 = 0; v3 < e0.b(); ++v3) {
                    qx qx0 = (qx)e0.c(v3);
                    if(qx0 != null) {
                        bufferedWriter0.write(ts.a(8, qx0.b) + ' ' + qx0.h() + ' ' + qx0.n() + " (" + Integer.toBinaryString(qx0.d) + ")\n");
                    }
                }
            }
            catch(Exception exception1) {
                bufferedWriter0.write(exception1.getMessage());
                bufferedWriter0.write("\n");
            }
            bufferedWriter0.close();
            v4 = 0x7F0700AA;  // string:log_saved "Log saved to __s__"
        }
        catch(Exception exception0) {
            la.c(("Error opening file to save: " + s), exception0);
            v4 = 0x7F0700AB;  // string:failed_save "Failed to save to __s__"
        }
        i.a(i.c().setCustomTitle(Tools.d(0x7F0700AC)).setMessage(Tools.a(qk.a(v4), new Object[]{s})).setNegativeButton(qk.a(0x7F07009D), null));  // string:region_log "Region log"
    }

    public static int c() {
        return gs.a(101.099998f);
    }

    public static String d() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(" Android(");
        Class[] arr_class = {Build.VERSION.class, Build.class};
        for(int v = 0; v < 2; ++v) {
            Field[] arr_field = arr_class[v].getFields();
            for(int v1 = 0; v1 < arr_field.length; ++v1) {
                Field field0 = arr_field[v1];
                try {
                    int v2 = field0.getModifiers();
                    if(Modifier.isPublic(v2) && Modifier.isStatic(v2)) {
                        stringBuilder0.append(field0.getName());
                        stringBuilder0.append(": ");
                        try {
                            Object object0 = field0.get(null);
                            if(object0 instanceof Object[]) {
                                stringBuilder0.append(Arrays.toString(((Object[])object0)));
                            }
                            else {
                                stringBuilder0.append(object0);
                            }
                        }
                        catch(Throwable throwable1) {
                            stringBuilder0.append(throwable1.getMessage());
                        }
                        stringBuilder0.append("; ");
                    }
                }
                catch(Throwable throwable0) {
                    stringBuilder0.append(throwable0.getMessage());
                }
            }
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    public static void e() {
        new gu("showInfo").start();
    }

    public static String f() {
        return "101.1 (" + 0x3F0E + ") " + jp.g() + " on " + gs.d();
    }
}

