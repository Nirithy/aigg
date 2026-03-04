package android.ext;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.app.UiAutomation;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import java.io.IOException;
import java.util.Random;

public class bq implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, View.OnTouchListener {
    Activity a;
    private static volatile boolean b;
    private static View[] c;
    private static AlertDialog d;
    private static boolean e;

    static {
        bq.b = false;
        bq.c = null;
        bq.d = null;
        bq.e = false;
    }

    public bq(Activity activity0) {
        this.a = activity0;
    }

    private int a(Random random0) {
        return Color.rgb(random0.nextInt(0x7F) + 0x40, random0.nextInt(0x7F) + 0x40, random0.nextInt(0x7F) + 0x40);
    }

    public static AlertDialog.Builder a(AlertDialog.Builder alertDialog$Builder0) {
        String s = qk.a(0x7F070001);  // string:app_name "GameGuardian"
        return alertDialog$Builder0.setCustomTitle(Tools.d(0x7F07010E)).setMessage(Tools.a(Tools.c(0x7F0702C3), new Object[]{s, s, s, s}) + ":\nhttps://productforums.google.com/forum/#!topic/translate/1Pywh5vI1kE\n\n" + Tools.c(0x7F0702C7) + ":\n" + "http://gameguardian.net/v-240").setNegativeButton(qk.a(0x7F07009D), null);  // string:floating_window_fail "Unable to show floating window"
    }

