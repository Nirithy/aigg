package android.ext;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.fix.a;
import android.fix.d;
import android.fix.g;
import android.lang.m;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import catch_.me_.if_.you_.can_.MainActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class ar extends a implements View.OnClickListener {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile ar d;
    public static volatile Context e;
    public static volatile Context f;
    volatile boolean g;
    public static volatile boolean h;
    private volatile boolean i;
    private WeakReference j;
    private WeakReference k;
    private WeakReference l;
    private StringBuilder m;
    private static volatile boolean n;

    static {
        ar.a = false;
        ar.b = true;
        ar.c = false;
        ar.h = true;
        la.a("BaseActivity clinit");
        ho.b();
        ar.n = false;
    }

    public ar() {
        boolean z = false;
        super();
        this.g = true;
        this.i = false;
        this.j = new WeakReference(null);
        this.k = new WeakReference(null);
        this.l = new WeakReference(null);
        this.m = new StringBuilder();
        if(this instanceof MainActivity || ar.d == null) {
            ar.d = this;
        }
        if(this instanceof MainActivity || ar.f == null) {
            ar.f = this;
        }
        if(!(this instanceof MainActivity)) {
            z = true;
        }
        ar.b = z;
        la.a(("BaseActivity init: " + this));
        ho.b();
    }

    // 去混淆评级： 低(20)
    private AlertDialog a(Context context0) {
        return i.a(context0).setCustomTitle(Tools.d(0x7F070164)).setItems(new String[]{qk.a((rv.a ? 0x7F070187 : 0x7F070188)), qk.a(((Config.A & 4) == 0 ? 0x7F0701F5 : 0x7F0701F4)), qk.a(0x7F0701FA), qk.a(0x7F0701FB), Config.a(0x7F0B009C).toString(), Config.a(0x7F0B009D).toString(), Config.a(0x7F0B00BC).toString(), qk.a(0x7F0702DA), qk.a(0x7F07025E), qk.a(0x7F0702A4), qk.a(0x7F0702B9), Config.a(0x7F0B009B).toString(), Config.a(0x7F0B00AE).toString(), Config.a(0x7F0B009A).toString(), Config.a(0x7F0B00B1).toString()}, new as(this)).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:fix_it "Fix it"
    }

    public static Bundle a() {
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("hw", ar.b);
        bundle0.putInt("uid", Process.myUid());
        bundle0.putBoolean("vspace", Config.C);
        if(ar.c) {
            la.a("removeInstaller: to bundle");
            bundle0.putBoolean("reminst", true);
        }
        return bundle0;
    }

    public static void a(Bundle bundle0) {
        if(bundle0 != null) {
            if(bundle0.containsKey("reminst")) {
                la.a("removeInstaller: from bundle");
                ar.c = true;
            }
            if(bundle0.containsKey("hw")) {
                ar.b = bundle0.getBoolean("hw");
            }
            if(bundle0.containsKey("uid")) {
                int v = bundle0.getInt("uid");
                int v1 = Process.myUid();
                if(bundle0.getBoolean("vspace") && v1 != v) {
                    la.a(("Kill by diff uids: " + v1 + " != " + v));
                    lh.l();
                }
            }
        }
    }

    static void a(OutputStream outputStream0, String s, String s1) {
        try {
            outputStream0.write(("\n\n" + new GregorianCalendar().getTime().toString() + '\n' + s + '\n' + gs.f() + '\n' + lh.o() + '\n' + Tools.e().getFilesDir().getAbsolutePath() + '\n' + s1 + "\n\n").getBytes());
            outputStream0.flush();
        }
        catch(Throwable throwable0) {
            la.b("Fail write logcat header", throwable0);
        }
    }

    private void a(String s) {
        boolean z = true;
        StringBuilder stringBuilder0 = this.m;
        String s1 = null;
        if(s.startsWith("/mnt/expand/")) {
            s = s.replace("/mnt/expand/" + s.split("/", -1)[3], "/data");
            ar.n = true;
            stringBuilder0.append("1\n");
        }
        if(s.startsWith("/data/data/")) {
            s1 = s.split("/", -1)[3];
            stringBuilder0.append("2\n");
        }
        else if(s.startsWith("/data/user/")) {
            s1 = s.split("/", -1)[4];
            stringBuilder0.append("3\n");
        }
        Config.F = "";
        if(s1 != null) {
            stringBuilder0.append(s1);
            stringBuilder0.append("\n4\n");
            if(s1.startsWith(y.d)) {
                z = false;
            }
            try {
                Config.C = z;
                Config.E = s1;
                Config.D = s1.contains("vmos");
                Config.F = Tools.a(Tools.j(s1));
            }
            catch(Throwable throwable0) {
                la.b(("Failed get vSpace name for " + s1), throwable0);
            }
        }
        if(Config.F.length() == 0) {
            Config.F = qk.a(0x7F0702C4);  // string:virtual_space "Virtual Space App"
        }
        stringBuilder0.append(Config.C);
        stringBuilder0.append('\n');
    }

    private static void a(StringBuilder stringBuilder0, int v) {
        la.a(("START: " + v));
        stringBuilder0.append('\n');
        stringBuilder0.append(v);
        stringBuilder0.append(": ");
    }

    private static void a(StringBuilder stringBuilder0, String s) {
        BufferedReader bufferedReader0 = new BufferedReader(new FileReader("/proc/self/maps"));
        String s1;
        while((s1 = bufferedReader0.readLine()) != null) {
            int v = s1.indexOf(s);
            if(v >= 0) {
                int v1;
                for(v1 = v; v1 > 0 && s1.charAt(v1) > 0x20; --v1) {
                }
                if(v1 < v) {
                    stringBuilder0.append("\n\'");
                    stringBuilder0.append(s1.substring(v1, s1.length()).trim());
                    stringBuilder0.append('\'');
                }
            }
        }
        bufferedReader0.close();
    }

    void a(int v) {
        rx.a(new ay(this, v));
    }

    public void a(boolean z) {
        boolean z1 = this.i;
        this.i = z;
        if(z1 != z && MainService.instance != null) {
            MainService.instance.u();
        }
    }

    // 去混淆评级： 中等(60)
    public static String b() [...] // 潜在的解密器

    private void b(boolean z) {
        View view0 = (View)this.j.get();
        if(view0 != null) {
            View view1 = view0.findViewById(0x7F0B0035);  // id:starter
            if(z) {
                if(view1 == null) {
                    ((ViewGroup)view0).addView(Tools.d(((ViewGroup)android.fix.i.a(0x7F040009, null)).findViewById(0x7F0B0035)));  // layout:main
                }
                TextView textView0 = (TextView)view0.findViewById(0x7F0B0036);  // id:front_text
                this.k = new WeakReference(textView0);
                for(int v = 0; v < 6; ++v) {
                    View view2 = view0.findViewById(new int[]{0x7F0B0039, 0x7F0B003B, 0x7F0B003A, 0x7F0B0038, 0x7F0B0037, 0x7F0B0013}[v]);  // id:btn_stop_service
                    if(view2 instanceof TextView) {
                        ((TextView)view2).setText(qk.a(((TextView)view2).getText().toString()));
                    }
                    view2.setOnClickListener(this);
                }
                Tools.l(textView0);
                return;
            }
            if(view1 != null) {
                TextView textView1 = (TextView)this.k.get();
                if(textView1 != null) {
                    Tools.a(textView1);
                    Tools.d(textView1);
                }
                Tools.d(view1);
            }
        }
    }

    void b(Bundle bundle0) {
        boolean z;
        if(jp.b() || Tools.s().getInt("root-ok", 0) == 0x3F0E) {
            z = true;
        }
        else {
            try {
                if(qt.a("exec id", 10).contains("uid=0")) {
                    new qw().a("root-ok", 0x3F0E).commit();
                    z = true;
                }
                else {
                    z = false;
                }
            }
            catch(Throwable unused_ex) {
                z = false;
            }
        }
        if(z) {
            this.c(bundle0);
            return;
        }
        bb bb0 = new bb(this, bundle0);
        i.a(i.a(ar.f).setTitle(qk.a(0x7F0702A8)).setCancelable(false).setItems(new String[]{qk.a(0x7F0702A9), qk.a(0x7F0702AA), qk.a(0x7F0700B8)}, new bc(this, bb0)).create(), bb0, false);  // string:work_mode "Work mode"
    }

    void c() {
        ct ct0 = Config.a(0x7F0B00BC);  // id:config_context_source
        ct0.a(new av(this, ct0));
        ct0.d();
    }

    void c(Bundle bundle0) {
        if(bundle0 != null) {
            Parcelable parcelable0 = bundle0.getParcelable("installer-state");
            if(parcelable0 instanceof ko) {
                jp.a(((ko)parcelable0));
            }
        }
        if(lh.d) {
            this.a(2);
            return;
        }
        lh.c();
    }

    void d() {
        String s = this.p();
        if(Config.a(0x7F0B00C2).d != 0x3F0E) {  // id:record_logcat
            return;
        }
        Config.a(0x7F0B00C2).d = 0;  // id:record_logcat
        Config.c();
        new gr(new aw(this, s), "RecordLogcat").start();
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        try {
            return super.dispatchKeyEvent(keyEvent0);
        }
        catch(IllegalStateException illegalStateException0) {
            la.a(illegalStateException0);
            return false;
        }
    }

    static String e() {
        String s = Tools.r();
        StringBuilder stringBuilder0 = new StringBuilder("GG_logcat_");
        return Config.C ? new File(s, stringBuilder0.append("v").append(101.099998f).append('_').append(0x3F0E).append('_').append(Build.VERSION.RELEASE).append('_').append(Build.VERSION.SDK_INT).append(".log").toString()).getAbsolutePath() : new File(s, stringBuilder0.append("r").append(101.099998f).append('_').append(0x3F0E).append('_').append(Build.VERSION.RELEASE).append('_').append(Build.VERSION.SDK_INT).append(".log").toString()).getAbsolutePath();
    }

    static void f() {
        String s = ar.e();
        i.a(i.a(ar.f).setMessage(Tools.a(qk.a(0x7F0702A5), new Object[]{s})).setPositiveButton(qk.a(0x7F07009D), new ax()).setNegativeButton(qk.a(0x7F0700A1), null));  // string:record_logcat_info "__app_name__ will be restarted with recording __logcat__ 
                                                                                                                                                                        // into the file:\n\"__s__\".\n\nTo end the recording, exit from __app_name__.\nAfter 
                                                                                                                                                                        // that, you can send the log file to where you need it."
    }

    static void g() {
        StringBuilder stringBuilder0 = new StringBuilder();
        ar.a(stringBuilder0, 1);
        try {
            stringBuilder0.append(ar.d.getFilesDir());
        }
        catch(Throwable throwable0) {
            stringBuilder0.append(throwable0);
        }
        ar.a(stringBuilder0, 2);
        int v = Process.myUid();
        try {
            stringBuilder0.append(v);
        }
        catch(Throwable throwable1) {
            stringBuilder0.append(throwable1);
        }
        ar.a(stringBuilder0, 3);
        try {
            stringBuilder0.append(Arrays.toString(ar.d.getPackageManager().getPackagesForUid(v)));
        }
        catch(Throwable throwable2) {
            stringBuilder0.append(throwable2);
        }
        ar.a(stringBuilder0, 4);
        try {
            stringBuilder0.append(Arrays.toString(ar.d.getPackageManager().getPackageGids("catch_.me_.if_.you_.can_")));
        }
        catch(Throwable throwable3) {
            stringBuilder0.append(throwable3);
        }
        ar.a(stringBuilder0, 5);
        try {
            stringBuilder0.append(ar.d.getPackageManager().getPackageUid("catch_.me_.if_.you_.can_", 0));
        }
        catch(Throwable throwable4) {
            stringBuilder0.append(throwable4);
        }
        ar.a(stringBuilder0, 6);
        try {
            stringBuilder0.append(ar.d.checkCallingOrSelfPermission("android.permission.READ_SMS"));
        }
        catch(Throwable throwable5) {
            stringBuilder0.append(throwable5);
        }
        stringBuilder0.append(' ');
        stringBuilder0.append(Tools.s().getInt("odd-vspace", 0));
        ar.a(stringBuilder0, 7);
        try {
            stringBuilder0.append(Build.VERSION.SDK_INT);
        }
        catch(Throwable throwable6) {
            stringBuilder0.append(throwable6);
        }
        ar.a(stringBuilder0, 8);
        try {
            File file0 = new File(ar.d.getFilesDir(), "-1404431238.txt");
            try {
                FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                fileOutputStream0.write(new byte[0x1000]);
                fileOutputStream0.flush();
                File file1 = new File("/proc/self/fd/" + m.a(fileOutputStream0.getFD()));
                stringBuilder0.append(file1.getPath());
                stringBuilder0.append(" -> ");
                stringBuilder0.append(file1.getCanonicalPath());
                try {
                    FileInputStream fileInputStream0 = new FileInputStream(file0);
                    MappedByteBuffer mappedByteBuffer0 = fileInputStream0.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, 0x1000L);
                    ar.a(stringBuilder0, "-1404431238.txt");
                    mappedByteBuffer0.capacity();
                    fileInputStream0.close();
                }
                catch(Throwable throwable8) {
                    stringBuilder0.append('\n');
                    stringBuilder0.append(throwable8);
                }
                stringBuilder0.append("\nN: \'");
                stringBuilder0.append(Tools.m(file0.getAbsolutePath()));
                stringBuilder0.append('\'');
                fileOutputStream0.close();
            }
            finally {
                file0.delete();
            }
        }
        catch(Throwable throwable7) {
            stringBuilder0.append(throwable7);
        }
        ar.a(stringBuilder0, 9);
        try {
            ar.a(stringBuilder0, "catch_.me_.if_.you_.can_");
        }
        catch(Throwable throwable9) {
            stringBuilder0.append(throwable9);
        }
        ar.a(stringBuilder0, 10);
        try {
            stringBuilder0.append(ConfigListAdapter.i());
        }
        catch(Throwable throwable10) {
            stringBuilder0.append(throwable10);
        }
        ar.a(stringBuilder0, 11);
        try {
            File file2 = new File("/proc/self/exe");
            stringBuilder0.append("/proc/self/exe");
            stringBuilder0.append(" -> ");
            stringBuilder0.append(file2.getCanonicalPath());
        }
        catch(Throwable throwable11) {
            stringBuilder0.append(throwable11);
        }
        ar.a(stringBuilder0, 12);
        try {
            stringBuilder0.append(Process.myPid());
        }
        catch(Throwable throwable12) {
            stringBuilder0.append(throwable12);
        }
        ar.a(stringBuilder0, 13);
        try {
            FileInputStream fileInputStream1 = new FileInputStream("/proc/self/status");
            byte[] arr_b = new byte[0x10000];
            int v2 = fileInputStream1.read(arr_b);
            stringBuilder0.append(v2);
            stringBuilder0.append(" -> ");
            if(v2 > 0) {
                stringBuilder0.append(new String(arr_b, 0, v2));
            }
            fileInputStream1.close();
        }
        catch(Throwable throwable13) {
            stringBuilder0.append(throwable13);
        }
        la.a("FIN");
        Tools.b(stringBuilder0.toString().trim(), 0);
    }

    public static void h() {
        try {
            lh.c = 2;
            lh.j();
        }
        catch(Throwable throwable0) {
            throw new RuntimeException("Failed restart", throwable0);
        }
    }

    public boolean i() {
        return this.i;
    }

    public void j() {
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            stringBuilder0.append("INTERNET: 0~");
            stringBuilder0.append('#');
            stringBuilder0.append(";1~");
            Context context0 = Tools.e();
            int v = context0.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid());
            stringBuilder0.append(v);
            stringBuilder0.append(";2~");
            stringBuilder0.append(context0.checkCallingOrSelfPermission("android.permission.INTERNET"));
            stringBuilder0.append(";3~");
            stringBuilder0.append(context0.checkCallingPermission("android.permission.INTERNET"));
            la.a(stringBuilder0.toString());
            if(v != 0) {
                ho.a(Thread.currentThread(), new RuntimeException(stringBuilder0.toString()), false);
            }
        }
        catch(Throwable throwable0) {
            RuntimeException runtimeException0 = new RuntimeException(stringBuilder0.toString(), throwable0);
            la.a(runtimeException0);
            ho.a(Thread.currentThread(), runtimeException0, false);
        }
        if(Build.VERSION.SDK_INT >= 23) {
            try {
                Context context1 = Tools.e();
                PackageInfo packageInfo0 = Tools.d(Tools.g(), 0x1000);
                if(packageInfo0 != null && packageInfo0.requestedPermissions != null) {
                    ArrayList arrayList0 = new ArrayList();
                    Tools.m();
                    String[] arr_s = packageInfo0.requestedPermissions;
                    for(int v1 = 0; v1 < arr_s.length; ++v1) {
                        String s = arr_s[v1];
                        if(s != null && context1.checkSelfPermission(s) != 0) {
                            arrayList0.add(s);
                        }
                    }
                    if(arrayList0.size() > 0) {
                        String[] arr_s1 = (String[])arrayList0.toArray(new String[arrayList0.size()]);
                        la.a(("requestPermissions: " + Arrays.toString(arr_s1)));
                        this.requestPermissions(arr_s1, 0);
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable1) {
            }
        }
        else {
            return;
        }
        la.a(throwable1);
    }

    private void m() {
        ar.t();
        this.setContentView(0x7F040009);  // layout:main
        View view0 = this.findViewById(0x7F0B0030);  // id:root
        this.j = new WeakReference(view0);
        TextView textView0 = (TextView)view0.findViewById(0x7F0B0033);  // id:installing
        textView0.setText(qk.a(0x7F070152));  // string:installing "__app_name__ performs a reinstallation of itself with a random 
                                              // name to exclude detection by games. Wait."
        jp.i = new WeakReference(((ProgressBar)view0.findViewById(0x7F0B0024)));  // id:progress_bar
        jp.j = new WeakReference(((TextView)view0.findViewById(0x7F0B0023)));  // id:progress_bar_text
        jp.k = new WeakReference(textView0);
        jp.h = new WeakReference(((Button)view0.findViewById(0x7F0B0034)));  // id:abort_button
        this.a(0);
        this.b(true);
    }

    private void n() {
        TextView textView0 = (TextView)this.k.get();
        if(textView0 == null) {
            return;
        }
        CharSequence charSequence0 = (CharSequence)this.l.get();
        if(charSequence0 != null) {
            textView0.setText(charSequence0);
            return;
        }
        String s = qk.a(0x7F070147) + " http://gameguardian.net/download" + "\n\n" + qk.a(0x7F070084) + "\n\n";  // string:download "This app can be downloaded from:"
        String s1 = qk.a("     32. __help_faq_32_q__\r\n        __help_faq_32_b__\r\n\r\n__rtfm__");
        Tools.a(textView0, s + s1 + ("\n\n" + qk.a(0x7F07001F)));  // string:help_front "__quick_start_title__\n\n__help_basics__\n\n__help_floating_icon__\n\n__help_exact_search__\n\n__help_group_search__\n\n__help_range_search__\n\n__help_encrypted_search__\n\n__help_fuzzy_search__\n\n__help_mask_search__\n\n__help_fill__\n\n__help_text_search__\n\n__help_xor_search__\n\n__help_speedhack__\n\n__help_others__ 
                                                                   //  \n\n__help_typical_usage__\n\n__help_speed_up__\n\n__help_hints_0__\n\n__help_hex_colors__\n\n__rtfm__\n 
                                                                   //    "
        Tools.a(textView0.getText());
        Tools.a(textView0.getText(), s1, Tools.e(0x7F0A0011));  // color:alert
        this.l = new WeakReference(textView0.getText());
    }

    private void o() {
        TextView textView0 = (TextView)this.k.get();
        if(textView0 != null) {
            textView0.setText("");
        }
        this.b(false);
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int v, int v1, Intent intent0) {
        la.a(((this.g ? "Installer: " : "") + "onActivityResult()"));
        super.onActivityResult(v, v1, intent0);
        if(this.g) {
            jp.a(v, v1, intent0);
            return;
        }
        bq.e();
    }

    @Override  // android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        }
        catch(IllegalStateException illegalStateException0) {
            la.a(illegalStateException0);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null) {
            return;
        }
        switch(view0.getId()) {
            case 0x7F0B0013: {  // id:help
                ConfigListAdapter.g();
                return;
            }
            case 0x7F0B0037: {  // id:language
                ConfigListAdapter.k();
                return;
            }
            case 0x7F0B0038: {  // id:fix_it
                try {
                    this.a(ar.f).show();
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                    i.c(this.a(Tools.e()));
                }
                return;
            }
            case 0x7F0B0039: {  // id:btn_stop_service
                la.a("Pushed exit");
                this.finish();
                new ib(100).onClick(null, 0);
                return;
            }
            case 0x7F0B003A: {  // id:check
                new bq(this).a();
                return;
            }
            case 0x7F0B003B: {  // id:btn_start_usage
                if(rv.a) {
                    try {
                        if(!this.moveTaskToBack(true)) {
                            this.finish();
                        }
                    }
                    catch(Throwable throwable1) {
                        la.a(throwable1);
                    }
                }
                MainService.instance.d();
            }
        }
    }

    @Override  // android.fix.a
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        ho.b();
        if(this instanceof MainActivity || ar.d == null) {
            ar.d = this;
        }
        if(this instanceof MainActivity || !(ar.f instanceof d)) {
            ar.f = d.c(this);
        }
        if(this instanceof MainActivity || ar.e == null) {
            ar.e = d.c(this.getApplicationContext());
        }
        try {
            android.fix.Button button0 = new android.fix.Button(this);
            button0.setText("Fix it");
            button0.setId(0x7F0B0038);  // id:fix_it
            button0.setOnClickListener(this);
            this.setContentView(button0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        this.q();
        g.a = false;
        Tools.a(this);
        Window window0 = this.getWindow();
        if(window0 != null) {
            if(ar.b) {
                window0.addFlags(0x1000000);
            }
            else {
                window0.clearFlags(0x1000000);
            }
        }
        d.d(ar.f);
        ad.d();
        this.d();
        this.setTitle(String.valueOf((Config.C ? "$" : "#")) + ' ' + qk.a(0x7F070001) + ' ' + 101.099998f + " (" + 0x3F0E + ") " + (ar.b ? "HW" : "SW"));  // string:app_name "GameGuardian"
        this.m();
        Tools.d();
        ba ba0 = new ba(this, bundle0);
        la.a((ba0 + ": 10"));
        jp.a(ba0);
        la.a((ba0 + ": 20"));
    }

    @Override  // android.fix.a
    public void onDestroy() {
        this.a(false);
        this.o();
        super.onDestroy();
        if(!this.g && ar.h) {
            la.a("onDestroy(exit)");
            lh.j();
            return;
        }
        la.a(((this.g ? "Installer: " : "") + "onDestroy()"));
    }

    @Override  // android.app.Activity
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        try {
            return super.onKeyUp(v, keyEvent0);
        }
        catch(IllegalStateException illegalStateException0) {
            la.a(illegalStateException0);
            return false;
        }
    }

    @Override  // android.fix.a
    public void onPause() {
        la.a(((this.g ? "Installer: " : "") + "onPause()"));
        this.a(false);
        if(!this.g && MainService.instance != null && rv.a) {
            MainService.instance.d();
        }
        super.onPause();
    }

    @Override  // android.fix.a
    protected void onPostCreate(Bundle bundle0) {
        la.a(((this.g ? "Installer: " : "") + "onPostCreate()"));
        super.onPostCreate(bundle0);
    }

    @Override  // android.fix.a
    protected void onPostResume() {
        la.a(((this.g ? "Installer: " : "") + "onPostResume()"));
        this.a(true);
        this.b(true);
        super.onPostResume();
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        if(arr_s != null && arr_v != null) {
            int v1 = Math.min(arr_s.length, arr_v.length);
            for(int v2 = 0; v2 < v1; ++v2) {
                String s = arr_s[v2];
                if(s != null) {
                    la.a((s + ": " + arr_v[v2]));
                }
            }
        }
        super.onRequestPermissionsResult(v, arr_s, arr_v);
    }

    @Override  // android.fix.a
    protected void onRestart() {
        la.a(((this.g ? "Installer: " : "") + "onRestart()"));
        this.a(true);
        this.b(true);
        super.onRestart();
    }

    @Override  // android.fix.a
    public void onResume() {
        la.a(((this.g ? "Installer: " : "") + "onResume()"));
        this.a(true);
        this.b(true);
        super.onResume();
        if(!this.g && MainService.instance != null) {
            if(rv.a) {
                MainService.instance.c();
                return;
            }
            if(MainService.instance.p == null) {
                ar.s();
            }
        }
    }

    @Override  // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle0) {
        bundle0.putParcelable("installer-state", jp.a());
        super.onSaveInstanceState(bundle0);
    }

    @Override  // android.fix.a
    protected void onStart() {
        la.a(((this.g ? "Installer: " : "") + "onStart()"));
        this.a(true);
        this.b(true);
        this.n();
        super.onStart();
    }

    @Override  // android.fix.a
    public void onStop() {
        la.a(((this.g ? "Installer: " : "") + "onStop()"));
        this.a(false);
        this.o();
        super.onStop();
    }

    private String p() {
        StringBuilder stringBuilder0 = this.m;
        this.m = null;
        return stringBuilder0 == null ? "" : stringBuilder0.toString();
    }

    private void q() {
        StringBuilder stringBuilder0;
        try {
            stringBuilder0 = this.m;
            File file0 = this.getFilesDir();
            String s = file0.getAbsolutePath();
            stringBuilder0.append(s);
            stringBuilder0.append('\n');
            stringBuilder0.append(y.d);
            stringBuilder0.append('\n');
            this.a(s);
            if(!Config.C && (ar.d.checkCallingOrSelfPermission("android.permission.READ_SMS") == 0 || true)) {
                stringBuilder0.append("? ");
                File file1 = new File(file0, "-1661828252.txt");
                FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
                fileOutputStream0.write(new byte[0x1000]);
                fileOutputStream0.flush();
                fileOutputStream0.close();
                String s1 = Tools.m(file1.getAbsolutePath()).replace("/-1661828252.txt", "");
                file1.delete();
                stringBuilder0.append(s1);
                stringBuilder0.append('\n');
                this.a(s1);
                if(Config.C) {
                    String s3 = "/" + file0.getName();
                    String s4 = s1.replace(s3, "");
                    String s5 = s.replace(s3, "");
                    String s6 = "F2R: [" + s4.length() + "] " + s5 + " -> " + s4;
                    la.b(s6);
                    stringBuilder0.append(s6);
                    stringBuilder0.append('\n');
                    Tools.d = new String[]{s5, s4};
                }
                else {
                    String s2 = "Odd vSpace: " + s + "; " + s1;
                    la.b(s2);
                    stringBuilder0.append(s2);
                    stringBuilder0.append('\n');
                    int v = Tools.s().getInt("odd-vspace", 0);
                    stringBuilder0.append(v);
                    stringBuilder0.append('\n');
                    if(v == 1) {
                        Config.C = true;
                    }
                    else if(v == 0) {
                        az az0 = new az(this);
                        i.a(i.a(ar.f).setMessage(qk.a(0x7F0702E2)).setCancelable(false).setPositiveButton(qk.a(0x7F07009B), az0).setNegativeButton(qk.a(0x7F07009C), az0));  // string:odd_vspace "__app_name__ launched in the virtual space?"
                    }
                }
            }
            String s7 = "Files: " + s + ' ' + y.d;
            la.a(s7);
            stringBuilder0.append(s7);
            stringBuilder0.append('\n');
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            stringBuilder0.append(throwable0.toString());
            stringBuilder0.append('\n');
        }
        Config.vSpaceReal = Config.C;
        if(Config.C && (Config.B & 0x200) != 0) {
            Config.C = false;
        }
    }

    private static void r() {
        if(!ar.n) {
            return;
        }
        i.a(i.a(ar.f).setMessage(qk.a(0x7F0702BA)).setNeutralButton(qk.a(0x7F07009D), null).setPositiveButton(qk.a(0x7F070164), new at()));  // string:mnt_expand "__app_name__ is installed on a memory card that is used as \"Internal 
                                                                                                                                             // storage\".\nThis can interfere with the operation of virtual spaces.\nIf this happens, 
                                                                                                                                             // install __app_name__ in the internal memory of the device.\nYou may need to reformat 
                                                                                                                                             // the memory card as \"Portable storage\"."
    }

    private static void s() {
        rx.a().post(new au());
    }

    private static void t() {
        if(Build.VERSION.SDK_INT >= 11) {
            try {
                Field field0 = ValueAnimator.class.getDeclaredField("sDurationScale");
                field0.setAccessible(true);
                Object object0 = field0.get(null);
                if(object0 instanceof Float && 0.0f.equals(object0)) {
                    field0.set(null, 1.0f);
                    la.a("Fix sDurationScale");
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
        la.b("failed fix sDurationScale", throwable0);
    }
}

