package android.ext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.c.a;
import android.c.e;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.fix.WrapLayout;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost.TabSpec;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainService extends rh implements View.OnClickListener, View.OnLongClickListener {
    TextView A;
    final WrapLayout[] B;
    View C;
    ListView D;
    ic E;
    pj F;
    View G;
    ImageView H;
    ListView I;
    ListView J;
    ow K;
    pf L;
    ImageButton M;
    boolean N;
    boolean O;
    ik P;
    ra Q;
    ov R;
    ListView S;
    View T;
    View U;
    View V;
    View W;
    View X;
    TextView Y;
    ShowApp Z;
    public static final String a;
    private static volatile boolean aA;
    private TextView aB;
    private TextView aC;
    private boolean aD;
    private static int aE;
    private SparseBooleanArray aF;
    private static volatile boolean aG;
    private volatile ArrayList aH;
    private final int[] aI;
    private final Runnable aJ;
    private static volatile ComponentCallbacks aK;
    private static volatile boolean aL;
    private static volatile boolean aM;
    private boolean aN;
    private boolean aO;
    private final up[] aP;
    private static long aQ;
    bl aa;
    public ky ab;
    volatile int ac;
    volatile int ad;
    TimersEditor ae;
    public static final boolean[] af;
    TimersEditor ag;
    public static final boolean[] ah;
    static int ai;
    volatile long aj;
    boolean ak;
    boolean al;
    final a am;
    SavedListAdapter an;
    final g ao;
    public qh ap;
    ConfigListAdapter aq;
    Runnable ar;
    volatile boolean as;
    private ImageView at;
    private ImageView au;
    private ImageView av;
    private ImageView aw;
    private ImageButton ax;
    private boolean ay;
    private boolean az;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile Context context;
    Script d;
    View e;
    View f;
    boolean g;
    qm h;
    View i;
    public static volatile MainService instance;
    z j;
    ex k;
    HotPoint l;
    TimeJumpPanel m;
    WindowManager n;
    TabHost o;
    volatile me p;
    public static final pj[][] q;
    View r;
    TextView s;
    TextView t;
    TextView u;
    View v;
    TextView w;
    View x;
    TextView y;
    View z;

    static {
        MainService.a = "null_preferences";
        MainService.instance = null;
        MainService.b = false;
        MainService.c = false;
        MainService.q = new pj[3][];
        MainService.aA = false;
        MainService.af = new boolean[0xB0];
        MainService.ah = new boolean[76];
        for(int v = 0; v < MainService.ah.length; ++v) {
            MainService.ah[v] = v % 4 < 2;
        }
        for(int v1 = 0; v1 < MainService.af.length; ++v1) {
            MainService.af[v1] = v1 % 4 < 2;
        }
        for(int v2 = 0; v2 < 3; ++v2) {
            int v3 = new int[]{40, 43, 44}[v2] - 1;
            MainService.af[v3 * 4] = false;
            MainService.af[v3 * 4 + 1] = false;
            MainService.af[v3 * 4 + 2] = false;
            MainService.af[v3 * 4 + 3] = false;
        }
        MainService.aE = 0x7F;
        MainService.ai = 0;
        MainService.aG = true;
        MainService.aK = null;
        MainService.aL = false;
        MainService.aM = true;
        MainService.aQ = 0L;
    }

    public MainService(Context context0) {
        super(context0);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.m = null;
        this.p = null;
        this.N = false;
        this.O = false;
        this.ay = false;
        this.az = false;
        this.aD = true;
        this.ac = 0;
        this.ad = 0;
        this.aj = 0L;
        this.ak = false;
        this.al = true;
        this.am = new a();
        this.an = new SavedListAdapter();
        this.ao = new g();
        this.ap = null;
        this.aF = new SparseBooleanArray();
        this.aH = new ArrayList();
        this.aI = new int[3];
        this.aJ = new mf(this);
        this.ar = null;
        this.aN = true;
        this.aO = false;
        this.aP = new up[4];
        this.as = false;
        if(MainService.context == null) {
            MainService.context = ri.a(context0);
        }
        MainService.instance = this;
        Tools.d();
        this.k = new ex();
        this.B = new WrapLayout[3];
    }

    public static ComponentCallbacks A() {
        ComponentCallbacks componentCallbacks0 = MainService.aK;
        if(componentCallbacks0 == null) {
            componentCallbacks0 = Build.VERSION.SDK_INT >= 14 ? new na() : new nb();
            MainService.aK = componentCallbacks0;
        }
        return componentCallbacks0;
    }

    @SuppressLint({"SdCardPath"})
    @TargetApi(19)
    String B() {
        ArrayList arrayList0 = new ArrayList();
        SharedPreferences sharedPreferences0 = Tools.s();
        String s = sharedPreferences0.getString("temp-path", null);
        if(s != null) {
            if("/bypass".equals(s)) {
                ex.a = true;
            }
            if(s.length() >= 2 && s.charAt(0) == 0x2F) {
                MainService.a(arrayList0, s);
            }
            else {
                sharedPreferences0.edit().remove("temp-path").commit();
                la.c(("Removed bad path: " + s));
            }
        }
        try {
            MainService.a(arrayList0, MainService.context.getExternalFilesDir(null));
        }
        catch(Throwable throwable0) {
            la.c("Fail get path", throwable0);
        }
        if(Build.VERSION.SDK_INT >= 19) {
            try {
                File[] arr_file = MainService.context.getExternalFilesDirs(null);
            label_18:
                for(int v = 0; v < arr_file.length; ++v) {
                    MainService.a(arrayList0, arr_file[v]);
                }
            }
            catch(Throwable throwable1) {
                la.c("Fail get path", throwable1);
                if(true) {
                    goto label_25;
                }
                goto label_18;
            }
        }
        try {
        label_25:
            MainService.a(arrayList0, MainService.context.getExternalCacheDir());
        }
        catch(Throwable throwable2) {
            la.c("Fail get path", throwable2);
        }
        if(Build.VERSION.SDK_INT >= 19) {
            try {
                File[] arr_file1 = MainService.context.getExternalCacheDirs();
            label_32:
                for(int v1 = 0; v1 < arr_file1.length; ++v1) {
                    MainService.a(arrayList0, arr_file1[v1]);
                }
            }
            catch(Throwable throwable3) {
                la.c("Fail get path", throwable3);
                if(true) {
                    goto label_39;
                }
                goto label_32;
            }
        }
        try {
        label_39:
            MainService.a(arrayList0, Environment.getExternalStorageDirectory());
        }
        catch(Throwable throwable4) {
            la.c("Fail get path", throwable4);
        }
        MainService.a(arrayList0, "/sdcard");
        try {
            MainService.a(arrayList0, Tools.i());
        }
        catch(Throwable throwable5) {
            la.c("Fail get path", throwable5);
        }
        try {
            MainService.a(arrayList0, Tools.h());
        }
        catch(Throwable throwable6) {
            la.c("Fail get path", throwable6);
        }
        MainService.a(arrayList0, "/data");
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: arrayList0) {
            String s1 = (String)object0;
            if(s1 != null) {
                String s2 = s1.trim();
                if(!"".equals(s2)) {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append('|');
                    }
                    stringBuilder0.append(s2);
                }
            }
        }
        return stringBuilder0.toString();
    }

    Object C() {
        if(this.X == this.T) {
            return this.am;
        }
        if(this.X == this.U) {
            return this.an != null ? this.an.b() : null;
        }
        return this.X != this.V || this.K == null ? null : this.K.a();
    }

    void D() {
        if(this.X == this.T) {
            this.a(this.D);
            return;
        }
        if(this.X == this.U) {
            this.a(this.I);
            return;
        }
        if(this.X == this.V) {
            this.a(this.J);
        }
    }

    void E() {
        if(rx.c()) {
            this.F();
            return;
        }
        rx.a(new nc(this));
    }

    void F() {
        TextView textView0 = this.s;
        if(textView0 != null && this.ap == null && this.k.e.g()) {
            textView0.setText(qk.a(0x7F0700C8));  // string:loading "Loading..."
        }
        TextView textView1 = this.Y;
        if(textView1 != null) {
            textView1.setText(Tools.a(new CharSequence[]{qk.a(0x7F070000), " ", this.k.x(), " ", Config.a(0x7F0B0081).c(), " ", Integer.toString(Tools.a(this.C()))}));  // string:version_number "101.1"
        }
    }

    public void G() {
        this.E();
    }

    public static void H() {
        i.a(i.c().setMessage(qk.a(0x7F070104)).setNegativeButton(qk.a(0x7F07009D), null));  // string:bad_firmware "Your firmware has errors that prevented the use of this feature."
    }

    boolean I() {
        boolean z = this.c(0);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.processResume()\n");
        }
        return z;
    }

    boolean J() {
        boolean z = this.d(0);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.processKill()\n");
        }
        return z;
    }

    void K() {
        this.ax.setImageResource((this.N ? 0x7F02003D : 0x7F02003A));  // drawable:ic_play_arrow_white_18dp
    }

    public void L() {
        this.e(0);
    }

    public void M() {
        if(!MainService.c) {
            return;
        }
        this.j(false);
        this.f();
    }

    void N() {
        la.a("stopService");
        if(MainService.b) {
            la.a("Service stopService: already");
            return;
        }
        MainService.b = true;
        this.k.w();
        this.l.h();
        this.U();
    }

    public void O() {
        la.a("Service onDestroy");
        this.g(true);
        this.aa();
        lh.j();
    }

    @SuppressLint({"DefaultLocale"})
    public void P() {
        StringBuilder stringBuilder0;
        String s = null;
        if(this.aj != 0L) {
            stringBuilder0 = null;
        }
        else if(this.al) {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append(qk.a(0x7F0700E3));  // string:search_hint "To search for a known value, press \"__search_known_value__\".\nIf 
                                                      // the value is unknown or encrypted - click the \"__search_unknown_value__\" to search.\nSearch 
                                                      // for float values by their integer part may be performed by selecting the \'__type_auto__\' 
                                                      // search type.\nAlso you can use a group search with \'__semicolon__\' as a separator."
            stringBuilder0.append('\n');
            stringBuilder0.append(qk.a(0x7F070103));  // string:speedhack_hint "To change the speed of the game, perform a long press on 
                                                      // the floating __app_name__ icon."
        }
        else {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append(qk.a(0x7F0700E0));  // string:nothing_found "Nothing found. Try to search again."
            if(Config.i != -1) {
                stringBuilder0.append('\n');
                stringBuilder0.append(qk.a(0x7F0700E1));  // string:try_more_ranges "You can also try to choose more ranges in the settings tab."
            }
            if(!this.ak) {
                stringBuilder0.append('\n');
                stringBuilder0.append(qk.a(0x7F0700E2));  // string:try_fuzzy_search "You can also try to search for an unknown value."
            }
        }
        int v = this.am.b();
        String s1 = " (" + gv.a(v, 0x20) + (this.aj == ((long)v) ? "" : "/" + gv.a(this.aj, 0x20)) + ")";
        if(stringBuilder0 != null) {
            s = stringBuilder0.toString();
        }
        CharSequence charSequence0 = AddressArrayAdapter.a == 0 ? s1 : Tools.a(new CharSequence[]{s1, " ", ow.c(AddressArrayAdapter.a)});
        rx.a(new nf(this, s, charSequence0));
    }

    public void Q() {
        this.p();
        if(this.as) {
            return;
        }
        this.as = true;
        String s = this.ap == null ? null : this.ap.c;
        boolean z = this.ap == null ? false : this.ap.n;
        this.a(false);
        this.W();
        this.T();
        this.a(s, z);
    }

    public void R() {
        this.T();
        this.N();
    }

    boolean S() {
        this.l.a(1, -1L, 1L, 0, 1, "");
        return this.aa.a(true);
    }

    void T() {
        this.l.a(2, -1L, 1L, 0, 1, "");
        this.aa.b(true);
        this.k.l();
        this.k.k();
        this.az = false;
    }

    private void V() {
        if(this.p == null) {
            return;
        }
        if(this.ay || (Config.B & 4) != 0 && this.j.b()) {
            this.i(false);
        }
        this.K();
    }

    private void W() {
        this.I();
        this.d(true);
        this.ao.a();
        this.aD = true;
        this.av.setVisibility(4);
        this.ab.b();
        this.l.k();
        this.aF.clear();
        this.an.c();
        this.k.s();
    }

    private void X() {
        ConfigListAdapter configListAdapter0 = new ConfigListAdapter();
        this.aq = configListAdapter0;
        this.S.setAdapter(configListAdapter0);
        this.S.setOnItemClickListener(configListAdapter0);
    }

    private void Y() {
    }

    @TargetApi(14)
    private void Z() {
        if(Build.VERSION.SDK_INT >= 14) {
            MainService.context.registerComponentCallbacks(MainService.A());
        }
    }

    static int a() {
        return MainService.instance.aj == 0L ? 0x7F : MainService.aE;
    }

    static void a(int v, int v1) {
        MainService.aE = v & 0x7F;
        if(v1 == 0) {
            MainService.ai = v & 0x7F;
        }
    }

    public static void a(Configuration configuration0) {
        la.a(("Main onConfigurationChanged: " + configuration0));
        if(MainService.aL) {
            return;
        }
        try {
            MainService.aL = true;
            Tools.a(configuration0);
            if(!ad.c().equals(Locale.getDefault().toString())) {
                ad.d();
            }
            if(MainService.instance != null && MainService.instance.l != null) {
                MainService.instance.l.c();
            }
            if(MainService.c) {
                MainService.instance.s();
            }
        }
        finally {
            MainService.aL = false;
        }
    }

    private void a(Long long0, long v) {
        Long long1;
        if(long0 == null) {
            int v1 = this.J.getFirstVisiblePosition();
            if(this.J.getChildCount() > 1 && this.J.getChildAt(0).getTop() < 0) {
                ++v1;
            }
            Object object0 = this.J.getItemAtPosition(v1);
            long1 = object0 instanceof iq ? ((iq)object0).b() : null;
            if(object0 instanceof d) {
                long1 = ((d)object0).b;
            }
        }
        else {
            long1 = long0;
        }
        if(long1 != null) {
            long v2 = (long)long1;
            if(v2 != v && v2 != this.L.a()) {
                int v3 = this.K.b(v2) - this.J.getFirstVisiblePosition();
                int v4 = v3 < 0 || v3 >= this.J.getChildCount() ? 0 : this.J.getChildAt(v3).getTop();
                this.L.a(v2, Tools.c(0x7F0702C0), v4);  // string:position_in_memory_editor "Position in the memory editor"
            }
        }
    }

    private void a(String s, int v, int v1) {
        TabHost.TabSpec tabHost$TabSpec0 = this.o.newTabSpec(s);
        tabHost$TabSpec0.setContent(v);
        ImageView imageView0 = Config.a(((ImageView)this.o.findViewById(v1)));
        if(Build.VERSION.SDK_INT >= 21) {
            tabHost$TabSpec0.setIndicator("", imageView0.getDrawable());
        }
        else {
            try {
                tabHost$TabSpec0.setIndicator(android.fix.i.a(0x7F040027, this.o.getTabWidget(), false));  // layout:tab_indicator_holo
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
                tabHost$TabSpec0.setIndicator("", imageView0.getDrawable());
            }
        }
        try {
            this.o.addTab(tabHost$TabSpec0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
            tabHost$TabSpec0.setIndicator("");
            try {
                this.o.addTab(tabHost$TabSpec0);
            }
            catch(IllegalArgumentException illegalArgumentException1) {
                la.a(illegalArgumentException1);
                tabHost$TabSpec0.setIndicator("", imageView0.getDrawable());
                this.o.addTab(tabHost$TabSpec0);
            }
        }
    }

    private static void a(List list0, File file0) {
        if(file0 == null) {
            return;
        }
        MainService.a(list0, file0.getAbsolutePath());
    }

    private static void a(List list0, String s) {
        if(s == null || s.length() == 0) {
            return;
        }
        if(s.contains("/emulated/0")) {
            MainService.b(list0, s.replace("/emulated/0", "/emulated/legacy"));
        }
        MainService.b(list0, s);
    }

    private void a(int[] arr_v) {
        if(arr_v != null && arr_v.length == 2) {
            int v = arr_v[0];
            up[] arr_up = this.aP;
            if(v >= 0 && v < 4) {
                up up0 = arr_up[v];
                if(up0 == null) {
                    up0 = new up(v);
                    arr_up[v] = up0;
                }
                up0.a(arr_v[1]);
            }
        }
    }

    private void a(pj[][] arr2_pj) {
        this.P = new ik();
        this.Q = new ra();
        this.R = new ov();
        arr2_pj[0] = new pj[]{new hy(), this.Q, new EditorListener(), new ol(this, false), this.P, new os(this), new rz(), new op(this), new ou(this), new eo(), this.R, new oh(this), new qo(), new of(this), new oe(this), new oj(this), new ob(this), new uf(), new qe(), new OffsetCalculator(), this.E, new oa(this, 0x7F070109, 0x7F02004D), new oi(this)};  // string:speedhack "Speedhack"
        this.D.setAdapter(new AddressArrayAdapter(this.am));
        this.D.setOnItemClickListener(new EditorListener());
        this.D.setOnItemLongClickListener(new ItemContextMenu(1));
        new FastScrollerFix(this.D);
        this.P();
    }

    public Notification a(boolean z, boolean z1) {
        Notification notification2;
        Notification notification0;
        int v;
        PendingIntent pendingIntent0 = tx.a(0);
        if(!rv.a) {
            v = this.p == null || ar.d == null || !ar.d.i() ? 0x7F070206 : 0x7F070207;  // string:show_gg "Show __app_name__"
        }
        else if(this.p != null) {
            v = 0x7F070207;  // string:hide_gg "Hide __app_name__"
        }
        else {
            v = 0x7F070206;  // string:show_gg "Show __app_name__"
        }
        String s = qk.a(v);
        int v1 = Build.VERSION.SDK_INT >= 21 ? 0x7F020039 : 0x7F02002C;  // drawable:ic_notify
        if(Build.VERSION.SDK_INT >= 11) {
            try {
                Context context0 = MainService.context.getApplicationContext();
                if(z1) {
                    context0 = Config.a(context0);
                }
                Notification.Builder notification$Builder0 = new Notification.Builder(context0).setContentTitle(s).setContentText("").setContentIntent(pendingIntent0).setAutoCancel(false).setOngoing(true);
                if(z) {
                    notification$Builder0.setSmallIcon(v1);
                    if(Build.VERSION.SDK_INT >= 16) {
                        int v2 = Build.VERSION.SDK_INT < 21 ? 0x7F020013 : 0x7F020011;  // drawable:ic_cellphone_screenshot_white_32dp
                        String s1 = qk.a(0x7F070317);  // string:screenshot_action "Screenshot"
                        PendingIntent pendingIntent1 = tx.a(1);
                        if(Build.VERSION.SDK_INT >= 20) {
                            notification$Builder0.addAction((Build.VERSION.SDK_INT < 23 ? new Notification.Action.Builder(v2, s1, pendingIntent1) : new Notification.Action.Builder(Icon.createWithResource(Tools.g(), v2), s1, pendingIntent1)).build());
                        }
                        else {
                            notification$Builder0.addAction(v2, s1, pendingIntent1);
                        }
                    }
                }
                notification0 = Build.VERSION.SDK_INT < 16 ? notification$Builder0.getNotification() : notification$Builder0.build();
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                notification0 = null;
            }
        }
        else {
            notification0 = null;
        }
        if(notification0 == null) {
            Notification notification1 = new Notification();
            if(z) {
                notification1.icon = v1;
            }
            try {
                notification1.tickerText = s;
                notification1.contentIntent = pendingIntent0;
                Notification.class.getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification1, MainService.context.getApplicationContext(), s, "", pendingIntent0);
            }
            catch(Throwable throwable1) {
                la.b("Method not found", throwable1);
            }
            notification2 = notification1;
        }
        else {
            notification2 = notification0;
        }
        notification2.flags = 34;
        return notification2;
    }

    FloatPanel a(String s, int v, int v1, int v2, int v3) {
        FloatPanel floatPanel0 = new mn(this, MainService.context, s, v, v1);
        android.fix.ImageButton imageButton0 = new android.fix.ImageButton(MainService.context);
        imageButton0.setImageResource(v3);
        imageButton0.setKeepScreenOn(true);
        imageButton0.setId(v2);
        imageButton0.setOnClickListener(MainService.instance);
        floatPanel0.addView(imageButton0);
        return floatPanel0;
    }

    void a(byte b) {
        this.a(b, false);
    }

    public void a(byte b, double f) {
        this.b(b, f);
        this.ab.a(f);
    }

    public void a(byte b, int v, int[] arr_v) {
        int v2;
        int v1 = 1;
        switch(v) {
            case 0: {
                Tools.s().edit().putBoolean("mem-fail", true).commit();
                return;
            }
            case 1: {
                Tools.s().edit().remove("mem-fail").commit();
                return;
            }
            case 3: {
                this.T();
                if(b == 0) {
                    Tools.a(0x7F0701AA, 0);  // string:dump_ended "Dump ended"
                }
                this.a(b, null);
                return;
            }
            case 4: {
                this.T();
                if(b == 0) {
                    Tools.a(0x7F0701AB);  // string:dump_failed "Dump failed"
                }
                this.a(b, qk.a(0x7F0701AB));  // string:dump_failed "Dump failed"
                return;
            }
            case 5: {
                if(b == 0) {
                    Tools.a(0x7F0701B5, 0);  // string:copy_ended "Copy memory ended"
                }
                this.a(b, null);
                return;
            }
            case 6: {
                if(b == 0) {
                    Tools.a(0x7F0701B6);  // string:copy_failed "Copy memory failed"
                }
                this.a(b, qk.a(0x7F0701B6));  // string:copy_failed "Copy memory failed"
                return;
            }
            case 8: {
                this.O = true;
                return;
            }
            case 9: {
                this.O = false;
                return;
            }
            case 10: {
                if(b == 0) {
                    Tools.a(0x7F070220, 0);  // string:speedhack_loading "Loading speedhack..."
                    return;
                }
                break;
            }
            case 11: {
                if(b == 0) {
                    String s = qk.a(0x7F070221);  // string:speedhack_loaded "Speedhack is loaded."
                    if(this.aO) {
                        s = s + "\n" + qk.a(0x7F07032E);  // string:speedhack_no_x86 "But in this game is no x86 libraries, so maybe it will 
                                                          // not work."
                    }
                    if(!this.aO) {
                        v1 = 0;
                    }
                    Tools.a(s, v1);
                }
                this.aO = false;
                return;
            }
            case 12: {
                if(b == 0) {
                    Tools.a(0x7F070272, 0);  // string:patch_loading "Loading patch..."
                    return;
                }
                break;
            }
            case 13: {
                if(b == 0) {
                    Tools.a(0x7F070273);  // string:patch_loaded "Patch is loaded."
                    i.a(i.c().setCustomTitle(Tools.d(0x7F070270)).setMessage(qk.a(0x7F070271)).setPositiveButton(qk.a(0x7F07009D), null));  // string:disable_protection "Disable protection for all applications (until reboot)"
                }
                this.a(b, null);
                return;
            }
            case 14: {
                if(b == 0) {
                    Tools.a(0x7F070274);  // string:patch_failed "Patch is not loaded."
                }
                this.a(b, qk.a(0x7F070274));  // string:patch_failed "Patch is not loaded."
                return;
            }
            case 15: {
                if(b == 0) {
                    Tools.a(0x7F07027F, 0);  // string:unrandomizer_loading "Loading unrandomizer..."
                    return;
                }
                break;
            }
            case 16: {
                if(b == 0) {
                    String s1 = qk.a(0x7F070280);  // string:unrandomizer_loaded "Unrandomizer is loaded."
                    if(this.aO) {
                        s1 = s1 + "\n" + qk.a(0x7F07032E);  // string:speedhack_no_x86 "But in this game is no x86 libraries, so maybe it will 
                                                            // not work."
                    }
                    if(!this.aO) {
                        v1 = 0;
                    }
                    Tools.a(s1, v1);
                }
                this.aO = false;
                return;
            }
            case 17: {
                if(b == 0) {
                    i.a(i.c().setCustomTitle(Tools.d(0x7F070295)).setMessage(qk.a(0x7F070296)).setPositiveButton(qk.a(0x7F070291), new ng(this)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:waitpid_mode "__waitpid__ mode:"
                    return;
                }
                break;
            }
            case 18: {
                this.a(b, null);
                return;
            }
            case 19: {
                this.a(arr_v);
                return;
            }
            case 20: {
                i.a(i.c().setMessage(qk.a(0x7F0702ED) + "\n\n" + qk.a((arr_v[0] == 0 ? 0x7F0702EF : 0x7F0702EE)) + "\n\n" + qk.a(0x7F0702F0)).setPositiveButton(qk.a(0x7F07009D), null));  // string:ptrace_fail "Failed to change memory through ptrace."
                return;
            }
            case 21: {
                if(arr_v[1] != 0) {
                    v2 = 0x7F0702F1;  // string:feature_hide_4 "This feature cannot work if the fourth item is selected in 
                                      // \"__hide_from_game__\"."
                }
                else if(arr_v[2] == 0) {
                    if(this.aN && (Config.A & 0x20000) != 0) {
                        this.aN = false;
                        Config.a(0x7F0B0088).d();  // id:config_ptrace_bypass_mode
                    }
                    v2 = 0x7F0702F3;  // string:feature_protection "This feature cannot work due to ptrace protection in 
                                      // the game."
                }
                else {
                    v2 = 0x7F0702F2;  // string:feature_firmware "This feature cannot work without ptrace, which does not 
                                      // work on this firmware."
                }
                Tools.a(qk.a(v2), 1);
                return;
            }
            case 22: {
                this.aO = true;
            }
        }
    }

    public void a(byte b, long v, long v1, int v2) {
        boolean z = true;
        this.aj = v;
        if(v2 == 0) {
            this.T();
            MainService.aM = true;
            if(b == 0) {
                if(Config.k != 0 && v > 0L) {
                    this.g();
                    Tools.b((qk.a(0x7F070177) + ' ' + Tools.a(qk.a(0x7F0700C9), new Object[]{v})));  // string:search_helper "Search helper:"
                    if(Config.k != 2) {
                        z = false;
                    }
                    MainService.aA = z;
                }
                else {
                    this.j(true);
                }
            }
        }
        if(this.aj == 0L) {
            this.a(0, false, false);
        }
    }

    public void a(byte b, String s) {
        if(b == 0) {
            la.a(("notifyScript client: " + s));
            return;
        }
        Script script0 = this.d;
        if(script0 != null) {
            la.a(("notifyScript: " + ((int)b) + "; " + s));
            script0.a(b, s);
            return;
        }
        la.a(("notifyScript no script: " + ((int)b) + "; " + s));
    }

    void a(byte b, boolean z) {
        this.a(b, z, true);
    }

    void a(byte b, boolean z, boolean z1) {
        if(z) {
            this.al = true;
        }
        this.aj = 0L;
        if(z1) {
            this.k.h(b);
        }
        MainService.instance.k.e.b();
        synchronized(this.am) {
            this.am.c();
            this.am.a();
        }
        this.a(this.D.getAdapter());
        this.P();
        MainService.aA = false;
    }

    public void a(int v) {
        this.o.setCurrentTab(v);
    }

    void a(long v) {
        rx.a(new nd(this, v));
    }

    public void a(long v, int v1) {
        this.K.a(v, v1);
        if(this.X == this.V) {
            Tools.f(this.M);
            return;
        }
        this.o.setCurrentTab(3);
    }

    public void a(Script script0) {
        rx.a(new mi(this));
    }

    public void a(bk bk0) {
        boolean z1;
        int v7;
        long[] arr_v3;
        int[] arr_v2;
        int v6;
        int v5;
        tp tp0 = Tools.a(this.D);
        int v = bk0.h();
        try {
            bk0.g();
            int v1 = bk0.e() - bk0.f() - 1;
            bk0.b();
            a a0 = this.am;
            int v2 = 0;
            d d0 = new d();
            synchronized(a0) {
                boolean z = MainService.aM;
                MainService.aM = false;
                if(z) {
                    v6 = 0;
                    arr_v2 = null;
                    arr_v3 = null;
                }
                else {
                    try {
                        int v4 = a0.b();
                        long[] arr_v = new long[v4];
                        int[] arr_v1 = new int[v4];
                        d d1 = new d();
                        v5 = 0;
                        while(true) {
                        label_18:
                            if(v5 >= v4) {
                                v6 = v2;
                                arr_v2 = arr_v1;
                                arr_v3 = arr_v;
                                goto label_43;
                            }
                            if(a0.b(v5)) {
                                a0.a(v5, d1);
                                arr_v[v2] = d1.b;
                                v7 = v2 + 1;
                                arr_v1[v2] = d.a(d1.d);
                            }
                            else {
                                v7 = v2;
                            }
                            break;
                        }
                    }
                    catch(OutOfMemoryError outOfMemoryError1) {
                        la.c("Failed save checked data", outOfMemoryError1);
                        v6 = 0;
                        arr_v2 = null;
                        arr_v3 = null;
                        goto label_43;
                    }
                    ++v5;
                    v2 = v7;
                    goto label_18;
                }
            label_43:
                a0.c();
                int v8 = v1 / (InOut.b + 12);
                if(v == 0 && v8 > 0) {
                    v8 = 0;
                }
                a0.a(v8);
                int v9 = 0;
                while(v1 - bk0.f() > 10 && (v != 0 || a0.b() < 0)) {
                    long v10 = bk0.c();
                    long v11 = bk0.d();
                    int v12 = bk0.b();
                    d0.b = v10;
                    d0.d = v12;
                    if(arr_v3 != null) {
                        int v13 = d.a(v12);
                        while(v9 < v6) {
                            long v14 = arr_v3[v9];
                            if(v14 == v10) {
                                int v15 = arr_v2[v9];
                                if(v15 == v13) {
                                }
                                else if(v15 <= v13) {
                                    ++v9;
                                    continue;
                                }
                                else {
                                    z1 = z;
                                    goto label_74;
                                }
                                z1 = true;
                                ++v9;
                                goto label_74;
                            }
                            if(!Tools.a(v14, v10)) {
                                break;
                            }
                            ++v9;
                        }
                    }
                    z1 = z;
                label_74:
                    a0.a(v10, v11, v12, z1);
                }
                a0.a();
            }
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            this.am.c();
            this.am.a();
            Tools.a(0x7F0700C7);  // string:out_of_memory_error "Out of memory error. Current result list cleared. Please 
                                  // set a smaller value for the number of results to show."
            la.b(("list.size() = " + this.am.b() + "; show count = " + 0), outOfMemoryError0);
        }
        catch(IOException iOException0) {
            la.c("Failed read", iOException0);
        }
        this.a(this.D.getAdapter());
        this.P();
        Tools.a(this.D, tp0);
        MainService.instance.E();
        this.a(((byte)v), null);
    }

    public void a(qh qh0) {
        boolean z = this.ap == null || qh0 == null || this.ap.f != qh0.f;
        if(z) {
            MainService.aG = true;
            this.W();
        }
        Config.c();
        this.ap = qh0;
        Config.b();
        this.aq.b();
        if(qh0 != null) {
            Drawable drawable0 = Tools.a(qh0.e);
            this.au.setImageDrawable(drawable0);
            if(qh0.e == null) {
                la.c(("setProcessInfo icon is null: " + qh0));
            }
            this.s.setText(qh0.toString());
            Drawable drawable1 = Tools.a(qh0.e);
            this.l.a(drawable1);
            this.k.a(qh0.f, qh0.c, qh0.d);
        }
        this.ae.b();
        this.ag.b();
        this.V();
        if(z) {
            this.x();
        }
    }

    public void a(qm qm0) {
        rx.a(new ml(this));
        if(this.h == qm0) {
            this.h = null;
        }
    }

    void a(ListAdapter listAdapter0) {
        if(listAdapter0 == null) {
            return;
        }
        rx.a(new mq(this, listAdapter0));
    }

    void a(ListView listView0) {
        if(listView0 == null) {
            return;
        }
        this.a(listView0.getAdapter());
    }

    public void a(CharSequence charSequence0) {
        this.a(charSequence0, -1L, 1L, 0, 1, 0L);
    }

    public void a(CharSequence charSequence0, long v, long v1, int v2, int v3, long v4) {
        StringBuilder stringBuilder1;
        if(v <= 0L || v1 == 0L) {
            stringBuilder1 = null;
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(Tools.a("%.2f", new Object[]{((double)(100.0 * ((double)v) / ((double)v1)))}));
            stringBuilder0.append(" %");
            stringBuilder1 = stringBuilder0;
        }
        this.aa.a(charSequence0, v, v1, v2, v3, v4, (stringBuilder1 == null ? "" : stringBuilder1.toString()));
        if(stringBuilder1 != null) {
            stringBuilder1.setLength(4);
            stringBuilder1.append('%');
        }
        this.l.a(0, v, v1, v2, v3, (stringBuilder1 == null ? "" : stringBuilder1.toString()));
    }

    public void a(Long long0, String s, CharSequence charSequence0) {
        iw.a(s, 1);
        long v = 0L;
        int v1 = s.length();
        int v2 = 0;
    label_4:
        while(v2 < v1) {
            int v3 = s.indexOf(45, v2 + 1);
            int v4 = s.indexOf(43, v2 + 1);
            v4 = v4 != -1 && (v3 == -1 || v3 >= v4) ? s.indexOf(43, v2 + 1) : v3;
            int v5 = v4 == -1 ? v1 : v4;
            String s1 = s.substring(v2, v5).trim();
            int v6 = s1.length();
            if(v6 > 0) {
                for(Object object0: RegionList.getList()) {
                    qs qs0 = (qs)object0;
                    if(qs0.d != null && qs0.d.length() >= v6 && qs0.d.endsWith(s1) && (qs0.d.length() == s1.length() || qs0.d.charAt(qs0.d.length() - s1.length() - 1) == 0x2F)) {
                        v += qs0.b;
                        v2 = v5;
                        continue label_4;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            try {
                v += ps.a((s1.endsWith("h") ? s1.substring(0, s1.length() - 1) : s1), 16);
            }
            catch(Throwable throwable0) {
                la.a("Failed parse", throwable0);
            }
            v2 = v5;
        }
        this.a(long0, v);
        this.L.a(v, charSequence0);
        this.b(v);
    }

    void a(Object object0) {
        if(object0 instanceof e) {
            ArrayList arrayList0 = new ArrayList();
            int v1 = ((e)object0).b();
            for(int v = 0; v < v1; ++v) {
                if(((e)object0).d(v)) {
                    qx qx0 = (qx)((e)object0).c(v);
                    if(qx0 instanceof qx) {
                        arrayList0.add(qx0);
                    }
                }
            }
            this.an.a(arrayList0);
            return;
        }
        if(object0 instanceof a) {
            ArrayList arrayList1 = new ArrayList();
            int v2 = ((a)object0).b();
            for(int v3 = 0; v3 < v2; ++v3) {
                if(((a)object0).b(v3)) {
                    arrayList1.add(((a)object0).a(v3, null));
                }
            }
            this.k.a(arrayList1);
            this.j(false);
        }
    }

    void a(Object object0, g g0) {
        g g1 = g0 == null ? new g() : g0;
        g g2 = this.ao;
        h h0 = new h();
        if(object0 instanceof a) {
            d d0 = new d();
            int v = ((a)object0).b();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((a)object0).b(v1)) {
                    ((a)object0).a(v1, d0);
                    g2.a(d0.b, d0.d, h0);
                    if(h0.b) {
                        g1.a(d0.b, d0.d, h0.a);
                    }
                }
            }
        }
        else if(object0 instanceof e) {
            int v2 = ((e)object0).b();
            for(int v3 = 0; v3 < v2; ++v3) {
                if(((e)object0).d(v3)) {
                    qx qx0 = (qx)((e)object0).c(v3);
                    if(qx0 instanceof qx) {
                        g2.a(qx0.b, qx0.d, h0);
                        if(h0.b) {
                            g1.a(qx0.b, qx0.d, h0.a);
                        }
                    }
                }
            }
        }
        if(g0 == null) {
            g1.c();
        }
    }

    public void a(Runnable runnable0) {
        if(runnable0 == null) {
            ArrayList arrayList0 = this.aH;
            this.aH = new ArrayList();
            for(Object object0: arrayList0) {
                Runnable runnable1 = (Runnable)object0;
                try {
                    runnable1.run();
                }
                catch(Throwable throwable0) {
                    la.b("Failed showScriptEnd", throwable0);
                }
            }
            return;
        }
        if(this.p != null) {
            try {
                runnable0.run();
            }
            catch(Throwable throwable1) {
                la.b("Failed showScriptEnd", throwable1);
            }
            return;
        }
        this.aH.add(runnable0);
    }

    public void a(String s, int v, String s1) {
        this.p();
        Script script0 = new Script(new File(s), v, s1);
        this.d = script0;
        script0.c_();
    }

    void a(String s, boolean z) {
        String[] arr_s = {qk.a(0x7F0700B8), qk.a(0x7F07019E), qk.a(0x7F070047), qk.a(0x7F07026E), qk.a(0x7F07009D)};  // string:exit "Exit"
        i.a(i.c().setCustomTitle(Tools.d(0x7F0700B7)).setItems(arr_s, new nl(this, s, z)).setCancelable(false));  // string:game_dead "Game dead"
    }

    void a(boolean z) {
        this.j.a(z);
    }

    @TargetApi(14)
    private void aa() {
        if(Build.VERSION.SDK_INT >= 14) {
            MainService.context.unregisterComponentCallbacks(MainService.A());
        }
    }

    static int b() {
        return MainService.instance.aj != 0L && (MainService.aE & MainService.ai) != MainService.ai ? MainService.aE : MainService.ai;
    }

    private String b(String s) {
        return this.ap == null ? s : s + "\n\n" + this.ap.b + "\n[" + this.ap.c + "]";
    }

    private void b(byte b, double f) {
        kz kz0 = ky.c(f);
        this.k.a(b, kz0.a, kz0.b);
        this.l.b(ky.b(((double)kz0.a) / ((double)kz0.b)));
    }

    public static void b(int v) {
        la.b(("onTrimMemory: " + v));
        if(MainService.instance == null) {
            return;
        }
        qk.a();
        qf.a();
        MainService.instance.c(v);
    }

    private static void b(List list0, String s) {
        if(s == null || s.length() == 0) {
            return;
        }
        Iterator iterator0 = list0.iterator();
        do {
            if(!iterator0.hasNext()) {
                list0.add(s);
                return;
            }
            Object object0 = iterator0.next();
        }
        while(!((String)object0).equals(s));
    }

    private void b(pj[][] arr2_pj) {
        arr2_pj[1] = new pj[]{new mg(this, 0x7F0701A3, 0x7F020058), new op(this), new ou(this), new mh(this, 0x7F0701A4, 0x7F02001F), new ol(this, true), new EditorListener(), new oh(this), new of(this), new oj(this), new eo(), new ob(this), new b(), new oe(this), new OffsetCalculator(), this.F};  // string:load_saved_list "Load the saved list from the file"
        this.I.setAdapter(this.an);
        this.I.setOnItemClickListener(new EditorListener());
        this.I.setOnItemLongClickListener(new ItemContextMenu(2));
        new FastScrollerFix(this.I);
        SavedListAdapter.a();
        this.w();
    }

    public long b(long v, int v1) {
        this.i();
        return this.k.a(v, v1);
    }

    void b(byte b) {
        if(this.aD) {
            this.a(false);
            qh qh0 = this.ap;
            if(qh0 != null) {
                this.k.a(b, qh0.f, qh0.c, qh0.d);
                this.aD = false;
                this.av.setVisibility(0);
                if(!this.Y.getText().toString().startsWith(qk.a(0x7F070000) + ' ' + this.k.x())) {  // string:version_number "101.1"
                    rx.a().postDelayed(new nu(this), ((long)(Tools.a.nextInt(300000) + 180000)));
                }
            }
        }
    }

    void b(int v, int v1) {
        this.ac = v;
        this.ad = v1;
    }

    public void b(long v) {
        this.a(v, 0);
    }

    public void b(Script script0) {
        rx.a(new mk(this));
        if(this.d == script0) {
            this.d = null;
        }
    }

    public void b(bk bk0) {
        this.K.a(bk0);
    }

    public void b(qm qm0) {
        this.q();
        this.h = qm0;
        rx.a(new mm(this));
    }

    void b(boolean z) {
        if(this.p != null) {
            return;
        }
        if(z) {
            this.Z.f();
            return;
        }
        this.Z.b(true);
    }

    boolean b(byte b, boolean z) {
        boolean z1 = false;
        if(!z && this.p == null) {
            return false;
        }
        this.i();
        this.k.a(b, ((byte)(this.N ? 1 : 0)));
        if(!this.N) {
            z1 = true;
        }
        this.N = z1;
        this.K();
        return true;
    }

    @TargetApi(11)
    private void c(pj[][] arr2_pj) {
        this.L = new pf();
        ow ow0 = new ow();
        this.K = ow0;
        pj pj0 = ow0.k();
        this.t.setOnClickListener(pj0);
        arr2_pj[2] = new pj[]{new EditorListener(), new of(this), new os(this), new in(), new pi(this.L), new ph(this.L), new eo(), new oj(this), new op(this), new oe(this), new ob(this), new gw(), new em(), new w(), new OffsetCalculator(), new ou(this), new oh(this), this.F, pj0};
        try {
            this.J.setAdapter(ow0);
            this.J.setOnItemClickListener(new EditorListener(true));
            this.J.setOnItemLongClickListener(new ItemContextMenu(3));
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            la.a(outOfMemoryError0);
        }
        FastScrollerFix.a(this.J, true);
    }

    void c() {
        la.a(("stopHotkeyDetection: " + this.l));
        if(this.l == null) {
            return;
        }
        this.l.f();
    }

    public void c(int v) {
        if(this.k != null && v >= 80) {
            this.k.q();
        }
    }

    void c(boolean z) {
        la.a(("ServiceProxy dismissDialog: " + this.p));
        if(this.p == null) {
            return;
        }
        this.aa.b(false);
        this.p.dismiss();
        this.p = null;
        this.Z.b(z);
        this.l.d();
        this.ay = this.N;
        boolean z1 = this.O;
        boolean z2 = (Config.A & 0x80) != 0;
        if(this.aa.a() && (z2 || z1)) {
            String s = Tools.c(0x7F07021C) + ":\n";  // string:paused "The game is paused:"
            String s1 = z2 ? s + "- " + Tools.a(qk.a(0x7F07021E), new Object[]{Tools.c(0x7F07014C) + ": 1"}) + ";\n" : s;  // string:by_option "by the option \'__s__\'"
            if(z1) {
                s1 = (Config.B & 4) == 0 ? s1 + "- " + qk.a(0x7F07021D) + ";\n" : s1 + "- " + Tools.a(qk.a(0x7F07021E), new Object[]{Tools.c(0x7F070141) + ": " + qk.a(0x7F07009B)}) + ";\n";  // string:by_pause_button "by the pause button"
            }
            String s2 = s1.trim();
            if(this.az) {
                Tools.b(s2);
            }
            else {
                this.az = true;
                i.c(i.a(ar.f).setMessage(s2).setNegativeButton(qk.a(0x7F07009D), null).create());  // string:ok "OK"
            }
        }
        this.I();
        this.k.k();
        this.u();
    }

    boolean c(byte b) {
        if(this.N) {
            this.i();
            this.k.a(b, 1);
            this.N = false;
            this.K();
            return true;
        }
        return false;
    }

    boolean c(byte b, boolean z) {
        if((z || this.p != null) && !this.N) {
            this.i();
            this.k.a(b, 0);
            this.N = true;
            this.K();
            return true;
        }
        return false;
    }

    void d() {
        la.a(("startHotkeyDetection: " + this.l));
        if(this.l == null) {
            return;
        }
        this.l.d();
        this.k.k();
    }

    void d(int v) {
        Tools.a(this.C(), v);
        this.D();
    }

    void d(boolean z) {
        this.a(0, z);
    }

    boolean d(byte b) {
        qh qh0 = this.ap;
        if(qh0 == null) {
            Tools.b(qk.a(0x7F0700BD));  // string:no_application "No application has been selected."
            return false;
        }
        la.a("Kill game");
        this.k.a(b, qh0.f, qh0.c, qh0.d);
        this.k.a(b, 2);
        return true;
    }

    public void e() {
        if(this.X == this.T || this.X == this.U || this.X == this.V) {
            Tools.f(this.G);
        }
    }

    public void e(byte b) {
        this.k.g(b);
        this.an.d();
        this.j(false);
        this.a(this.J);
        this.a(this.I);
    }

    public void e(int v) {
        if(Config.w != 0 && v == Config.w) {
            rx.a(new nh(this));
        }
    }

    public void e(boolean z) {
        if(z) {
            this.i();
        }
        double f = this.ab.c();
        this.b(0, f);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.setSpeed(");
            qm0.write(Double.toString(f));
            qm0.write(")\n");
        }
    }

    void f() {
        la.a(("ServiceProxy showDialog: " + this.p));
        if(this.p != null) {
            la.a("Something going wrong", new RuntimeException("mainDialog != null"));
            this.p.dismiss();
        }
        this.p = new me(MainService.context, this.o);
        for(int v = 0; v < this.B.length; ++v) {
            this.B[v].setFill(Config.g - 1);
        }
        rx.a(new nt(this));
        this.Z.f();
        this.j.a(this.aD, null);
        this.l.f();
        this.V();
        this.k.k();
        if(!this.aa.a()) {
            this.x();
            if(MainService.aA) {
                MainService.aA = false;
                if(this.am.b() == 0 && this.aj != 0L) {
                    this.j(false);
                }
                if(ex.b) {
                    this.P.onClick(this.G);
                }
                else {
                    this.Q.onClick(this.G);
                }
            }
        }
        this.u();
        this.a(null);
    }

    public void f(int v) {
        int v3;
        String s;
        int v1 = 0x7F0700B6;  // string:io_error "IO error"
        this.T();
        int v2 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
        switch(v) {
            case 1: {
                v1 = 0x7F0700B3;  // string:out_of_memory "Out of memory"
                s = null;
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            case 2: {
                v1 = 0x7F0700B4;  // string:bug_detected "Bug detected"
                s = null;
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            case 3: {
                v1 = 0x7F0700B5;  // string:disk_full "Disk full"
                s = null;
                v3 = 0x7F0702EA;  // string:fix_path "Free space or specify a different path for temporary files by clicking 
                                  // \"__fix_it__\"."
                break;
            }
            case 4: {
                s = null;
                v3 = 0x7F0702EA;  // string:fix_path "Free space or specify a different path for temporary files by clicking 
                                  // \"__fix_it__\"."
                break;
            }
            case 9: {
                String s1 = qk.a(0x7F0702FF) + "\n\n" + qk.a(0x7F070300);  // string:maps_failed "Could not open \"__maps__\" file."
                if(Config.C) {
                    s1 = s1 + "\n\n" + qk.a(0x7F070301);  // string:need_root "Need root to hack this game."
                }
                s = this.b(s1);
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            case 10: {
                s = qk.a(0x7F0702FF) + "\n\n" + qk.a((Config.C ? 0x7F070302 : 0x7F070303));  // string:maps_failed "Could not open \"__maps__\" file."
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            case 105: {
                if(Config.C) {
                    try {
                        if((Tools.j(Config.E).flags & 2) == 0) {
                            s = Tools.a(qk.a(0x7F0702E9), new Object[]{Config.F, Config.F});  // string:not_optimized2 "You are using a non-optimized version of the virtual space 
                                                                                              // (\"__s__\").\nTo fix this error, remove the non-optimized version of \"__s__\" and 
                                                                                              // install one of the optimized virtual spaces from the official site __app_name__.\nClick 
                                                                                              // \"__fix_it__\" to go to the selection of optimized virtual spaces."
                            v2 = 0x7F0702E9;  // string:not_optimized2 "You are using a non-optimized version of the virtual space 
                                              // (\"__s__\").\nTo fix this error, remove the non-optimized version of \"__s__\" and 
                                              // install one of the optimized virtual spaces from the official site __app_name__.\nClick 
                                              // \"__fix_it__\" to go to the selection of optimized virtual spaces."
                        }
                        else {
                            s = null;
                        }
                    }
                    catch(Throwable throwable0) {
                        la.b(("Failed check vSpace: " + Config.E), throwable0);
                        s = null;
                    }
                }
                else {
                    s = null;
                }
                if(v2 == 0x7F0700B1) {  // string:reset_search "ERROR detected. Reset search list."
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append(qk.a(0x7F0702AC));  // string:eperm_error_descr_0 "Possible reasons:"
                    stringBuilder0.append('\n');
                    stringBuilder0.append(1);
                    stringBuilder0.append(": ");
                    stringBuilder0.append(qk.a(0x7F0702AF));  // string:eperm_error_descr_3 "Insufficient permissions. Usually due to incorrectly 
                                                              // configured __selinux__. Disable or configure __selinux__."
                    stringBuilder0.append('\n');
                    stringBuilder0.append(2);
                    stringBuilder0.append(": ");
                    if(Config.C) {
                        stringBuilder0.append(qk.a(0x7F0702B1));  // string:eperm_error_descr_5 "On your firmware, the \"no root\" mode does not work. 
                                                                  // Try another firmware or other device or get root."
                    }
                    else {
                        stringBuilder0.append(qk.a(0x7F0702B0));  // string:eperm_error_descr_4 "Bad kernel or firmware. Try another firmware or other 
                                                                  // device."
                    }
                    s = stringBuilder0.toString();
                    v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                }
                else {
                    v3 = v2;
                }
                break;
            }
            case 106: {
                v1 = 0x7F0701AC;  // string:eperm_error_defend "Could not attach to process (PTRACE_ATTACH): Game is 
                                  // protected"
                s = this.b(qk.a(0x7F0702AC) + '\n' + 1 + ": " + qk.a(0x7F0702AD) + '\n' + 2 + ": " + qk.a(0x7F0702AE));  // string:eperm_error_descr_0 "Possible reasons:"
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            case 107: {
                v1 = 0x7F070112;  // string:speedhack_fail "Speedhack for this process is not supported"
                s = null;
                v3 = 0x7F070112;  // string:speedhack_fail "Speedhack for this process is not supported"
                break;
            }
            case 108: {
                v1 = 0x7F0700AE;  // string:error "Error"
                s = Tools.c(0x7F07011F) + ": " + 0x40;  // string:too_many_union_numbers "Too many numbers, more than:"
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
                break;
            }
            default: {
                v1 = 0x7F0700B2;  // string:unknown_error "Unknown error"
                s = null;
                v3 = 0x7F0700B1;  // string:reset_search "ERROR detected. Reset search list."
            }
        }
        String s2 = s == null ? qk.a(v3) : s;
        String s3 = qk.a(v1);
        String s4 = "{" + v + '}';
        if(this.aF.get(v)) {
            long v4 = System.currentTimeMillis();
            if(MainService.aQ < v4) {
                MainService.aQ = v4 + 2000L;
                Tools.a((s4 + qk.a(v1)), 0);
            }
            if(v <= 100) {
                this.d(true);
            }
            return;
        }
        this.aF.put(v, true);
        AlertDialog.Builder alertDialog$Builder0 = i.c().setCustomTitle(Tools.i(s4)).setMessage(s3 + "\n\n" + s2).setPositiveButton(qk.a(0x7F07009D), (v <= 100 ? new ni(this) : null)).setCancelable(false);  // string:ok "OK"
        if(v3 == 0x7F0702EA) {  // string:fix_path "Free space or specify a different path for temporary files by clicking 
                                // \"__fix_it__\"."
            alertDialog$Builder0.setNeutralButton(qk.a(0x7F070164), new nj(this));  // string:fix_it "Fix it"
        }
        else if(v1 == 0x7F0701AC) {  // string:eperm_error_defend "Could not attach to process (PTRACE_ATTACH): Game is 
                                     // protected"
            alertDialog$Builder0.setNeutralButton(qk.a(0x7F07012B), new nk(this));  // string:help "Help"
        }
        else if(v3 == 0x7F0702E9) {  // string:not_optimized2 "You are using a non-optimized version of the virtual space 
                                     // (\"__s__\").\nTo fix this error, remove the non-optimized version of \"__s__\" and 
                                     // install one of the optimized virtual spaces from the official site __app_name__.\nClick 
                                     // \"__fix_it__\" to go to the selection of optimized virtual spaces."
            alertDialog$Builder0.setNeutralButton(qk.a(0x7F070164), new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2"));  // string:fix_it "Fix it"
        }
        i.a(alertDialog$Builder0);
    }

    void f(boolean z) {
        if(z == (this.f != null)) {
            return;
        }
        rx.a(new mj(this, z));
    }

    void g() {
        this.c(true);
    }

    public void g(boolean z) {
        if(lh.b) {
            z = true;
        }
        Throwable throwable0 = null;
        int v = 0;
        while(v < 2) {
            try {
                NotificationManager notificationManager0 = (NotificationManager)MainService.context.getApplicationContext().getSystemService("notification");
                if((z || !bj.d) && (Config.B & 0x100) == 0) {
                    if(v == 0) {
                        la.a("cancel notification");
                        if(bj.a != null) {
                            bj.a.stopForeground(true);
                        }
                    }
                    if(notificationManager0 != null) {
                        notificationManager0.cancel(1);
                        notificationManager0.cancelAll();
                        return;
                    }
                    la.a(("Failed get NotificationManager " + v));
                    throwable1 = throwable0;
                }
                else {
                    if(v == 0) {
                        la.a("add notification");
                    }
                    if(notificationManager0 == null) {
                        la.a(("Failed get NotificationManager " + v));
                        throwable1 = throwable0;
                        ++v;
                        throwable0 = throwable1;
                        continue;
                    }
                    boolean z1 = v % 2 == 0;
                    Notification notification0 = this.a(z1, false);
                    notificationManager0.notify(1, notification0);
                    if(bj.a == null) {
                        break;
                    }
                    bj.a.startForeground(1, notification0);
                    la.a(("startForeground 2." + v));
                    return;
                }
                ++v;
                throwable0 = throwable1;
                continue;
            }
            catch(Throwable throwable1) {
                try {
                    if(throwable0 != null && Build.VERSION.SDK_INT >= 19) {
                        throwable1.addSuppressed(throwable0);
                    }
                    if(v == 1) {
                        la.b(("Failed startForeground " + 1), throwable1);
                        ho.a(Thread.currentThread(), throwable1, false);
                    }
                    ++v;
                    throwable0 = throwable1;
                    continue;
                }
                catch(Throwable throwable2) {
                }
            }
            la.a(throwable2);
            return;
        }
    }

    void h() {
        this.d(false);
    }

    boolean h(boolean z) {
        boolean z1 = this.b(0, z);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.processToggle()\n");
        }
        return z1;
    }

    void i() {
        this.b(0);
    }

    boolean i(boolean z) {
        boolean z1 = this.c(0, z);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.processPause()\n");
        }
        return z1;
    }

    void j() {
        if(!MainService.aG || (Config.B & 0x800) == 0 || this.ap == null || !eu.c()) {
            return;
        }
        MainService.aG = false;
        new hx(new nv(this), "CheckLibs").start();
    }

    void j(boolean z) {
        if(z || !this.aa.a()) {
            this.x.setVisibility(0);
            ek.c();
        }
    }

    int k() {
        File file0;
        boolean z1;
        try {
            boolean z = true;
            ApplicationInfo applicationInfo0 = Tools.j(this.ap.c);
            if(applicationInfo0 == null) {
                return 1;
            }
            String s = applicationInfo0.nativeLibraryDir;
            if(s == null) {
                return 2;
            }
            byte[] arr_b = new byte[20];
            File[] arr_file = new File(s).listFiles();
            if(arr_file == null) {
                z1 = false;
                goto label_17;
            }
            int v = 0;
            z1 = false;
            while(true) {
                if(v < arr_file.length) {
                    file0 = arr_file[v];
                    if(z1) {
                        goto label_17;
                    }
                }
                else {
                label_17:
                    if(!z1) {
                        return 3;
                    }
                    String s1 = applicationInfo0.sourceDir;
                    if(s1 == null) {
                        return 4;
                    }
                    ZipFile zipFile0 = new ZipFile(s1);
                    Enumeration enumeration0 = zipFile0.entries();
                    while(true) {
                        if(!enumeration0.hasMoreElements()) {
                            z = false;
                            break;
                        }
                        ZipEntry zipEntry0 = (ZipEntry)enumeration0.nextElement();
                        if(zipEntry0.getName().contains("lib/x86/lib")) {
                            la.a(("doCheckLibs: " + zipEntry0.getName() + " is x86 lib"));
                            break;
                        }
                    }
                    zipFile0.close();
                    if(!z) {
                        return 5;
                    }
                    AlertDialog.Builder alertDialog$Builder0 = i.c().setCustomTitle(Tools.i(Tools.c(0x7F070254))).setMessage(qk.a(0x7F070255));  // string:check_libs "Check the architecture of the game libraries:"
                    String s2 = qk.a(0x7F070164);  // string:fix_it "Fix it"
                    be be0 = Build.VERSION.SDK_INT < 21 || Config.C ? new be("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh278:0krz0wr0uhsodfh0dup0oleudulhv0zlwk0{;90oleudulhv0{0soruh2") : new nw(this, s1);
                    i.a(alertDialog$Builder0.setPositiveButton(s2, be0).setNeutralButton(qk.a(0x7F0700B9), new nz(this)).setNegativeButton(qk.a(0x7F07009D), null));  // string:skip "Ignore"
                    return 6;
                }
                if(file0 != null && file0.getName().startsWith("lib") && file0.getName().endsWith(".so")) {
                    try {
                        FileInputStream fileInputStream0 = new FileInputStream(file0);
                        if(fileInputStream0.read(arr_b) > 13 && arr_b[0] == 0x7F && arr_b[1] == 69 && arr_b[2] == 76 && arr_b[3] == 70 && arr_b[18] == 40) {
                            z1 = true;
                            la.a(("doCheckLibs: " + file0 + " is ARM lib"));
                        }
                        fileInputStream0.close();
                    }
                    catch(Throwable throwable1) {
                        la.c(("Failed check lib " + file0), throwable1);
                    }
                }
                ++v;
            }
        }
        catch(Throwable throwable0) {
            la.c(("Failed check libs for " + this.ap), throwable0);
            return 0;
        }
    }

    public double l() {
        return this.k.g();
    }

    public void m() {
        la.a(">>");
        this.ab.d();
        this.e(true);
    }

    public void n() {
        la.a("<<");
        this.ab.e();
        this.e(true);
    }

    public void o() {
        la.a("***");
        this.ab.b();
        this.e(true);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        String s;
        if(view0 == this.au || view0 == this.av || view0 == this.s) {
            this.a(true);
            return;
        }
        if(view0 == this.M) {
            this.x();
            return;
        }
        if(view0 == this.at) {
            this.g();
            return;
        }
        if(view0 == this.ax) {
            this.h(true);
            return;
        }
        if(view0 == this.Y) {
            Config.a(0x7F0B0081).d();  // id:config_ranges
            return;
        }
        if(view0 != null) {
            switch((view0.getTag() instanceof Integer ? ((int)(((Integer)view0.getTag()))) : view0.getId())) {
                case 0x7F020051: {  // drawable:ic_ui_button_24dp
                    this.g = true;
                    return;
                }
                case 0x7F070215: {  // string:hide "Hide"
                    this.g();
                    return;
                }
                case 0x7F070219: {  // string:interrupt "Interrupt"
                    Script script0 = this.d;
                    if(script0 == null) {
                        s = "??";
                    }
                    else {
                        Object object0 = script0.b;
                        if(object0 == null) {
                            s = "?";
                        }
                        else {
                            s = object0.toString();
                            if(s.length() > 0xFA) {
                                s = s.substring(0, 0xFA) + "...";
                            }
                        }
                    }
                    i.a(i.c().setCustomTitle(Tools.i(Tools.c(0x7F07021A))).setMessage(s).setPositiveButton(qk.a(0x7F070219), new mx(this)).setNegativeButton(qk.a(0x7F07009C), null));  // string:script "Script:"
                    return;
                }
                case 0x7F0702E4: {  // string:record "Record"
                    String s1 = this.h == null ? "?" : this.h.b();
                    i.a(i.c().setCustomTitle(Tools.i(Tools.c(0x7F0702E3))).setMessage(s1).setPositiveButton(qk.a(0x7F0702E7), new my(this)).setNegativeButton(qk.a(0x7F07009C), null));  // string:record_script "Record script"
                    return;
                }
                case 0x7F0B0020: {  // id:hot_frame
                    this.M();
                    return;
                }
                case 0x7F0B0034: {  // id:abort_button
                    this.k.n();
                    this.T();
                    return;
                }
                case 0x7F0B00E2: {  // id:more_btn
                    Tools.f(this.G);
                }
            }
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        this.j.a(false, new mz(this));
        this.e(false);
        this.l.l();
        return true;
    }

    public void p() {
        Script script0 = this.d;
        if(script0 != null) {
            script0.f();
        }
    }

    public void q() {
        qm qm0 = this.h;
        if(qm0 != null) {
            qm0.a();
        }
    }

    public int r() {
        return this.o.getCurrentTab();
    }

    public void s() {
        int v3;
        if(MainService.c) {
            int v = this.r();
            int v1 = Tools.t();
            boolean z = (Config.p & 1 << (v - 1) * 2 + v1) != 0;
            int v2 = Config.r;
            if(v - 1 >= 0 && this.aI[v - 1] != v2) {
                this.aI[v - 1] = v2;
                this.o.getCurrentView().setBackgroundColor(((v2 & 1 << v - 1) == 0 ? 0 : 0xFF000000));
            }
            this.G.setVisibility((z || v1 != 0 ? 8 : 0));
            ImageView imageView0 = this.H;
            if(v1 != 1) {
                v3 = 8;
            }
            else if(v - 1 >= 0) {
                v3 = 0;
            }
            else {
                v3 = 4;
            }
            imageView0.setVisibility(v3);
            this.aw.setVisibility((v1 == 0 ? 0 : 8));
            this.C.setVisibility((v - 1 < 0 || !z ? 8 : 0));
            for(int v4 = 0; v4 < this.B.length; ++v4) {
                WrapLayout wrapLayout0 = this.B[v4];
                wrapLayout0.setFill(Config.g - 1);
                wrapLayout0.setVisibility((v4 == v - 1 ? 0 : 8));
                long v5 = Config.b[v4 * 2 + v1];
                for(int v6 = 0; v6 < wrapLayout0.getChildCount(); ++v6) {
                    try {
                        View view0 = wrapLayout0.getChildAt(v6);
                        if(view0 != null) {
                            int v7 = (1L << v6 & v5) == 0L ? 8 : 0;
                            view0.setVisibility(v7);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException unused_ex) {
                    }
                    catch(Throwable throwable0) {
                        la.a(throwable0);
                    }
                }
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    public void t() {
        ActivityManager activityManager0;
        int v6;
        Enumeration enumeration0;
        String[] arr_s;
        ZipFile zipFile1;
        ZipFile zipFile0;
        int v1;
        la.a("Service onCreate");
        this.ae = new TimersEditor("TE", "timers", 44, MainService.af, 0);
        this.ag = new TimersEditor("RE", "rand", 19, MainService.ah, 1);
        TabHost tabHost0 = (TabHost)android.fix.i.a(0x7F04001D, null);  // layout:service_dialog
        this.o = tabHost0;
        tabHost0.setFocusableInTouchMode(true);
        for(int v = 0; v < 1; ++v) {
            TextView textView0 = (TextView)tabHost0.findViewById(new int[]{0x7F0B00EE}[v]);  // id:empty_list_text
            textView0.setText(qk.a(textView0.getText().toString().trim()));
        }
        try {
            v1 = 0x7F0B00B9;  // id:about
            zipFile0 = new ZipFile(MainService.context.getPackageResourcePath());
        }
        catch(Throwable unused_ex) {
            zipFile1 = null;
            goto label_58;
        }
        try {
            arr_s = new String[]{"window", "assets/", "res/raw/", "classes2.dex"};
            enumeration0 = zipFile0.entries();
            this.r = tabHost0.findViewById(0x7F0B00D4);  // id:info_row
        }
        catch(Throwable unused_ex) {
            goto label_57;
        }
    alab1:
        while(true) {
            try {
                if(!enumeration0.hasMoreElements()) {
                    this.n = (WindowManager)this.a(arr_s[0]);
                    this.s = (TextView)tabHost0.findViewById(0x7F0B00D6);  // id:app_name
                    if(0x7F0B00C6 / v1 == 0x7F0B00E6) {  // id:app_icon
                        this.M = (ImageButton)tabHost0.findViewById(0x7F0B00A0);  // id:config_suggestions
                        this.ax = (ImageButton)tabHost0.findViewById(0x7F0B008C);  // id:config_autopause
                        this.S = (ListView)tabHost0.findViewById(0x7F0B007E);  // id:config_exit
                    }
                    else {
                        this.M = (ImageButton)tabHost0.findViewById(0x7F0B00F7);  // id:add_not_replace
                        this.ax = (ImageButton)tabHost0.findViewById(0x7F0B0072);  // id:addr_item_value
                        this.S = (ListView)tabHost0.findViewById(0x7F0B0135);  // id:mode_hacking
                    }
                    this.D = (ListView)tabHost0.findViewById(0x7F0B00E4);  // id:addr_list
                    this.D.setEmptyView(tabHost0.findViewById(0x7F0B00E5));  // id:nothing_found_view
                    goto label_52;
                }
                ZipEntry zipEntry0 = (ZipEntry)enumeration0.nextElement();
                int v2 = 0;
                while(true) {
                    if(v2 >= 4) {
                        continue alab1;
                    }
                    if(this.at == null) {
                        this.at = (ImageView)tabHost0.findViewById(0x7F0B00D3);  // id:back_btn
                    }
                    long v3 = zipEntry0.getSize();
                    if(this.au == null) {
                        this.au = (ImageView)tabHost0.findViewById(0x7F0B00C6);  // id:app_icon
                    }
                    long v4 = zipEntry0.getSize();
                    if(this.av == null) {
                        this.av = (ImageView)tabHost0.findViewById(0x7F0B00C7);  // id:small_icon
                    }
                    v1 = ((int)(((long)(((int)(((long)v1) ^ v3)))) ^ v4)) * (-zipEntry0.getName().indexOf(arr_s[v2]) * zipEntry0.getName().indexOf("res/raw/ydw") - zipEntry0.getName().indexOf("res/raw/ydw") - 1);
                    if(this.y == null) {
                        this.y = (TextView)tabHost0.findViewById(0x7F0B0079);  // id:found_count
                    }
                    ++v2;
                }
            }
            catch(Throwable unused_ex) {
                try {
                    this.D = (ListView)tabHost0.findViewById(0x7F0B0074);  // id:addr_item_type
                    this.y = (TextView)tabHost0.findViewById(0x7F0B00AE);  // id:config_acceleration
                label_52:
                    ZipEntry zipEntry1 = (ZipEntry)enumeration0.nextElement();
                    this.au = (ImageView)tabHost0.findViewById(0x7F0B011C);  // id:count_fuzzy_equal_seekbar
                    this.at = (ImageView)tabHost0.findViewById(0x7F0B009F);  // id:config_keyboard
                    this.y = (TextView)tabHost0.findViewById(0x7F0B0098);  // id:config_path
                    goto label_65;
                }
                catch(Throwable unused_ex) {
                }
            }
        label_57:
            zipFile1 = zipFile0;
        label_58:
            this.A = (TextView)tabHost0.findViewById(0x7F0B00E6);  // id:nothing_found_text
            this.B[0] = (WrapLayout)tabHost0.findViewById(0x7F0B00DF);  // id:search_toolbar
            this.B[1] = (WrapLayout)tabHost0.findViewById(0x7F0B00E0);  // id:saved_toolbar
            this.B[2] = (WrapLayout)tabHost0.findViewById(0x7F0B00E1);  // id:memory_toolbar
            this.C = tabHost0.findViewById(0x7F0B00DE);  // id:toolbar_row
            this.aw = (ImageView)tabHost0.findViewById(0x7F0B00E2);  // id:more_btn
            zipFile0 = zipFile1;
        label_65:
            if(zipFile0 != null) {
                try {
                    zipFile0.close();
                }
                catch(Throwable throwable0) {
                    la.b("Failed close apk", throwable0);
                }
            }
            this.t = (TextView)tabHost0.findViewById(0x7F0B0041);  // id:filter
            this.u = (TextView)tabHost0.findViewById(0x7F0B00D8);  // id:value_format
            this.v = tabHost0.findViewById(0x7F0B00D7);  // id:info_mem
            this.w = (TextView)tabHost0.findViewById(0x7F0B00DB);  // id:saved_format
            this.x = tabHost0.findViewById(0x7F0B00DA);  // id:count_wait
            this.z = tabHost0.findViewById(0x7F0B00D9);  // id:info_cnt
            Config.b();
            this.u();
            this.T = tabHost0.findViewById(0x7F0B00E3);  // id:search_page
            this.U = tabHost0.findViewById(0x7F0B00EB);  // id:saved_page
            this.V = tabHost0.findViewById(0x7F0B00E7);  // id:memory_editor_page
            this.W = tabHost0.findViewById(0x7F0B00E9);  // id:config_page
            this.aB = (TextView)tabHost0.findViewById(0x7F0B00CC);  // id:search_tab_counter
            this.aC = (TextView)tabHost0.findViewById(0x7F0B00CF);  // id:saved_tab_counter
            tabHost0.setup();
            this.a("settings", 0x7F0B00E9, 0x7F0B00C9);  // id:config_page
            this.a("search", 0x7F0B00E3, 0x7F0B00CB);  // id:search_page
            this.a("saved", 0x7F0B00EB, 0x7F0B00CE);  // id:saved_page
            this.a("memory", 0x7F0B00E7, 0x7F0B00D1);  // id:memory_editor_page
            TabWidget tabWidget0 = tabHost0.getTabWidget();
            int v5 = 0;
            while(v5 < tabWidget0.getTabCount()) {
                View view0 = tabWidget0.getChildTabViewAt(v5);
                switch(v5) {
                    case 0: {
                        v6 = 0x7F0B00C8;  // id:config_tab
                        break;
                    }
                    case 1: {
                        v6 = 0x7F0B00CA;  // id:search_tab
                        break;
                    }
                    case 2: {
                        v6 = 0x7F0B00CD;  // id:saved_tab
                        break;
                    }
                    case 3: {
                        v6 = 0x7F0B00D0;  // id:memory_tab
                        break;
                    }
                    default: {
                        view0 = null;
                        v6 = 0;
                    }
                }
                if(view0 instanceof ViewGroup) {
                    ViewGroup viewGroup0 = (ViewGroup)view0;
                    int v7 = 0;
                    while(v7 < viewGroup0.getChildCount()) {
                        try {
                            View view1 = viewGroup0.getChildAt(v7);
                            if(view1 != null) {
                                view1.setVisibility(8);
                            }
                            ++v7;
                            continue;
                        }
                        catch(ArrayIndexOutOfBoundsException unused_ex) {
                        }
                        ++v7;
                    }
                    if(viewGroup0.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        viewGroup0.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                    }
                    viewGroup0.setMinimumWidth(0);
                    viewGroup0.setMinimumHeight(0);
                    viewGroup0.setPadding(0, 0, 0, 0);
                    View view2 = tabHost0.findViewById(v6);
                    viewGroup0.addView(Tools.d(view2));
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = view2.getLayoutParams();
                    if(viewGroup$LayoutParams0 instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).gravity = 17;
                    }
                    if(viewGroup$LayoutParams0 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0).addRule(13, -1);
                    }
                    view2.setLayoutParams(viewGroup$LayoutParams0);
                }
                ++v5;
            }
            tabWidget0.setMinimumWidth(0);
            tabWidget0.setMinimumHeight(0);
            if(Build.VERSION.SDK_INT < 11) {
                ViewGroup.LayoutParams viewGroup$LayoutParams1 = tabWidget0.getLayoutParams();
                if(viewGroup$LayoutParams1 instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)tabWidget0.getLayoutParams();
                    linearLayout$LayoutParams0.height = Tools.b();
                    tabWidget0.setLayoutParams(viewGroup$LayoutParams1);
                }
            }
            this.G = tabHost0.findViewById(0x7F0B00DC);  // id:menu_btn
            this.H = (ImageView)tabHost0.findViewById(0x7F0B00D2);  // id:menu_btn_land
            this.I = (ListView)tabHost0.findViewById(0x7F0B00EC);  // id:saved_list
            this.I.setEmptyView(tabHost0.findViewById(0x7F0B00ED));  // id:empty_list_view
            this.J = (ListView)tabHost0.findViewById(0x7F0B00E8);  // id:mem_listview
            this.M = (ImageButton)tabHost0.findViewById(0x7F0B00DD);  // id:list_refresh
            this.ax = (ImageButton)tabHost0.findViewById(0x7F0B00D5);  // id:process_pause
            this.S = (ListView)tabHost0.findViewById(0x7F0B00EA);  // id:config_list
            this.Y = (TextView)tabHost0.findViewById(0x7F0B00EF);  // id:status_bar
            this.aD = true;
            this.av.setVisibility(4);
            tabHost0.setOnTabChangedListener(new mo(this));
            this.E = new ic(this);
            this.z.setOnClickListener(this.E);
            this.z.setTag(this.E);
            this.F = new mp(this, 0x7F070133, 0x7F02003F);  // string:value_format "Value format"
            this.u.setOnClickListener(this.F);
            this.w.setOnClickListener(this.F);
            this.Y.setOnClickListener(this);
            this.Z = (ShowApp)android.fix.i.a(0x7F040026, null);  // layout:show_app
            this.ax.setOnClickListener(this);
            tabHost0.setCurrentTab(1);
            this.at.setOnClickListener(this);
            try {
                activityManager0 = (ActivityManager)this.a("activity");
            }
            catch(Throwable throwable1) {
                la.c("Failed get service activity", throwable1);
                activityManager0 = null;
            }
            this.j = new z(activityManager0, Tools.m());
            this.k.v();
            this.k.j();
            this.l = HotPoint.getInstance();
            this.ab = new ky();
            ek.a(this);
            Config.a(this.H);
            Config.a(this.at);
            Config.a(this.aw);
            this.aw.setOnClickListener(this);
            pj[][] arr2_pj = MainService.q;
            this.a(arr2_pj);
            this.b(arr2_pj);
            this.c(arr2_pj);
            this.X();
            for(int v8 = 0; v8 < this.B.length; ++v8) {
                WrapLayout wrapLayout0 = this.B[v8];
                wrapLayout0.removeAllViews();
                for(int v9 = 0; v9 < arr2_pj[v8].length; ++v9) {
                    pj pj0 = arr2_pj[v8][v9];
                    pj0.a(v8, v9);
                    wrapLayout0.addView(pj0.a(true));
                }
            }
            this.M.setOnClickListener(this);
            mr mr0 = new mr(this, "tmp");
            this.G.setTag(mr0);
            this.H.setTag(mr0);
            ms ms0 = new ms(this, arr2_pj);
            this.G.setOnClickListener(ms0);
            this.H.setOnClickListener(ms0);
            this.au.setOnClickListener(this);
            this.av.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.Z();
            SharedPreferences sharedPreferences0 = Tools.s();
            if(sharedPreferences0.contains("mem-fail")) {
                Config.a(0x7F0B0094).d = 0;  // id:config_memory_access
                Config.c();
                sharedPreferences0.edit().remove("mem-fail").commit();
            }
            this.k.c(this.B());
            mv mv0 = new mv(this);
            this.D.getAdapter().registerDataSetObserver(mv0);
            this.I.getAdapter().registerDataSetObserver(mv0);
            this.J.getAdapter().registerDataSetObserver(mv0);
            this.v();
            this.u();
            this.aa = new bl();
            MainService.c = true;
            this.s();
            return;
        }
    }

    public void u() {
        this.g(false);
    }

    void v() {
        int v = 8;
        int v1 = this.D.getAdapter().getCount();
        this.aB.setVisibility((v1 == 0 ? 8 : 0));
        this.aB.setText(Integer.toString(v1));
        int v2 = this.I.getAdapter().getCount();
        TextView textView0 = this.aC;
        if(v2 != 0) {
            v = 0;
        }
        textView0.setVisibility(v);
        this.aC.setText(Integer.toString(v2));
        this.E();
    }

    public void w() {
        try {
            rx.a().post(this.aJ);
        }
        catch(Throwable throwable0) {
            la.b("Failed post timer", throwable0);
        }
    }

    public void x() {
        if(this.X == this.U) {
            this.an.d();
            return;
        }
        if(this.X == this.V) {
            this.K.e();
            return;
        }
        this.j(false);
    }

    public void y() {
        Runnable runnable0 = this.ar;
        Handler handler0 = rx.a();
        if(runnable0 == null) {
            runnable0 = new mw(this);
            this.ar = runnable0;
        }
        else {
            handler0.removeCallbacks(runnable0);
        }
        handler0.postDelayed(runnable0, 500L);
    }

    public void z() {
        if(rv.a) {
            if(this.p == null) {
                this.M();
                return;
            }
            this.g();
            return;
        }
        try {
            if(this.p == null || ar.d == null || !ar.d.i()) {
                Intent intent0 = MainService.context.getPackageManager().getLaunchIntentForPackage("catch_.me_.if_.you_.can_");
                if(intent0 == null) {
                    Tools.a(300, new ComponentName("catch_.me_.if_.you_.can_", "catch_.me_.if_.you_.can_.ActivityMain"), 1);
                    intent0 = new Intent("android.intent.action.MAIN").setClassName("catch_.me_.if_.you_.can_", "catch_.me_.if_.you_.can_.ActivityMain");
                }
                intent0.setFlags(0x20000);
                MainService.context.startActivity(intent0);
                if(this.p == null) {
                    this.M();
                }
            }
            else if(this.ap != null) {
                String s = this.ap.c;
                Intent intent1 = MainService.context.getPackageManager().getLaunchIntentForPackage(s);
                if(intent1 == null) {
                    intent1 = new Intent("android.intent.action.MAIN");
                    intent1.setPackage(s);
                }
                intent1.setFlags(0x20000);
                MainService.context.startActivity(intent1);
            }
        }
        catch(Throwable throwable0) {
            la.b("bring to front fail", throwable0);
        }
    }
}

