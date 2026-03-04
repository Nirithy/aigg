package android.ext;

import android.a.c;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.fix.j;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class ty {
    @TargetApi(11)
    private static int a(SharedPreferences.Editor sharedPreferences$Editor0, Map map0) {
        int v1;
        int v = 0;
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Object object1 = map$Entry0.getValue();
            if(object1 instanceof Boolean) {
                sharedPreferences$Editor0.putBoolean(((String)map$Entry0.getKey()), ((Boolean)map$Entry0.getValue()).booleanValue());
                ++v;
            }
            if(object1 instanceof Float) {
                sharedPreferences$Editor0.putFloat(((String)map$Entry0.getKey()), ((float)(((Float)map$Entry0.getValue()))));
                ++v;
            }
            if(object1 instanceof Integer) {
                sharedPreferences$Editor0.putInt(((String)map$Entry0.getKey()), ((int)(((Integer)map$Entry0.getValue()))));
                ++v;
            }
            if(object1 instanceof Long) {
                sharedPreferences$Editor0.putLong(((String)map$Entry0.getKey()), ((long)(((Long)map$Entry0.getValue()))));
                ++v;
            }
            if(object1 instanceof String) {
                sharedPreferences$Editor0.putString(((String)map$Entry0.getKey()), ((String)map$Entry0.getValue()));
                v1 = v + 1;
            }
            else {
                v1 = v;
            }
            if(Build.VERSION.SDK_INT >= 11 && object1 instanceof Set) {
                sharedPreferences$Editor0.putStringSet(((String)map$Entry0.getKey()), ((Set)map$Entry0.getValue()));
                v = v1 + 1;
            }
            else {
                v = v1;
            }
        }
        return v;
    }

    public static InputStream a(String s, int v) {
        String[] arr_s = {"exec ls " + s, "exec dalvikvm -cp " + Tools.q() + ' ' + Ls.class.getName() + ' ' + s};
        if(v >= 2) {
            return null;
        }
        String s1 = arr_s[v];
        Process process0 = qt.b(s1);
        if(process0 == null) {
            la.b(("Failed run " + s1));
            return null;
        }
        return process0.getInputStream();
    }

    public static void a(bk bk0, boolean z) {
        j j0 = new j();
        bk0.g();
        String s = Tools.g();
        int v = bk0.e();
        HashMap hashMap0 = z ? new HashMap() : null;
        int v1 = 0;
        try {
            while(true) {
                int v2 = bk0.b();
                if(v2 < 0 || v2 > 0x400) {
                    la.c(("Bad pkg length: " + v2), new RuntimeException());
                    break;
                }
                if(v2 == 0) {
                    break;
                }
                int v3 = bk0.b();
                int v4 = bk0.b();
                String s1 = bk0.a(v2, null);
                String s2 = bk0.a(bk0.a(), null);
                if(z) {
                    hashMap0.put(s1, v4);
                }
                if(s.equals(s1)) {
                }
                else if(v3 <= 0) {
                    if(s1.equals("catch_.me_.if_.you_.can_")) {
                        j0.put(v / 9 * 0x3F0E + 1, new ud(s1, v3, s2));
                    }
                    String s3 = ty.d(s1);
                    for(int v5 = 33; v5 >= 0; --v5) {
                        if(new String[]{"df1e68bf2355bb69260b6efaa7fdacc1", "f63d4ea576f8d71e0963de6834e0c219", "b333d385ec3aeaaf7598031a42f99961", "f6d10cdcc825ab580f2fbb8ae2752990", "6c188a31fe500c3ada0914215e7df3b3", "4aa610afe8a9f409d98e62b4ed2ef780", "bbc0c87ac43ea5b61f59d6607a1eaf84", "70fb9cca0e11cb09250a11ba0c23b4c2", "b4d8929ffb0484d60369dd2c2e5c919d", "1517a1932503e400deef335e1d331593", "761cf7c032752696b26cd60ea3f3d74d", "1027157cbd6831cfebb80321570bb784", "8791855c8c65cb6a950f34ec0b093668", "a517cf7078e7e9b25ae975b4bdb2cc65", "b4ab3afbb70f23f600d048be0e8d49b2", "bd2173c6afb552fae3d9428756430123", "9bcf2de327544b17352830f9b004b229", "94d8ee3a7d26aa70f473e0ac8845b040", "d6683c02b361fed6c0ece0338921cf2b", "2cba6ddcf12910bc651455907da1fa00", "95760d2d26320be5d407e9823fd089ea", "db2aaa81ea92a69ae45642d0f5142c24", "6e513de086b0378f970968445a5da263", "60ee44a5be7a862f6615d5b68ca0d017", "0e41efb62a276c61f7b2253a1cb70c96", "3534ed8e94149e09012244b0053f387c", "7e146f369544a77f5bd3dcaa498a1e93", "5ff0619a03b5424a273491e365b6356a", "7abdd4c0904fe8f0a78424f971ff52f4", "4be2ea55d617fc0362440a93ae8a0bda", "25a4c4b1be1822ea6b990582e5038364", "b3ea34ef077e6fb86332e03b5321b28c", "ff748cbd537fd83894360f37ac9ccb03", "1353d43dff30877182f5d709e282d224"}[v5].equalsIgnoreCase(s3)) {
                            j0.put(35 - v5 + v / 9 * 0x3F0E, new ud(s1, v3, s2));
                            break;
                        }
                    }
                }
                else if(v3 <= 0x3F0E) {
                    j0.put((0x3F0E - v3) * (v / 9) + v1, new ud(s1, v3, s2));
                    ++v1;
                }
            }
        }
        catch(IOException iOException0) {
            la.c("???", iOException0);
            if(j0.size() == 0) {
                la.a("Un: what?");
                return;
            }
        }
        if(z) {
            qf.b = hashMap0;
        }
        boolean z1 = !ty.a();
        la.a(("Un: copy " + j0.size()));
        if(ty.b(j0)) {
            la.a("Un: restart?");
            i.a(i.c().setCustomTitle(Tools.d(0x7F070001)).setMessage(qk.a(0x7F0700DE)).setPositiveButton(qk.a(0x7F0700F2), new ib(1300, true)).setNegativeButton(qk.a(0x7F0700B9), new tz(j0)).setCancelable(false));  // string:app_name "GameGuardian"
        }
        else {
            la.a("Un: show");
            ty.a(j0);
        }
        if(z1 && ty.a()) {
            la.a("Un: faq");
            lh.a(Tools.e());
        }
    }

    static void a(j j0) {
        PackageInfo packageInfo0;
        for(int v = 0; v < j0.size(); ++v) {
            ud ud0 = (ud)j0.valueAt(v);
            if(ud0.b == 0x3F0E && !"catch_.me_.if_.you_.can_".equals(ud0.a) || !Tools.e(ud0.a)) {
                j0.removeAt(v);
                --v;
                la.a(("Un: ignore: " + ud0.a + ' ' + ud0.b));
            }
        }
        if(j0.size() == 0) {
            la.a("Un: empty");
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(qk.a(0x7F07009A));  // string:found_old_version "Found an old version of __app_name__. Do you want to uninstall 
                                                  // it?"
        for(int v1 = 0; v1 < j0.size(); ++v1) {
            ud ud1 = (ud)j0.valueAt(v1);
            stringBuilder0.append("\n\n");
            try {
                packageInfo0 = Tools.k(ud1.a);
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                la.c(("Package not found: " + ud1.a), packageManager$NameNotFoundException0);
                packageInfo0 = null;
            }
            if(packageInfo0 == null) {
                stringBuilder0.append(ud1.a);
                stringBuilder0.append(" - ");
                stringBuilder0.append(ud1.b);
            }
            else {
                stringBuilder0.append((packageInfo0.applicationInfo == null ? null : Tools.a(packageInfo0.applicationInfo)));
                stringBuilder0.append(" (");
                stringBuilder0.append(ud1.a);
                stringBuilder0.append(") - ");
                stringBuilder0.append((ud1.c.length() <= 0 ? packageInfo0.versionName : ud1.c));
                stringBuilder0.append(" (");
                stringBuilder0.append((ud1.b <= 0 ? packageInfo0.versionCode : ud1.b));
                stringBuilder0.append(')');
            }
        }
        la.a(("Un: alert: " + j0.size()));
        String s = stringBuilder0.toString();
        int v2 = s.hashCode() ^ 0x3F0E;
        if(v2 == Tools.s().getInt("skip-old", 0)) {
            la.a("Un: skip");
            return;
        }
        ua ua0 = new ua(v2, j0);
        i.a(i.c().setCustomTitle(Tools.d(0x7F070099)).setMessage(s).setCancelable(false).setPositiveButton(qk.a(0x7F07009B), ua0).setNeutralButton(qk.a(0x7F0700B9), ua0).setNegativeButton(qk.a(0x7F07009C), null));  // string:old_version "Old version"
    }

    private static void a(File file0, File file1, String s) {
        int v2;
        String s1;
        int v = 0;
        while(true) {
            if(v >= 10) {
                return;
            }
            InputStream inputStream0 = ty.a(file0.getAbsolutePath(), v);
            if(inputStream0 != null) {
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0));
                int v1 = 0;
                while(true) {
                    try {
                    label_7:
                        s1 = bufferedReader0.readLine();
                        if(s1 == null) {
                            bufferedReader0.close();
                            goto label_60;
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_59;
                    }
                    try {
                        v2 = v1 + 1;
                        if(!s1.endsWith("_preferences.xml")) {
                            if(s1.endsWith(".xml")) {
                                File file2 = s1.startsWith("/") ? new File(s1) : new File(file0, s1);
                                String s2 = file2.getName();
                                if(!s2.equals(s)) {
                                    if(!s2.equals("DefaultStorage.xml")) {
                                        File file3 = new File(file1, file2.getName());
                                        file1.mkdirs();
                                        if(!file3.exists()) {
                                            int v3 = 0;
                                            while(v3 < 10) {
                                                InputStream inputStream1 = ty.b(file2.getAbsolutePath(), v3);
                                                if(inputStream1 != null) {
                                                    try {
                                                        int v4 = 0;
                                                        byte[] arr_b = new byte[0x2000];
                                                        FileOutputStream fileOutputStream0 = new FileOutputStream(file3);
                                                        try {
                                                            int v6;
                                                            while((v6 = inputStream1.read(arr_b)) != -1) {
                                                                fileOutputStream0.write(arr_b, 0, v6);
                                                                v4 += v6;
                                                            }
                                                        }
                                                        finally {
                                                            fileOutputStream0.close();
                                                        }
                                                        inputStream1.close();
                                                    }
                                                    catch(IOException iOException0) {
                                                        la.b(("Failed read data from " + file2), iOException0);
                                                    }
                                                    if(v4 > 0) {
                                                        v1 = v2;
                                                        goto label_7;
                                                    }
                                                }
                                                ++v3;
                                            }
                                        }
                                        v1 = v2;
                                        goto label_7;
                                    }
                                    v1 = v2;
                                    goto label_7;
                                }
                            }
                            else {
                                v1 = v2;
                                goto label_7;
                            }
                        }
                        v1 = v2;
                        goto label_7;
                    }
                    catch(Throwable throwable0) {
                    }
                    break;
                }
                v1 = v2;
            label_59:
                la.b(("Failed read list from " + file0), throwable0);
            label_60:
                if(v1 > 0) {
                    return;
                }
            }
            ++v;
        }
    }

    static void a(String s) {
        Intent[] arr_intent = jp.a(s);
        int v = 0;
        while(v < arr_intent.length) {
            Intent intent0 = arr_intent[v];
            try {
                Tools.e().startActivity(intent0);
                return;
            }
            catch(Throwable throwable0) {
                la.c("intent fail", throwable0);
                ++v;
            }
        }
    }

    public static void a(String s, Runnable runnable0) {
        if(!Tools.e(s)) {
            la.a((runnable0 + ": 50"));
            if(runnable0 != null) {
                runnable0.run();
            }
            return;
        }
        if(runnable0 != null) {
            la.a((runnable0 + ": 60"));
            if(Build.VERSION.SDK_INT >= 21) {
                try {
                    qt.a(("exec pm uninstall --user -1 " + s), 45);
                }
                catch(Throwable throwable0) {
                    la.c("run cmd fail", throwable0);
                }
            }
            la.a((runnable0 + ": 70"));
            if(Build.VERSION.SDK_INT < 21 || Tools.e(s)) {
                try {
                    qt.a(("exec pm uninstall " + s), 45);
                }
                catch(Throwable throwable1) {
                    la.c("run cmd fail", throwable1);
                }
            }
            la.a((runnable0 + ": 80"));
            if(Tools.e(s)) {
                i.a(i.a(ar.f).setMessage(qk.a(0x7F0702A6)).setPositiveButton(qk.a(0x7F07009D), new ub(runnable0, s)).create(), runnable0, true);  // string:need_uninstall "You need to uninstall the installer, otherwise you will have 
                                                                                                                                                  // 4 icons, not 2. Also games will detect it."
                return;
            }
            la.a((runnable0 + ": 110"));
            runnable0.run();
            return;
        }
        ty.a(s);
    }

    public static boolean a() {
        return Tools.s().getBoolean("installed", false);
    }

    private static boolean a(String s, String s1, File file0, Map map0, SharedPreferences.Editor sharedPreferences$Editor0, String s2, boolean z) {
        int v = 0;
        String s3 = s.replace(s1, s2);
        if(z || !s.equals(s3)) {
            if(!z) {
                ty.a(new File(s3).getParentFile(), file0.getParentFile(), "null_preferences".replace(s1, s2));
            }
            HashMap hashMap0 = z ? null : ty.c(s3);
            if(hashMap0 != null) {
                goto label_9;
            }
            hashMap0 = ty.c(s.replace("null_preferences", "DefaultStorage").replace(s1, s2));
            if(hashMap0 != null) {
            label_9:
                for(Object object0: hashMap0.entrySet()) {
                    if(!map0.containsKey(((Map.Entry)object0).getKey())) {
                        ++v;
                    }
                }
                la.a(("Copy: " + ty.a(sharedPreferences$Editor0, hashMap0) + " from " + hashMap0.size() + " new " + v));
                return true;
            }
        }
        return false;
    }

    public static File b(String s) {
        File file0;
        Context context0 = MainService.context;
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                file0 = (File)context0.getClass().getMethod("getSharedPreferencesPath", String.class).invoke(context0, s);
            }
            catch(Throwable throwable0) {
                try {
                    la.b("Failed call getSharedPreferencesPath", throwable0);
                    file0 = null;
                    return file0 == null ? ((File)context0.getClass().getMethod("getSharedPrefsFile", String.class).invoke(context0, s)) : file0;
                }
                catch(Throwable throwable1) {
                    la.b("Failed call getSharedPrefsFile", throwable1);
                    return new File(Tools.i(), "../shared_prefs/" + s + ".xml");
                }
            }
        }
        else {
            file0 = null;
            return file0 == null ? ((File)context0.getClass().getMethod("getSharedPrefsFile", String.class).invoke(context0, s)) : file0;
        }
        return file0 == null ? ((File)context0.getClass().getMethod("getSharedPrefsFile", String.class).invoke(context0, s)) : file0;
    }

    public static InputStream b(String s, int v) {
        String s2;
        String s1 = Tools.r() + "/tmp.file.tmp";
        File file0 = Tools.e().getExternalFilesDir(null);
        if(file0 == null) {
            s2 = null;
        }
        else {
            file0.mkdirs();
            s2 = file0.exists() ? file0.getAbsolutePath() + "/tmp.file.tmp" : null;
        }
        if(s2 == null) {
            s2 = s1;
        }
        String[][] arr2_s = {new String[]{"exec cat " + s, null}, new String[]{"exec dalvikvm -cp " + Tools.q() + ' ' + Cat.class.getName() + ' ' + s, null}, new String[]{"exec cp " + s + ' ' + s2, s2}, new String[]{"exec cp " + s + ' ' + s1, s1}, new String[]{"exec cp " + s + ' ' + s2.replace("/emulated/0", "/emulated/legacy"), s2}};
        if(v >= 5) {
            return null;
        }
        String[] arr_s = arr2_s[v];
        Process process0 = qt.b(arr_s[0]);
        if(process0 == null) {
            la.b(("Failed run " + Arrays.toString(arr_s)));
            return null;
        }
        try {
            if(arr_s[1] == null) {
                return process0.getInputStream();
            }
            try {
                process0.waitFor();
            }
            catch(InterruptedException interruptedException0) {
                la.b(("Wait fail: " + arr_s[0]), interruptedException0);
            }
            return new uc(arr_s[1], arr_s[1]);
        }
        catch(IOException iOException0) {
            la.b("Failed read xml", iOException0);
            return null;
        }
    }

    private static boolean b(j j0) {
        boolean z;
        File file0 = ty.b("null_preferences");
        if(ty.a()) {
            return false;
        }
        SharedPreferences sharedPreferences0 = Tools.s();
        HashMap hashMap0 = new HashMap(sharedPreferences0.getAll());
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        String s = file0.getAbsolutePath();
        String s1 = Tools.g();
        File file1 = ty.b("DefaultStorage");
        if(file1.exists()) {
            z = ty.a(s, s1, file0, hashMap0, sharedPreferences$Editor0, s1, true);
            file1.delete();
        }
        else {
            z = false;
        }
        int v = j0.size() - 1;
        boolean z1;
        for(z1 = z; v >= 0; z1 = z2) {
            boolean z2 = ty.a(s, s1, file0, hashMap0, sharedPreferences$Editor0, ((ud)j0.valueAt(v)).a, false) ? true : z1;
            --v;
        }
        la.a(("New: " + ty.a(sharedPreferences$Editor0, hashMap0) + " from " + hashMap0.size()));
        sharedPreferences$Editor0.putBoolean("installed", true).commit();
        return z1;
    }

    public static HashMap c(String s) {
        HashMap hashMap2;
        HashMap hashMap1;
        HashMap hashMap0;
        int v = 0;
        while(true) {
            if(v >= 10) {
                hashMap0 = null;
                goto label_27;
            }
            try {
                InputStream inputStream0 = ty.b(s, v);
                if(inputStream0 != null) {
                    ue ue0 = new ue(inputStream0);
                    try {
                        hashMap1 = c.a(ue0);
                    }
                    catch(Throwable throwable0) {
                        la.b(("Fail: " + s), throwable0);
                        la.b(("Last data: " + ue0.a()));
                        hashMap1 = null;
                    }
                    try {
                        ue0.close();
                        hashMap2 = hashMap1;
                        goto label_25;
                    }
                    catch(IOException iOException1) {
                        iOException0 = iOException1;
                        goto label_23;
                    }
                }
                ++v;
                continue;
            }
            catch(IOException iOException0) {
            }
            break;
        }
        hashMap1 = null;
    label_23:
        la.b("Failed read xml", iOException0);
        hashMap2 = hashMap1;
    label_25:
        if(hashMap2 == null) {
            ++v;
            continue;
        }
        hashMap0 = hashMap2;
    label_27:
        if(hashMap0 == null) {
            try {
                qt.a(("exec ls -l " + s), 10);
            }
            catch(Throwable throwable1) {
                la.b("Failed check xml", throwable1);
            }
            return null;
        }
        return hashMap0;
    }

    private static final String d(String s) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
            messageDigest0.update(s.getBytes());
            return Tools.a(messageDigest0.digest());
        }
        catch(Throwable throwable0) {
            la.b("Failed check old versions", throwable0);
            return null;
        }
    }
}

