package android.ext;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ho implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;
    private final String b;
    private static volatile Throwable c;
    private static volatile boolean d;

    static {
        ho.c = null;
        ho.d = false;
    }

    private ho(Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0, String s) {
        this.a = thread$UncaughtExceptionHandler0;
        this.b = s;
    }

    public static String a(Thread thread0, Throwable throwable0, boolean z) {
        String s5;
        String s4;
        String s3;
        String s = thread0.getName();
        if(z) {
            la.c(("Exception in thread " + s), throwable0);
            la.b();
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("GG: ");
        stringBuilder0.append(101.099998f);
        stringBuilder0.append(" [");
        stringBuilder0.append(0x3F0E);
        stringBuilder0.append("]\nAndroid: ");
        stringBuilder0.append(Build.VERSION.RELEASE);
        stringBuilder0.append("\nSDK: ");
        stringBuilder0.append(Build.VERSION.SDK_INT);
        stringBuilder0.append("\nvSpace: ");
        stringBuilder0.append("su");
        stringBuilder0.append("\nThread: ");
        stringBuilder0.append(s);
        stringBuilder0.append('\n');
        String s1 = la.b(throwable0);
        boolean z1 = (throwable0 instanceof StackOverflowError || s1.contains("java.lang.StackOverflowError")) && s1.contains("com.lody.virtual.client.ipc.");
        stringBuilder0.append(s1);
        if(s1.contains("ActivityNotFoundException")) {
            Tools.a(y.d, stringBuilder0);
        }
        stringBuilder0.append("\nHash: ");
        try {
            stringBuilder0.append(jp.g());
        }
        catch(Throwable throwable1) {
            stringBuilder0.append("???");
            la.c("dbg", throwable1);
        }
        String s2 = stringBuilder0.toString();
        boolean z2 = Tools.e() != null;
        boolean z3 = s2.contains("EGL_") || s2.contains("egl") || s2.contains("HardwareRenderer");
        if(z && z2 && z3 && (Config.B & 2) != 0) {
            Config.a(0x7F0B00AE).d = 0;  // id:config_acceleration
            Config.c();
            return "GG crashed. Hardware acceleration fail.";
        }
        if(z && z3 && (Config.B & 2) == 0 && ar.b) {
            ho.d = true;
            ar.b = false;
            return "GG crashed. Hardware acceleration fail. Try use \'GG (SW)\' icon for start.";
        }
        if(z && z2 && s2.contains("Suggestion") && (Config.B & 8) != 0) {
            Config.a(0x7F0B00A0).d = 0;  // id:config_suggestions
            Config.c();
            return "GG crashed. Cause: suggestions.";
        }
        if(z && z2 && s2.contains("playSoundEffect") && (Config.B & 0x20) != 0) {
            Config.a(0x7F0B00AF).d = 0;  // id:config_use_sound_effects
            Config.c();
            return "GG crashed. Cause: sound effects.";
        }
        try {
            File file0 = new File(Tools.r(), "crash.txt");
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0, true);
            ar.a(fileOutputStream0, file0.getAbsolutePath(), "");
            fileOutputStream0.write("".getBytes());
            fileOutputStream0.write(s2.getBytes());
            fileOutputStream0.close();
            s3 = "GG crashed\nLog: " + file0.getAbsolutePath();
        }
        catch(Throwable throwable2) {
            la.b("Failed out crash to file", throwable2);
            s3 = "GG crashed";
        }
        try {
            File file1 = new File(Tools.r(), "logcat.txt");
            ar.a(new FileOutputStream(file1, true), file1.getAbsolutePath(), "");
            String[] arr_s = {"logcat", "-f", Tools.n(file1.getAbsolutePath()), "-d", "-v", "threadtime", "-b", "main", "-b", "system", "*:V"};
            try {
                if(!Tools.a(Tools.a(arr_s), 15)) {
                    la.b(("timeout fail 1: " + Arrays.toString(arr_s)), new RuntimeException());
                }
            }
            catch(Exception exception0) {
                la.b("exec", exception0);
            }
            s4 = s3 + "\nLogcat: " + file1.getAbsolutePath();
        }
        catch(Throwable throwable3) {
            la.b("Failed out logcat to file", throwable3);
            s4 = s3;
        }
        try {
            Config.a(0x7F0B00C2).d = 0x3F0E;  // id:record_logcat
            Config.c();
            s5 = s4 + "\nNext run rec logcat: " + ar.e();
        }
        catch(Throwable throwable4) {
            la.b("Failed enable logcat on next run", throwable4);
            s5 = s4;
        }
        try {
            String[] arr_s1 = ho.a();
            if(z && s2.contains(": XPrivacy")) {
                throw new RuntimeException(arr_s1[0] + " is cause");
            }
            if(z1) {
                la.a("VSpace StackOverflowError - log not sended");
                return s5;
            }
            if(!uk.a(s2, true)) {
                throw new RuntimeException("Failed sendLogBlocking");
            }
        }
        catch(Throwable throwable5) {
            la.b("Cannot send exception info", throwable5);
            if(z) {
                ho.a(s2, s, la.b(throwable0));
            }
        }
        return s5;
    }

    private static void a(String s, int v, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        String[] arr_s = ho.a();
        la.b((arr_s[v * 2] + " is reason of last fail"));
        AlertDialog.Builder alertDialog$Builder0 = i.c().setCustomTitle(Tools.d(0x7F0700BB)).setMessage(Tools.a(qk.a(0x7F0702A2), new Object[]{arr_s[v * 2]}) + "\n\n" + s).setNeutralButton(qk.a(0x7F070156), new hu(arr_s, v)).setNegativeButton(qk.a(0x7F07009D), null);  // string:last_run_failed "Last run failed"
        if(dialogInterface$OnClickListener0 != null) {
            alertDialog$Builder0.setPositiveButton(qk.a(0x7F070164), dialogInterface$OnClickListener0);  // string:fix_it "Fix it"
        }
        i.b(alertDialog$Builder0);
    }

    private static void a(String s, String s1, Runnable runnable0) {
        String[] arr_s = ho.a();
        int v;
        for(v = 0; true; v += 2) {
            if(v >= arr_s.length) {
                v = -1;
                break;
            }
            if(s.contains(": " + arr_s[v])) {
                break;
            }
        }
        hp hp0 = new hp(s, arr_s, v, runnable0);
        if(v >= 0) {
            la.b((arr_s[v] + " is reason of last fail"));
            i.b(i.c().setCustomTitle(Tools.d(0x7F0700BB)).setMessage(Tools.a(qk.a(0x7F0702A2), new Object[]{arr_s[v]}) + "\n\n" + s1).setNeutralButton(qk.a(0x7F070156), hp0).setNegativeButton(qk.a(0x7F07009D), hp0));  // string:last_run_failed "Last run failed"
            return;
        }
        i.b(i.c().setCustomTitle(Tools.d(0x7F0700BB)).setMessage(qk.a(0x7F0700BA) + "\n\n" + s).setPositiveButton(qk.a(0x7F07009B), hp0).setNegativeButton(qk.a(0x7F07009C), hp0));  // string:last_run_failed "Last run failed"
    }

    public static void a(String s, String s1, String s2) {
        if(Tools.e() != null) {
            Tools.s().edit().putString("last_exception", s).putString("last_exception_trace", s2).commit();
            return;
        }
        File file0 = new File(Tools.l(), "store_ex.txt");
        try {
            BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file0)));
            bufferedWriter0.write(s + "@#%~~%#@" + s2);
            bufferedWriter0.close();
        }
        catch(IOException iOException0) {
            la.c("Failed store exception", iOException0);
        }
    }

    public static void a(Thread thread0) {
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = Thread.getDefaultUncaughtExceptionHandler();
        if(thread$UncaughtExceptionHandler0 == null || !(thread$UncaughtExceptionHandler0 instanceof ho)) {
            Thread.setDefaultUncaughtExceptionHandler(new ho(thread$UncaughtExceptionHandler0, "default"));
        }
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler1 = thread0.getUncaughtExceptionHandler();
        if(thread$UncaughtExceptionHandler1 == null || !(thread$UncaughtExceptionHandler1 instanceof ho)) {
            if(thread$UncaughtExceptionHandler1 == null) {
                thread$UncaughtExceptionHandler1 = thread0.getThreadGroup();
            }
            thread0.setUncaughtExceptionHandler(new ho(thread$UncaughtExceptionHandler1, "thread:" + thread0.getName()));
        }
    }

    public static void a(Thread thread0, Throwable throwable0) {
        String s = thread0.getName();
        String s1 = la.b(throwable0);
        ho.a(("GG: " + 101.099998f + " [" + 0x3F0E + "]\nAndroid: " + Build.VERSION.RELEASE + "\nSDK: " + Build.VERSION.SDK_INT + "\nvSpace: " + lh.o() + "\nThread: " + s + '\n' + s1 + "\nHash: " + jp.g()), s, s1);
    }

    public static boolean a(String s) {
        String[] arr_s = ho.a();
        if(s.contains(" Process  (") && s.contains(") has open file /")) {
            la.b("unmount is reason of last fail");
            i.b(i.c().setCustomTitle(Tools.d(0x7F0700BB)).setMessage(qk.a(0x7F07028F) + "\n\n" + s).setPositiveButton(qk.a(0x7F070164), new hs()).setNegativeButton(qk.a(0x7F07009D), null));  // string:last_run_failed "Last run failed"
            return true;
        }
        if(s.contains("CZAutoRunController")) {
            ho.a(s, 3, new be("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25<70krz0wr0uxq0lq0skrhql{rv0jdphjxdugldq2"));
            return true;
        }
        if(s.contains(arr_s[8])) {
            ho.a(s, 4, new ht(arr_s));
            return true;
        }
        if(s.contains(arr_s[10])) {
            ho.a(s, 5, null);
            return true;
        }
        return false;
    }

    public static String[] a() {
        return new String[]{"XPrivacy", "biz.bokhorst.xprivacy", "Prevent Running", "me.piebridge.forcestopgb", "Brevent", "me.piebridge.brevent", "Security", "com.chaozhuo.permission.controller", "Whetstone", "com.miui.whetstone", "NeoSafe", "cn.nubia.security2"};
    }

    public static void b() {
        ho.a(Thread.currentThread());
    }

    public static void b(String s) {
        uk.a(("GG: " + 101.099998f + " [" + 0x3F0E + "]\nAndroid: " + Build.VERSION.RELEASE + "\nSDK: " + Build.VERSION.SDK_INT + "\nvSpace: " + lh.o() + '\n' + s + "\nHash: " + jp.g()), true);
    }

    public static void c() {
        ho.d();
        try {
            SharedPreferences sharedPreferences0 = Tools.s();
            if(sharedPreferences0.contains("last_exception")) {
                ho.a(sharedPreferences0.getString("last_exception", "- unknown -"), sharedPreferences0.getString("last_exception_trace", "- unknown -"), new hq(sharedPreferences0));
            }
        }
        catch(StackOverflowError stackOverflowError0) {
            la.a(stackOverflowError0);
        }
        try {
            File file0 = new File(Tools.l(), "store_ex.txt");
            if(file0.exists()) {
                try {
                    BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(file0)));
                    StringBuilder stringBuilder0 = new StringBuilder();
                    String s;
                    while((s = bufferedReader0.readLine()) != null) {
                        stringBuilder0.append(s);
                        stringBuilder0.append('\n');
                    }
                    bufferedReader0.close();
                    String[] arr_s = stringBuilder0.toString().split("@#%~~%#@", 2);
                    ho.a(arr_s[0], arr_s[1], new hr(file0));
                }
                catch(IOException iOException0) {
                    la.c("Failed load exception", iOException0);
                }
            }
        }
        catch(StackOverflowError stackOverflowError1) {
            la.a(stackOverflowError1);
        }
    }

    private void c(String s) {
        try {
            new hv(this, "showToast", s).start();
            try {
                Thread.sleep(4000L);
            }
            catch(InterruptedException unused_ex) {
            }
        }
        catch(Throwable unused_ex) {
        }
    }

    private static void d() {
        File file0 = new File(Tools.l(), "client_crash.log");
        if((Config.c & 0x40L) == 0L && file0.exists() && file0.length() > 0L) {
            String s = "Native crash detected: " + file0.length();
            la.b(s);
            try {
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append(s);
                stringBuilder0.append("\n\n");
                boolean z = false;
                try {
                    BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(file0)));
                    while(!Thread.interrupted()) {
                        String s1 = bufferedReader0.readLine();
                        if(s1 == null) {
                            break;
                        }
                        if(!z) {
                            String s2 = ex.b();
                            if(s1.contains(s2) && !s1.trim().equals(s2)) {
                                z = true;
                                goto label_19;
                            }
                            la.b("Native crash check fail.");
                            break;
                        }
                    label_19:
                        stringBuilder0.append(s1);
                        stringBuilder0.append('\n');
                    }
                    bufferedReader0.close();
                }
                catch(Throwable throwable1) {
                    stringBuilder0.append(throwable1.getMessage());
                    stringBuilder0.append('\n');
                    la.b("Native crash load fail.", throwable1);
                }
                if(z) {
                    String s3 = stringBuilder0.toString();
                    if(!ho.a(s3)) {
                        if(!s3.contains(">>> " + Tools.g() + " <<<") || !s3.contains("backtrace:")) {
                            la.b("Native crash skipped.");
                        }
                        else {
                            la.b("Native crash sended.");
                            ho.b(s3);
                        }
                    }
                }
                file0.delete();
            }
            catch(Throwable throwable0) {
                la.b("Native crash check file fail.", throwable0);
            }
        }
        try {
            file0.createNewFile();
        }
        catch(Throwable throwable2) {
            la.b("Native crash create file fail.", throwable2);
        }
    }

    @Override
    public void uncaughtException(Thread thread0, Throwable throwable0) {
        if(ho.c == throwable0) {
            la.a(("uncaughtException already called for: " + throwable0));
        }
        else {
            ho.c = throwable0;
            if(!(throwable0 instanceof hw)) {
                this.c(ho.a(thread0, throwable0, true));
                if(ho.d) {
                    ar.h();
                }
            }
        }
        if(this.a != null) {
            this.a.uncaughtException(thread0, throwable0);
        }
    }
}