    @TargetApi(18)
    private void a(MotionEvent motionEvent0, boolean z) {
        if(bi.b != null) {
            bi.b.sendPointerSync(motionEvent0);
            if(Build.VERSION.SDK_INT >= 18) {
                UiAutomation uiAutomation0 = bi.b.getUiAutomation();
                if(uiAutomation0 != null) {
                    uiAutomation0.injectInputEvent(motionEvent0, z);
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    private void a(View view0, int v) {
        this.a(view0, v, 0x7F6, 0x100, 0, 0);
    }

    private void a(View view0, int v, int v1, int v2, int v3, int v4) {
        WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
        windowManager$LayoutParams0.type = v1;
        windowManager$LayoutParams0.width = v;
        windowManager$LayoutParams0.height = v;
        windowManager$LayoutParams0.format = -2;
        windowManager$LayoutParams0.flags = v2;
        windowManager$LayoutParams0.alpha = 1.0f;
        windowManager$LayoutParams0.x = v3;
        windowManager$LayoutParams0.y = v4;
        windowManager$LayoutParams0.gravity = 51;
        bs bs0 = new bs(this, view0, windowManager$LayoutParams0);
        synchronized(bs0) {
            rx.a(bs0);
            bs0.wait();
        }
    }

    private void a(boolean z) {
        View[] arr_view = bq.c;
        if(arr_view != null) {
            for(int v = 0; v < arr_view.length; ++v) {
                View view0 = arr_view[v];
                if(view0 != null) {
                    Tools.b(view0);
                }
            }
            bq.c = null;
        }
        if(z) {
            AlertDialog alertDialog0 = bq.d;
            if(alertDialog0 != null) {
                Tools.a(alertDialog0);
                bq.d = null;
            }
        }
    }

    private static boolean a(Context context0) {
        return Tools.a(context0);
    }

    public void a() {
        new gr(new br(this), "CheckFloatingWindow").start();
    }

    @TargetApi(12)
    public void a(int v, int v1) {
        try {
            Tools.a(Tools.a(new String[]{"input", "tap", Integer.toString(v), Integer.toString(v1)}), 15);
        }
        catch(IOException iOException0) {
            la.b("sendClick", iOException0);
        }
        long v2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent0 = MotionEvent.obtain(v2, v2, 0, ((float)v), ((float)v1), 0);
        MotionEvent motionEvent1 = MotionEvent.obtain(v2, v2, 1, ((float)v), ((float)v1), 0);
        if(Build.VERSION.SDK_INT >= 12) {
            motionEvent0.setSource(0x1002);
            motionEvent1.setSource(0x1002);
        }
        this.a(motionEvent0, true);
        this.a(motionEvent1, true);
        motionEvent0.recycle();
        motionEvent1.recycle();
    }

    public void b() {
        AlertDialog alertDialog0 = i.a(this.a).setNegativeButton(qk.a(0x7F0700A1), this).setCancelable(true).create();  // string:cancel "Cancel"
        alertDialog0.setOnDismissListener(this);
        alertDialog0.setCanceledOnTouchOutside(false);
        alertDialog0.setCancelable(true);
        alertDialog0.setOnShowListener(this);
        bq.d = alertDialog0;
        rx.a(new bt(this, alertDialog0));
    }

    void c() {
        View[] arr_view1;
        View[] arr_view;
        int v3;
        int v1;
        int v;
        Random random0;
        try {
            random0 = Tools.a;
            DisplayMetrics displayMetrics0 = new DisplayMetrics();
            ((WindowManager)Tools.e().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics0);
            v = Tools.b();
            v1 = displayMetrics0.widthPixels / v / 2 * 2;
            int v2 = displayMetrics0.heightPixels / v * v1;
            v3 = v2 <= 100 ? v2 : 100;
            la.a(("checkAll: " + v + "; " + v1 + "; " + v3 + "; " + v + "; " + displayMetrics0));
            arr_view = new View[v3];
        }
        catch(Throwable throwable0) {
            arr_view1 = null;
            la.c("Failed checkAll floating window", throwable0);
            this.a(false);
            bq.c = arr_view1;
            return;
        }
        for(int v4 = 0; true; ++v4) {
            if(v4 >= v3) {
                arr_view1 = arr_view;
            }
            else {
                try {
                    boolean z = v4 / (v3 / 2) == 0;
                    int v5 = v4 % (v3 / 2) + 2000;
                    int v6 = this.a(random0);
                    bz bz0 = new bz(MainService.context.getApplicationContext(), Integer.toString(v4 % (v3 / 2)) + (z ? "" : "\'"), v5, (z ? 0 : 0x20) | 8);
                    bz0.setBackgroundColor(v6);
                    bz0.setOnClickListener(this);
                    try {
                        int v7 = z ? 0 : v1 / 2;
                        this.a(bz0, v, v5, (z ? 0 : 0x20) | 8, (v7 + v4 % (v1 / 2)) * v, v4 % (v3 / 2) / (v1 / 2) * v);
                        arr_view[v4] = bz0;
                    }
                    catch(Throwable throwable1) {
                        la.c(("Failed show: " + v5), throwable1);
                    }
                    continue;
                }
                catch(Throwable throwable0) {
                    arr_view1 = arr_view;
                }
                la.c("Failed checkAll floating window", throwable0);
            }
            this.a(false);
            bq.c = arr_view1;
            return;
        }
    }

    void d() {
        try {
            int v = this.a(Tools.a);
            int v1 = (int)Tools.a(128.0f);
            View view0 = new View(MainService.context);
            view0.setBackgroundColor(v);
            view0.setOnClickListener(this);
            try {
                this.a(view0, v1);
                Thread.sleep(1000L);
                int[] arr_v = new int[2];
                view0.getLocationOnScreen(arr_v);
                this.a(arr_v[0] + (v1 >> 1), arr_v[1] + (v1 >> 1));
                Thread.sleep(1000L);
            }
            finally {
                Tools.b(view0);
            }
            if(bq.b) {
                Tools.a(0x7F070110);  // string:check_success "Verification was successful"
                return;
            }
            this.f();
        }
        catch(Throwable throwable0) {
            la.c("Failed check floating window", throwable0);
        }
    }

    @TargetApi(23)
    public static void e() {
        try {
            if(Build.VERSION.SDK_INT >= 23) {
                ar ar0 = ar.d;
                boolean z = bq.a(ar0);
                la.a(("canDrawOverlays: " + z));
                if(!z) {
                    bq.e = true;
                    AlertDialog.Builder alertDialog$Builder0 = i.a(ar0);
                    alertDialog$Builder0.setCustomTitle(Tools.d(0x7F07010E)).setMessage(0x7F070111).setNegativeButton(qk.a(0x7F0700B9), null).setPositiveButton(qk.a(0x7F07009D), new bx(ar0));  // string:floating_window_fail "Unable to show floating window"
                    rx.a(new by(alertDialog$Builder0));
                    return;
                }
                if(bq.e) {
                    bq.e = false;
                    ConfigListAdapter.c();
                }
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    private void f() {
        AlertDialog.Builder alertDialog$Builder0 = bq.a(i.a(this.a));
        alertDialog$Builder0.setPositiveButton(qk.a(0x7F070223), new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2:7360nqrzq0sureohpv2Bgr@ilqgFrpphqw)frpphqw@76<88"));  // string:site "Site"
        if(Build.VERSION.SDK_INT >= 23) {
            alertDialog$Builder0.setNeutralButton(qk.a(0x7F070164), new bv(this));  // string:fix_it "Fix it"
        }
        rx.a(new bw(this, alertDialog$Builder0));
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a(true);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        la.a(("TestButton: onClick for " + view0), new RuntimeException());
        if(view0 instanceof bz) {
            la.a(("onClick for " + ((bz)view0).a));
            ct ct0 = Config.a(0x7F0B00BD);  // id:config_float_type
            ct0.d = ((bz)view0).b;
            ct ct1 = Config.a(0x7F0B00BE);  // id:config_float_flags
            ct1.d = ((bz)view0).c;
            Config.c();
            this.a(true);
            ar.h();
            return;
        }
        bq.b = true;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        this.a(true);
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        new gr(new bu(this), "ChangeFloatingWindow").start();
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        la.a(("dbg: " + view0 + ' ' + motionEvent0), new RuntimeException());
        return false;
    }
}

