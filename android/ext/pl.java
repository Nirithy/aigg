package android.ext;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pl {
    final Context a;
    private StringBuilder b;
    private int c;
    private Map d;

    public pl() {
        this.a = ar.d;
        this.b = new StringBuilder();
        this.c = -1;
        this.d = new HashMap();
        this.d.put("android.permission.SYSTEM_ALERT_WINDOW", 24);
    }

    @TargetApi(19)
    private int a(int v) {
        try {
            ApplicationInfo applicationInfo0 = this.a.getApplicationInfo();
            AppOpsManager appOpsManager0 = (AppOpsManager)this.a.getSystemService("appops");
            return (int)(((Integer)AppOpsManager.class.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager0, v, applicationInfo0.uid, applicationInfo0.packageName)));
        }
        catch(Throwable throwable0) {
            la.a(("MIUI-checkOp(" + v + ") failed"), throwable0);
            this.b.append("\nMIUI-checkOp(" + v + ") failed:\n");
            this.b.append(la.b(throwable0));
            return -1;
        }
    }

    private boolean a(String s) {
        boolean z = true;
        this.b.append("\nMIUI-checkPermission ");
        this.b.append(s);
        this.b.append(" - ");
        Integer integer0 = (Integer)this.d.get(s);
        if(integer0 == null) {
            this.b.append("unknown - ");
        }
        else if(((int)integer0) != 24 || this.c != 5) {
            try {
                if(this.a(((int)integer0)) != 0) {
                    z = false;
                }
            }
            catch(Throwable throwable0) {
                la.a("MIUI-checkPermission failed", throwable0);
                this.b.append("failed:\n");
                this.b.append(la.b(throwable0));
                this.b.append('\n');
                z = false;
            }
        }
        else {
            z = (this.a.getApplicationInfo().flags & 0x8000000) == 0x8000000;
        }
        this.b.append(z);
        return z;
    }

    public void a() {
        if(Build.VERSION.SDK_INT < 16) {
            return;
        }
        new gr(new pm(this), "runCheck").start();
    }

    @TargetApi(19)
    private void b(String s) {
        this.b.append("\nMIUI-fixPermission ");
        this.b.append(s);
        this.b.append(" - ");
        Integer integer0 = (Integer)this.d.get(s);
        if(integer0 == null) {
            this.b.append("unknown");
            return;
        }
        if(((int)integer0) == 24 && this.c == 5) {
            try {
                Tools.m().setApplicationEnabledSetting(Tools.g(), 0x8000000, 0x8000000);
                this.b.append("success 1");
            }
            catch(Throwable throwable0) {
                la.a("MIUI-fixPermission failed", throwable0);
                this.b.append("failed 1:\n");
                this.b.append(la.b(throwable0));
                this.b.append('\n');
            }
        }
        try {
            ApplicationInfo applicationInfo0 = this.a.getApplicationInfo();
            AppOpsManager.class.getMethod("setMode", Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE).invoke(((AppOpsManager)this.a.getSystemService("appops")), integer0, applicationInfo0.uid, applicationInfo0.packageName, 0);
            this.b.append("success 2");
        }
        catch(Throwable throwable1) {
            la.a("MIUI-fixPermission failed", throwable1);
            this.b.append("failed 2:\n");
            this.b.append(la.b(throwable1));
            this.b.append('\n');
        }
    }

    String b() [...] // 潜在的解密器

    public void c() {
        try {
            this.d();
            if(this.c == -1 || (Config.c & 2L) != 0L) {
                return;
            }
            if(!this.a("android.permission.SYSTEM_ALERT_WINDOW")) {
                this.b("android.permission.SYSTEM_ALERT_WINDOW");
                AlertDialog.Builder alertDialog$Builder0 = i.a(this.a).setNeutralButton(qk.a(0x7F0700B9), lh.a(2L));  // string:skip "Ignore"
                if(this.a("android.permission.SYSTEM_ALERT_WINDOW")) {
                    alertDialog$Builder0.setMessage(qk.a(0x7F0700C6)).setPositiveButton(qk.a(0x7F0700F2), new ib(1200, true)).setNegativeButton(qk.a(0x7F07009C), null);  // string:miui_restart "__app_name__ needs to be restarted in order to apply security 
                                                                                                                                                                          // permissions."
                }
                else {
                    bq.a(alertDialog$Builder0);
                    alertDialog$Builder0.setPositiveButton(qk.a(0x7F070164), new pn(this));  // string:fix_it "Fix it"
                }
                rx.a(new po(this, alertDialog$Builder0));
            }
        }
        catch(Throwable throwable0) {
            la.c("MIUI-check", throwable0);
            this.b.append("\nMIUI-check failed:\n");
            this.b.append(la.b(throwable0));
        }
        this.f();
    }

    private void d() {
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(Tools.a(new String[]{"getprop"}).getInputStream()));
            this.b.append("\ngetprop:\n");
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                if(s.contains("ro.product.device") && s.contains("_sprout")) {
                    this.c = -1;
                    break;
                }
                if(!s.contains("fpc.fp.miui.") && !s.contains("ro.ril.miui.imei")) {
                    if(s.contains("miui") || s.contains("MIUI")) {
                        la.a(("MIUI found: " + s));
                        this.b.append(s);
                        this.b.append('\n');
                        if(this.c == -1) {
                            this.c = 0;
                        }
                    }
                    if(s.contains("ro.miui.ui.version.name")) {
                        if(s.contains("V5")) {
                            this.c = 5;
                        }
                        if(s.contains("V6")) {
                            this.c = 6;
                        }
                    }
                }
            }
            bufferedReader0.close();
        }
        catch(Throwable throwable0) {
            la.c("MIUI-detect", throwable0);
            this.b.append("\nMIUI-detect failed:\n");
            this.b.append(la.b(throwable0));
        }
    }

    private int e() [...] // 潜在的解密器

    private void f() {
        String s = this.b.toString();
        this.b = new StringBuilder();
        this.b.append("MIUI\nGG: ");
        this.b.append(101.099998f);
        this.b.append(" [");
        this.b.append(0x3F0E);
        this.b.append("]\nAndroid: ");
        this.b.append(Build.VERSION.RELEASE);
        this.b.append("\nSDK: ");
        this.b.append(Build.VERSION.SDK_INT);
        this.b.append("\nappInfo.flags: ");
        this.b.append("0x" + ts.a(8, ((long)this.a.getApplicationInfo().flags)));
        this.b.append("\ncheckOp(OP_SYSTEM_ALERT_WINDOW): ");
        this.b.append(this.a(24));
        this.b.append(s);
        String[] arr_s = this.b.toString().split("[\\r\\n]+");
        for(int v = 0; v < arr_s.length; ++v) {
            la.a(arr_s[v]);
        }
    }
}

