package android.ext;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.fix.k;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import catch_.me_.if_.you_.can_.Instrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class lh {
    public static volatile Boolean a;
    public static volatile boolean b;
    static volatile int c;
    static volatile boolean d;

    static {
        lh.a = null;
        lh.b = false;
        lh.c = 0;
        lh.d = false;
    }

    static DialogInterface.OnClickListener a(long v) {
        return new ly(v);
    }

    static Runnable a(Context context0, String s, long v, boolean z) {
        return new lz(context0, s, v);
    }

    static void a() {
        ar.d.a(1);
        jp.c();
    }

    static void a(byte b) {
        int v = 0;
        File file0 = new File(Tools.l(), "instr.check");
        if(b == 0) {
            try {
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                try {
                    fileOutputStream0.write("16142".getBytes());
                }
                finally {
                    fileOutputStream0.close();
                }
            }
            catch(Throwable throwable0) {
                la.c("Fail set instr file", throwable0);
            }
            return;
        }
        if(b == 1) {
            if(!file0.exists()) {
                la.c(("No instr file: " + file0));
            }
            file0.delete();
            return;
        }
        if(file0.exists()) {
            try {
                FileInputStream fileInputStream0 = new FileInputStream(file0);
                try {
                    byte[] arr_b = new byte[12];
                    int v3 = fileInputStream0.read(arr_b);
                    if(v3 > 0) {
                        v = Integer.parseInt(new String(arr_b, 0, v3));
                    }
                    if(v == 0x3F0E && Config.z == 0) {
                        Config.a(0x7F0B00BC).d = 1;  // id:config_context_source
                        Config.c();
                    }
                }
                finally {
                    fileInputStream0.close();
                }
            }
            catch(Throwable throwable1) {
                la.c("Fail get instr file", throwable1);
            }
            file0.delete();
            return;
        }
        try {
        }
        catch(Throwable throwable0) {
            la.c("Fail set instr file", throwable0);
        }
    }

    static void a(int v, String s) {
        la.a(("main " + v + ':' + Process.myUid() + ": " + bi.a() + ' ' + (ar.d == null ? null : Boolean.valueOf(ar.d.g)) + ' ' + bi.b + ' ' + bj.a + ' ' + s));
    }

    public static void a(Context context0) {
        rx.a(new md(context0));
    }

    private static void a(boolean z) {
        int v = 0;
        if((Config.c & 0x40L) != 0L || (Config.B & 0x2000) != 0) {
            return;
        }
        File file0 = new File(Tools.l(), "FC.txt");
        if(z) {
            file0.delete();
            return;
        }
        if(file0.exists()) {
            try {
                FileInputStream fileInputStream0 = new FileInputStream(file0);
                try {
                    byte[] arr_b = new byte[12];
                    int v2 = fileInputStream0.read(arr_b);
                    if(v2 > 0) {
                        v = Integer.parseInt(new String(arr_b, 0, v2));
                    }
                    if(v == 0x3F0E) {
                        i.c(i.c().setMessage(qk.a(0x7F07007C)).setPositiveButton(qk.a(0x7F070164), new lo()).setNegativeButton(qk.a(0x7F0700B9), lh.a(0x40L)).setNeutralButton(qk.a(0x7F07012B), new lq()).create());  // string:force_close_ "__force_close__\n\n__force_close_2__"
                    }
                }
                finally {
                    fileInputStream0.close();
                }
            }
            catch(Throwable throwable0) {
                la.c("Fail get FC file", throwable0);
            }
            file0.delete();
        }
        try {
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            try {
                fileOutputStream0.write("16142".getBytes());
            }
            finally {
                fileOutputStream0.close();
            }
        }
        catch(Throwable throwable1) {
            la.c("Fail set FC file", throwable1);
        }
    }

    public static boolean a(Context context0, DialogInterface.OnDismissListener dialogInterface$OnDismissListener0) {
        if(!Config.C) {
            return true;
        }
        if(context0 == null) {
            context0 = Tools.e();
        }
        AlertDialog alertDialog0 = i.a(context0).setMessage(qk.a(0x7F070287)).setNegativeButton(qk.a(0x7F07009D), null).create();  // string:need_root_mode "This feature requires root access. Currently __app_name__ 
                                                                                                                                   // is running in a virtual environment mode without root access."
        if(dialogInterface$OnDismissListener0 != null) {
            i.a(alertDialog0, dialogInterface$OnDismissListener0);
        }
        i.c(alertDialog0);
        return false;
    }

    static void b() {
        li li0 = new li();
        i.a(i.a(ar.f).setTitle(qk.a(0x7F0702D7)).setCancelable(false).setItems(new String[]{qk.a(0x7F07023C), qk.a(0x7F0702D8), qk.a(0x7F0702D9)}, new lv(li0)).create(), li0, false);  // string:install_mode "Install mode"
    }

    public static void c() {
        rx.a(new lw());
    }

    static void d() {
        Context context0;
        Context context1;
        try {
            switch(Config.z) {
                case 2: {
                    context0 = ar.d.createPackageContext("catch_.me_.if_.you_.can_", 3);
                    goto label_14;
                }
                case 3: {
                    context0 = ar.e;
                    goto label_14;
                }
                case 4: {
                    context1 = ar.d.getBaseContext();
                    break;
                }
                default: {
                    context0 = null;
                    goto label_14;
                }
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            context0 = null;
            goto label_14;
        }
        context0 = context1;
    label_14:
        la.a(("setContext: " + Config.z + ' ' + context0));
        if(context0 != null) {
            try {
                ((android.fix.i)k.a(android.fix.i.from(context0))).inflate(0x7F04001D, null);  // layout:service_dialog
            }
            catch(Throwable throwable1) {
                la.b(("Failed use context: " + context0), throwable1);
                context0 = null;
            }
        }
        if(context0 != null) {
            Tools.e(context0);
            MainService.context = ri.a(context0);
            lh.e();
            lh.i();
            return;
        }
        bj.d = true;
        if(!lh.h()) {
            Tools.b((Tools.c(0x7F0702E8) + ": " + qk.a(0x7F07005E)));  // string:could_not_use "Could not use:"
            ar.d.c();
        }
    }

    static void e() {
        if(Config.z == 1) {
            return;
        }
        if((Config.B & 0x100) != 0) {
            lh.h();
            return;
        }
        lh.v();
    }

    static void f() {
        if(Tools.e("com.chaozhuo.permission.controller") && (Config.c & 4L) == 0L) {
            String s = qk.a(0x7F070235) + "\n\n" + "http://gameguardian.net/forum/gallery/image/294-how-to-run-in-phoenixos-gameguardian/";  // string:need_allow_background "On this firmware, you must allow working __app_name__ 
                                                                                                                                             // in the background, in the system settings."
            rx.a(lh.a(ar.f, s, 4L, true));
        }
    }

    public static boolean g() {
        return lh.a(null, null);
    }

    static boolean h() {
        boolean z = false;
        try {
            bj.b = true;
            String s = Tools.g();
            ComponentName componentName0 = ar.f.startService(new Intent().setClassName(s, "catch_.me_.if_.you_.can_.AnalyticsService"));
            if(componentName0 != null) {
                z = true;
            }
            lh.a(10, (componentName0 == null ? null : componentName0.toString() + ' ' + componentName0.toShortString()));
        }
        catch(Throwable throwable0) {
            la.c("Failed load Service", throwable0);
        }
        return z;
    }

    public static void i() {
        ar.d.a(2);
        if(lh.d) {
            return;
        }
        lh.d = true;
        gs.e();
        la.d(("GG started: " + 101.099998f + " (" + 0x3F0E + ") on " + gs.d()));
        new ig(false);
        new qx(0L, 0L, 0);
        ar.d.j();
        bq.e();
        bf.a();
        iw.a();
        new pl().a();
        lh.w();
        ho.c();
        lh.a(5, null);
        lh.q();
        lh.t();
        lh.u();
        lh.r();
        lh.s();
        lh.x();
        lh.a(false);
        kx.a();
        ConfigListAdapter.a(3);
    }

    public static void j() {
        boolean z = false;
        la.a("Main: exit");
        lh.b = true;
        if(MainService.instance != null) {
            try {
                MainService.instance.g(true);
                MainService.instance.R();
            }
            catch(Throwable throwable0) {
                la.b("Exception on exit", throwable0);
            }
        }
        lg.a("AndroidService", "exit: 1");
        new File(Tools.l(), "sel.txt").delete();
        lh.a(true);
        lg.a("AndroidService", "exit: 2");
        try {
            la.a();
        }
        catch(Throwable throwable1) {
            lg.c("AndroidService", "OnExit", throwable1);
        }
        lg.a("AndroidService", "exit: 3");
        boolean z1 = bj.a != null;
        lj lj0 = new lj();
        lg.a("AndroidService", "wait 1: " + z1);
        if(z1) {
            bj.c = lj0;
            bj.a.a();
        }
        if(lh.v() || z1) {
            z = true;
        }
        lg.a("AndroidService", "wait 2: " + z);
        if(!z) {
            lh.k();
            return;
        }
        if(bj.c == null) {
            bj.c = lj0;
        }
        rx.a().postDelayed(lj0, 3000L);
    }

    static void k() {
        try {
            lh.n();
        }
        catch(Throwable throwable0) {
            lg.c("AndroidService", "OnExit", throwable0);
        }
        lg.a("AndroidService", "exit: 4");
        try {
            rx.d();
        }
        catch(Throwable throwable1) {
            lg.c("AndroidService", "OnExit", throwable1);
        }
        lg.a("AndroidService", "exit: 5");
        try {
            bi.b();
        }
        catch(Throwable throwable2) {
            lg.c("AndroidService", "OnExit", throwable2);
        }
        lg.a("AndroidService", "exit: 6");
        File file0 = new File(Tools.h(), "skipFinalization");
        lg.a("AndroidService", "exit: 7");
        if(!file0.exists()) {
            lg.a("AndroidService", "exit: 8");
            try {
                file0.createNewFile();
            }
            catch(Throwable throwable3) {
                lg.c("AndroidService", "OnExit", throwable3);
            }
            lg.a("AndroidService", "exit: 9");
            try {
                System.runFinalization();
            }
            catch(Throwable throwable4) {
                lg.c("AndroidService", "OnExit", throwable4);
            }
            lg.a("AndroidService", "exit: 10");
            try {
                file0.delete();
            }
            catch(Throwable throwable5) {
                lg.c("AndroidService", "OnExit", throwable5);
            }
        }
        lg.a("AndroidService", "exit: 11");
        try {
            qt.a(("exec am force-stop " + Tools.g()), 45);
        }
        catch(Throwable throwable6) {
            lg.c("AndroidService", "OnExit", throwable6);
        }
        lg.a("AndroidService", "exit: 12");
        try {
            qt.a(("exec am kill " + Tools.g()), 45);
        }
        catch(Throwable throwable7) {
            lg.c("AndroidService", "OnExit", throwable7);
        }
        lg.a("AndroidService", "exit: 13");
        lh.l();
    }

    public static void l() {
        lh.v();
        lg.a("AndroidService", "Main: die");
        try {
            System.exit(0);
        }
        catch(Throwable throwable0) {
            lg.c("AndroidService", "OnExit", throwable0);
        }
        lg.a("AndroidService", "exit: 14");
        try {
            Runtime.getRuntime().halt(0);
        }
        catch(Throwable throwable1) {
            lg.c("AndroidService", "OnExit", throwable1);
        }
        lg.a("AndroidService", "exit: 15");
        try {
            Process.killProcess(Process.myPid());
        }
        catch(Throwable throwable2) {
            lg.c("AndroidService", "OnExit", throwable2);
        }
        lg.a("AndroidService", "exit: 16");
        try {
            qt.a(("exec kill " + Process.myPid()), 45);
        }
        catch(Throwable throwable3) {
            lg.c("AndroidService", "OnExit", throwable3);
        }
        lg.a("AndroidService", "exit: 17");
        throw new hw("Failed exit from the app normally");
    }

    static ComponentName m() {
        try {
            return new ComponentName(Tools.g(), Instrumentation.class.getName());
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return null;
        }
    }

    public static void n() {
        if(lh.c == 0) {
            return;
        }
        rx.a(new lk());
    }

    // 去混淆评级： 低(40)
    static String o() [...] // 潜在的解密器

    static String p() {
        DisplayMetrics displayMetrics0;
        float f;
        int v;
        Configuration configuration0;
        Resources resources0;
        try {
            resources0 = Tools.e().getResources();
            configuration0 = resources0.getConfiguration();
        }
        catch(Throwable throwable0) {
            v = 0;
            f = 0.0f;
            la.a(throwable0);
            return ((int)f) + 'x' + v;
        }
        if(Build.VERSION.SDK_INT >= 13) {
            f = configuration0.screenWidthDp;
            v = configuration0.screenHeightDp;
        }
        else {
            v = 0;
            f = 0.0f;
        }
        try {
            displayMetrics0 = resources0.getDisplayMetrics();
            if(f == 0.0f && displayMetrics0 != null && displayMetrics0.density != 0.0f) {
                f = displayMetrics0.density;
                f = (int)(((float)displayMetrics0.widthPixels) / f);
            }
        }
        catch(Throwable throwable1) {
            throwable0 = throwable1;
            la.a(throwable0);
            return ((int)f) + 'x' + v;
        }
        if(v == 0 && displayMetrics0 != null && displayMetrics0.density != 0.0f) {
            v = (int)(((float)displayMetrics0.heightPixels) / displayMetrics0.density);
        }
        return ((int)f) + 'x' + v;
    }

    public static void q() {
        new gr(new lr(), "checkAutoTranslation").start();
    }

    private static void r() {
        new gr(new ma(), "checkRandomName").start();
    }

    private static void s() {
        if((Config.c & 0x80L) == 0L) {
            try {
                String s = Tools.a("%e", new Object[]{12000000243433737000000000000000000.0f});
                if(s.indexOf(101) == -1 && s.indexOf(69) == -1 && s.indexOf(1077) == -1 && s.indexOf(1045) == -1) {
                    rx.a(lh.a(ar.f, Tools.a(qk.a(0x7F07006E), new Object[]{"1.2E34", s}), 0x80L, false));  // string:wrong_float_ "__wrong_float__\n\n__wrong_float2__"
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
        la.a(throwable0);
    }

    private static void t() {
        new gr(new mb(), "checkSlowEmulator").start();
    }

    private static void u() {
        new gr(new mc(), "checkBadApps").start();
    }

    private static boolean v() {
        boolean z = false;
        try {
            Context context0 = Tools.e();
            if(context0 != null) {
                String s = Tools.g();
                z = context0.stopService(new Intent().setClassName(s, "catch_.me_.if_.you_.can_.AnalyticsService"));
                lh.a(100, " " + z);
                return z;
            }
            lh.a(101, "");
            return false;
        }
        catch(Throwable throwable0) {
            la.c("Failed unload Service", throwable0);
            return z;
        }
    }

    private static void w() {
        new gr(new ll(), "checkNewVersion").start();
    }

    private static void x() {
        File file0 = new File(Tools.l(), "sel.txt");
        try {
            if(!file0.exists()) {
                return;
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return;
        }
        if((Config.A & 4) != 0 || Build.VERSION.SDK_INT < 17) {
            file0.delete();
            return;
        }
        lh.a(true);
        i.c(i.c().setCustomTitle(Tools.d(0x7F0700BB)).setItems(new String[]{qk.a(0x7F0701F5), qk.a(0x7F0700B9)}, new ln(file0)).create());  // string:last_run_failed "Last run failed"
    }
}

