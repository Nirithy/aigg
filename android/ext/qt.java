package android.ext;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class qt {
    public static String a;
    static volatile int b;
    private static boolean c;
    private static String d;

    static {
        qt.a = "";
        qt.c = false;
        qt.d = "su";
        SharedPreferences sharedPreferences0 = Tools.s();
        qt.d = sharedPreferences0.getString("su", "su");
        qt.c = sharedPreferences0.getBoolean("sh", false);
        qt.b = 0;
    }

    public static Process a(String s, String s1, boolean z) {
        Process process1;
        String s3;
        StringBuilder stringBuilder0 = new StringBuilder();
        la.a(("try: " + s));
        if(!s.contains("exec") && !s.contains("exit")) {
            throw new RuntimeException("You forgot exec or exit");
        }
        if(s.contains("/emulated/0")) {
            la.b(("Possible bugged call to /emulated/0 from root: " + s));
        }
        stringBuilder0.append("try: ");
        stringBuilder0.append(s);
        stringBuilder0.append('\n');
        String s2 = qt.a(s1);
        stringBuilder0.append("su: ");
        stringBuilder0.append(s2);
        stringBuilder0.append('\n');
        if(qt.c) {
            s3 = "sh";
            s = "exec " + s2 + '\n' + s;
        }
        else {
            s3 = s2;
        }
        String[] arr_s = {s3};
        la.a(("suCmd: \'" + s1 + "\'; su: \'" + s2 + "\'; runBin: \'" + s3 + '\''));
        Process process0 = null;
        int v = 0;
        while(v < 2) {
            try {
                switch(v) {
                    case 0: {
                        la.a("exec 0 start");
                        process1 = Tools.a(arr_s);
                        break;
                    }
                    case 1: {
                        goto label_29;
                    }
                    default: {
                        throw new IllegalAccessException();
                    }
                }
            }
            catch(Throwable throwable0) {
                process1 = null;
                goto label_44;
            }
            try {
                la.a(("exec 0 end: " + process1));
                goto label_36;
            }
            catch(Throwable throwable1) {
                goto label_43;
            }
            try {
            label_29:
                la.a("exec 1 start");
                process1 = Tools.a(arr_s, qt.b());
            }
            catch(Throwable throwable0) {
                process1 = null;
                goto label_44;
            }
            try {
                la.a(("exec 1 end: " + process1));
            label_36:
                DataOutputStream dataOutputStream0 = new DataOutputStream(process1.getOutputStream());
                dataOutputStream0.writeBytes(Tools.n(s) + '\n');
                dataOutputStream0.flush();
                stringBuilder0.append("process started: " + v + '\n');
                process0 = process1;
                goto label_52;
            }
            catch(Throwable throwable1) {
            label_43:
                throwable0 = throwable1;
            }
        label_44:
            while(throwable0 != null) {
                stringBuilder0.append(throwable0.toString());
                stringBuilder0.append('\n');
                throwable0 = throwable0.getCause();
            }
            stringBuilder0.append('\n');
            stringBuilder0.append(qt.a(process1));
            process0 = process1;
        label_52:
            if(process0 != null) {
                break;
            }
            ++v;
        }
        la.a("tryRoot end");
        if(z) {
            qt.a = stringBuilder0.toString();
        }
        return process0;
    }

    private static String a() {
        ArrayList arrayList0 = new ArrayList(33);
        for(int v = 0; v < 11; ++v) {
            String s = new String[]{"/vendor/bin", "/system/bin", "/bin", "/data/local", "/data/local/bin", "/system/sd/bin", "/system/bin/failsafe", "/system/bin/bstk", "/su/bin", "/magisk/.core/bin", "/magisk/phh/bin"}[v];
            arrayList0.add(s);
            if(s.contains("/bin")) {
                arrayList0.add(s.replace("/bin", "/xbin"));
                arrayList0.add(s.replace("/bin", "/sbin"));
            }
        }
        return TextUtils.join(":", arrayList0);
    }

    public static String a(Process process0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(process0 != null) {
            stringBuilder0.append(qt.a("stdout", process0.getInputStream()));
            stringBuilder0.append(qt.a("stderr", process0.getErrorStream()));
            stringBuilder0.append("exit value: ");
            try {
                stringBuilder0.append(process0.exitValue());
            }
            catch(IllegalThreadStateException unused_ex) {
                stringBuilder0.append("already run");
            }
            stringBuilder0.append('\n');
            return stringBuilder0.toString();
        }
        stringBuilder0.append("process is null\n");
        return stringBuilder0.toString();
    }

    static String a(String s) [...] // 潜在的解密器

    public static String a(String s, int v) {
        String s1 = qt.a(s, v, null);
        qt.a = "";
        return s1;
    }

    public static String a(String s, int v, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        qt.b = 0;
        FutureTask futureTask0 = new FutureTask(new qu(s, s1, stringBuilder0));
        new hx(futureTask0, "runCmd: " + s).start();
        try {
            futureTask0.get(((long)v), TimeUnit.SECONDS);
        }
        catch(ExecutionException executionException0) {
            la.c(("cmd (" + s + ") expection"), executionException0);
            stringBuilder0.append("expection: ");
            stringBuilder0.append(executionException0.getMessage());
        }
        catch(TimeoutException timeoutException0) {
            la.a(("cmd (" + s + ") exit: timeout " + v), timeoutException0);
            stringBuilder0.append("timeout: ");
            stringBuilder0.append(v);
        }
        int v1 = qt.b;
        if(v1 > 0) {
            try {
                la.a(("Kill: " + v1));
                android.os.Process.killProcess(v1);
                la.a("Kill: ok");
            }
            catch(Throwable throwable0) {
                la.a("Failed kill", throwable0);
            }
        }
        qt.b = 0;
        return stringBuilder0.toString();
    }

    private static String a(String s, InputStream inputStream0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(s);
        stringBuilder0.append(": ");
        try {
            int v = inputStream0.available();
            if(v > 0) {
                byte[] arr_b = new byte[v];
                int v1 = inputStream0.read(arr_b);
                if(v1 > 0) {
                    stringBuilder0.append(new String(Arrays.copyOf(arr_b, v1)));
                }
            }
        }
        catch(IOException iOException0) {
            stringBuilder0.append(iOException0.toString());
        }
        stringBuilder0.append('\n');
        return stringBuilder0.toString();
    }

    public static Process b(String s) {
        return qt.a(s, null, false);
    }

    private static String[] b() {
        Map map0 = System.getenv();
        int v = map0.size();
        String s = (String)map0.get("PATH");
        if(s == null) {
            ++v;
        }
        String[] arr_s = new String[v];
        int v1 = 0;
        for(Object object0: map0.entrySet()) {
            String s1 = (String)((Map.Entry)object0).getKey();
            String s2 = (String)((Map.Entry)object0).getValue();
            arr_s[v1] = String.valueOf(s1) + '=' + ("PATH".equals(s1) ? String.valueOf(s2) + ':' + qt.a() : s2);
            ++v1;
        }
        if(s == null) {
            arr_s[v1] = "PATH=" + qt.a();
        }
        return arr_s;
    }
}

