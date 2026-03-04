package android.ext;

import android.c.b;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ca {
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final boolean e;
    private static volatile String f;

    static {
        ca.f = ";;";
        ca.e = ca.d();
        ca.c = "bugged-packages";
        ca.d = "bugged-uids";
        ca.a = "native_crash.txt";
        ca.b = " _QAZ_WSX_EDC_RFV_TGB_YHN_UJM_ ";
    }

    public static void a(boolean z) {
        if(ca.e && z) {
            try {
                la.a(("CNC[" + ((char)(ca.e ? 49 : 0x30)) + "] - x"));
                if(ca.e) {
                    ca.h().delete();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        else {
            return;
        }
        la.c("Failed x CNC", throwable0);
    }

    // 去混淆评级： 中等(50)
    public static boolean a(String s) {
        return ca.e ? ";;".contains(";" + s + ';') : false;
    }

    public static boolean a(String s, String s1) {
        if(ca.e && (!y.d.equals(s) && (!s.startsWith("uid:") || !s.equals("uid:" + Process.myUid())))) {
            try {
                la.a(("CNC[" + ((char)(ca.e ? 49 : 0x30)) + "] - n: " + s1 + "; " + s));
                if(ca.e) {
                    FileOutputStream fileOutputStream0 = new FileOutputStream(ca.h());
                    fileOutputStream0.write(s.getBytes());
                    fileOutputStream0.write(" _QAZ_WSX_EDC_RFV_TGB_YHN_UJM_ ".getBytes());
                    fileOutputStream0.write((String.valueOf(s1) + '\n' + gs.f()).getBytes());
                    fileOutputStream0.flush();
                    fileOutputStream0.close();
                }
            }
            catch(Throwable throwable0) {
                la.c("Failed n CNC", throwable0);
            }
            return true;
        }
        return false;
    }

    public static String[] a() {
        if(ca.e) {
            String s = ca.e();
            if(s.length() > 0) {
                la.a(("BUGGED_PACKAGES: " + s));
                return s.split(";");
            }
        }
        return b.a;
    }

    private static String b(String s) {
        ArrayList arrayList0 = new ArrayList(new HashSet(Arrays.asList(s.split(";"))));
        return TextUtils.join(";", arrayList0.toArray(new String[arrayList0.size()]));
    }

    public static String[] b() {
        if(ca.e) {
            String s = ca.f();
            if(s.length() > 0) {
                la.a(("BUGGED_UIDS: " + s));
                return s.split(";");
            }
        }
        return b.a;
    }

    public static void c() {
        la.a("lLC - 1");
        ca.e();
        ca.f();
        String[] arr_s = ca.g();
        if(arr_s != null) {
            for(int v = 0; v < arr_s.length; v += 2) {
                String s = arr_s[v];
                if(s != null) {
                    la.c(("Bad package: \'" + s + "\' " + arr_s[v + 1]));
                    String s1 = "bugged-packages";
                    if(s.contains("uid:")) {
                        s1 = "bugged-uids";
                        s = s.split(":", -1)[1];
                    }
                    SharedPreferences sharedPreferences0 = Tools.s();
                    String s2 = sharedPreferences0.getString(s1, "");
                    if(s2 != null && s2.length() != 0) {
                        s = (";" + s2 + ';').contains(";" + s + ';') ? s2 : String.valueOf(s2) + ';' + s;
                    }
                    sharedPreferences0.edit().putString(s1, ca.b(s)).commit();
                }
            }
        }
        ca.e();
        ca.f();
        la.a("lLC - 0");
    }

    private static boolean d() {
        boolean z2;
        int v2;
        int v;
        boolean z = false;
        try {
            File file0 = new File("/system/lib/libandroidfw.so");
            if(file0.exists()) {
                FileInputStream fileInputStream0 = new FileInputStream(file0);
                byte[] arr_b = "_ZN7android12AssetManager10getPkgNameEPKc".getBytes();
                byte[] arr_b1 = new byte[0x2000];
                v = 0;
                boolean z1 = false;
                while(true) {
                    int v1 = fileInputStream0.read(arr_b1, v, 0x2000 - v);
                    if(v1 > 0) {
                        v2 = v + v1;
                        if(v2 >= arr_b.length) {
                            int v3 = v2 - arr_b.length + 1;
                            int v4 = 0;
                            while(v4 < v3) {
                                int v5 = 0;
                            label_16:
                                if(v5 >= arr_b.length) {
                                    z2 = true;
                                }
                                else if(arr_b1[v4 + v5] == arr_b[v5]) {
                                    ++v5;
                                    goto label_16;
                                }
                                else {
                                    z2 = false;
                                }
                                if(z2) {
                                    z1 = true;
                                    break;
                                }
                                ++v4;
                            }
                            if(z1) {
                                z = true;
                            }
                            else {
                                goto label_32;
                            }
                        }
                        else {
                            v = v2;
                            continue;
                        }
                    }
                    fileInputStream0.close();
                    break;
                label_32:
                    int v6 = arr_b.length - 1;
                    for(int v7 = 0; v7 < v6; ++v7) {
                        arr_b1[v7] = arr_b1[v2 - v6 + v7];
                    }
                    v = v6;
                }
            }
        }
        catch(Throwable throwable0) {
            la.b("Failed detect CM13", throwable0);
        }
        la.a(("CM13: " + z));
        return z;
    }

    private static String e() {
        String s = ca.b(Tools.s().getString("bugged-packages", ""));
        if(s.length() > 0) {
            ca.f = ";" + s + ';';
        }
        return s;
    }

    // 去混淆评级： 低(20)
    private static String f() {
        return ca.b(Tools.s().getString("bugged-uids", ""));
    }

    private static String[] g() {
        String[] arr_s = null;
        File file0 = ca.h().getParentFile();
        if(file0 != null) {
            File[] arr_file = file0.listFiles();
            if(arr_file != null) {
                arr_s = new String[arr_file.length * 2];
                for(int v = 0; v < arr_file.length; ++v) {
                    File file1 = arr_file[v];
                    if(file1 != null && file1.getName().endsWith("native_crash.txt")) {
                        try {
                            FileInputStream fileInputStream0 = new FileInputStream(file1);
                            byte[] arr_b = new byte[Math.min(((int)file1.length()) + 0x2000, 0x19000)];
                            int v1 = fileInputStream0.read(arr_b);
                            fileInputStream0.close();
                            if(v1 > 0) {
                                String[] arr_s1 = new String(arr_b, 0, v1).split(" _QAZ_WSX_EDC_RFV_TGB_YHN_UJM_ ", 2);
                                if(arr_s1.length == 2) {
                                    arr_s[v * 2] = arr_s1[0];
                                    arr_s[v * 2 + 1] = arr_s1[1];
                                }
                            }
                        }
                        catch(Throwable throwable0) {
                            la.c("Failed read native crash", throwable0);
                        }
                        file1.delete();
                    }
                }
            }
        }
        return arr_s;
    }

    private static File h() {
        File file0 = new File(Tools.l(), "1054native_crash.txt");
        try {
            file0.getParentFile().mkdirs();
        }
        catch(Throwable throwable0) {
            la.c("Failed mkdirs CNC", throwable0);
        }
        return file0;
    }
}

