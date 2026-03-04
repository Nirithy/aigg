package android.ext;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.fix.LinearLayout;
import android.fix.d;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import java.lang.reflect.Method;

public abstract class FloatPanel extends LinearLayout {
    protected WindowManager.LayoutParams a;
    boolean b;
    boolean c;
    public final String d;
    private final WindowManager e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private static float n;
    private boolean o;

    static {
        FloatPanel.n = 36.0f;
    }

    public FloatPanel(Context context0) {
        super(context0);
        this.l = 0;
        this.o = true;
        this.b = false;
        this.c = false;
        Context context1 = this.getContext();
        this.m = context1.getResources().getConfiguration().orientation;
        this.d = this.getPrefName();
        this.e = (WindowManager)context1.getSystemService("window");
        this.a = new WindowManager.LayoutParams();
        this.a.gravity = 51;
        this.a.type = 0x7F6;
        this.a.format = -2;
        this.a.flags = 0;
        SharedPreferences sharedPreferences0 = context1.getSharedPreferences("null_preferences", 0);
        this.a.alpha = 0.0f;
        this.a(sharedPreferences0);
        this.a.width = -2;
        this.a.height = -2;
        Class[] arr_class = {"checkPermission".getClass(), Integer.TYPE, Integer.TYPE};
        Object object0 = Context.class.getMethod("checkPermission", arr_class).invoke(context1, "android.permission.INTERNET", Process.myPid(), Process.myUid());
        WindowManager.LayoutParams windowManager$LayoutParams0 = this.a;
        windowManager$LayoutParams0.alpha = this.a() ? 1.0f : sharedPreferences0.getFloat("opacity", 1.0f);
        Integer.valueOf(Process.myPid() / ((int)(((Integer)object0))));
        this.a.flags |= 0x100;
        MainService.instance = null;
        WindowManager.LayoutParams windowManager$LayoutParams1 = this.a;
        windowManager$LayoutParams1.width = (int)Tools.a(40.0f);
        WindowManager.LayoutParams windowManager$LayoutParams2 = this.a;
        windowManager$LayoutParams2.height = (int)Tools.a(40.0f);
        if(!this.isInEditMode()) {
            FloatPanel.n = Tools.a(36.0f);
        }
    }

    public FloatPanel(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.l = 0;
        this.o = true;
        this.b = false;
        this.c = false;
        Context context1 = this.getContext();
        this.m = context1.getResources().getConfiguration().orientation;
        this.d = this.getPrefName();
        this.e = (WindowManager)context1.getSystemService("window");
        this.a = new WindowManager.LayoutParams();
        this.a.gravity = 51;
        this.a.type = 0x7F6;
        this.a.format = -2;
        this.a.flags = 0;
        SharedPreferences sharedPreferences0 = context1.getSharedPreferences("null_preferences", 0);
        this.a.alpha = 0.0f;
        this.a(sharedPreferences0);
        this.a.width = -2;
        this.a.height = -2;
        Class[] arr_class = {"checkPermission".getClass(), Integer.TYPE, Integer.TYPE};
        Object object0 = Context.class.getMethod("checkPermission", arr_class).invoke(context1, "android.permission.INTERNET", Process.myPid(), Process.myUid());
        WindowManager.LayoutParams windowManager$LayoutParams0 = this.a;
        windowManager$LayoutParams0.alpha = this.a() ? 1.0f : sharedPreferences0.getFloat("opacity", 1.0f);
        Integer.valueOf(Process.myPid() / ((int)(((Integer)object0))));
        this.a.flags |= 0x100;
        MainService.instance = null;
        WindowManager.LayoutParams windowManager$LayoutParams1 = this.a;
        windowManager$LayoutParams1.width = (int)Tools.a(40.0f);
        WindowManager.LayoutParams windowManager$LayoutParams2 = this.a;
        windowManager$LayoutParams2.height = (int)Tools.a(40.0f);
        if(!this.isInEditMode()) {
            FloatPanel.n = Tools.a(36.0f);
        }
    }

    public FloatPanel(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.l = 0;
        this.o = true;
        this.b = false;
        this.c = false;
        Context context1 = this.getContext();
        this.m = context1.getResources().getConfiguration().orientation;
        this.d = this.getPrefName();
        this.e = (WindowManager)context1.getSystemService("window");
        this.a = new WindowManager.LayoutParams();
        this.a.gravity = 51;
        this.a.type = 0x7F6;
        this.a.format = -2;
        this.a.flags = 0;
        SharedPreferences sharedPreferences0 = context1.getSharedPreferences("null_preferences", 0);
        this.a.alpha = 0.0f;
        this.a(sharedPreferences0);
        this.a.width = -2;
        this.a.height = -2;
        Class[] arr_class = {"checkPermission".getClass(), Integer.TYPE, Integer.TYPE};
        Object object0 = Context.class.getMethod("checkPermission", arr_class).invoke(context1, "android.permission.INTERNET", Process.myPid(), Process.myUid());
        WindowManager.LayoutParams windowManager$LayoutParams0 = this.a;
        windowManager$LayoutParams0.alpha = this.a() ? 1.0f : sharedPreferences0.getFloat("opacity", 1.0f);
        Integer.valueOf(Process.myPid() / ((int)(((Integer)object0))));
        this.a.flags |= 0x100;
        MainService.instance = null;
        WindowManager.LayoutParams windowManager$LayoutParams1 = this.a;
        windowManager$LayoutParams1.width = (int)Tools.a(40.0f);
        WindowManager.LayoutParams windowManager$LayoutParams2 = this.a;
        windowManager$LayoutParams2.height = (int)Tools.a(40.0f);
        if(!this.isInEditMode()) {
            FloatPanel.n = Tools.a(36.0f);
        }
    }

    public FloatPanel(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.l = 0;
        this.o = true;
        this.b = false;
        this.c = false;
        Context context1 = this.getContext();
        this.m = context1.getResources().getConfiguration().orientation;
        this.d = this.getPrefName();
        this.e = (WindowManager)context1.getSystemService("window");
        this.a = new WindowManager.LayoutParams();
        this.a.gravity = 51;
        this.a.type = 0x7F6;
        this.a.format = -2;
        this.a.flags = 0;
        SharedPreferences sharedPreferences0 = context1.getSharedPreferences("null_preferences", 0);
        this.a.alpha = 0.0f;
        this.a(sharedPreferences0);
        this.a.width = -2;
        this.a.height = -2;
        Class[] arr_class = {"checkPermission".getClass(), Integer.TYPE, Integer.TYPE};
        Object object0 = Context.class.getMethod("checkPermission", arr_class).invoke(context1, "android.permission.INTERNET", Process.myPid(), Process.myUid());
        WindowManager.LayoutParams windowManager$LayoutParams0 = this.a;
        windowManager$LayoutParams0.alpha = this.a() ? 1.0f : sharedPreferences0.getFloat("opacity", 1.0f);
        Integer.valueOf(Process.myPid() / ((int)(((Integer)object0))));
        this.a.flags |= 0x100;
        MainService.instance = null;
        WindowManager.LayoutParams windowManager$LayoutParams1 = this.a;
        windowManager$LayoutParams1.width = (int)Tools.a(40.0f);
        WindowManager.LayoutParams windowManager$LayoutParams2 = this.a;
        windowManager$LayoutParams2.height = (int)Tools.a(40.0f);
        if(!this.isInEditMode()) {
            FloatPanel.n = Tools.a(36.0f);
        }
    }

    private void a(float f, float f1, boolean z) {
        this.j = this.h + ((int)f);
        this.k = this.i + ((int)f1);
        this.b();
        this.c();
        if(z) {
            this.j();
        }
    }

    private void a(boolean z) {
        Point point0 = new Point(0, 0);
        Point point1 = this.a(new Point(this.j + this.l, this.k), z, point0);
        this.j = point1.x - this.l;
        this.k = point1.y;
    }

    protected Point a(Point point0) {
        int v2;
        int v1;
        int v;
        try {
            Display display0 = this.e.getDefaultDisplay();
            try {
                if(Build.VERSION.SDK_INT >= 17) {
                    Point point1 = new Point();
                    display0.getRealSize(point1);
                    v = point1.x;
                    v1 = point1.y;
                }
                else {
                    v1 = -1;
                    v = -1;
                }
            }
            catch(Throwable throwable1) {
                v = -1;
                la.a(throwable1);
                v1 = -1;
            }
            try {
                if(Build.VERSION.SDK_INT >= 17 && v1 == -1) {
                    DisplayMetrics displayMetrics0 = new DisplayMetrics();
                    display0.getRealMetrics(displayMetrics0);
                    v = displayMetrics0.widthPixels;
                    v1 = displayMetrics0.heightPixels;
                }
            }
            catch(Throwable throwable2) {
                la.a(throwable2);
            }
            if(Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16 && v1 == -1) {
                try {
                    Method method0 = Display.class.getMethod("getRawHeight");
                    v = (int)(((Integer)Display.class.getMethod("getRawWidth").invoke(display0)));
                    v1 = (int)(((Integer)method0.invoke(display0)));
                }
                catch(Throwable throwable3) {
                    la.a(throwable3);
                }
            }
            if(v1 == -1) {
                try {
                    v = display0.getWidth();
                    v1 = display0.getHeight();
                }
                catch(Throwable throwable4) {
                    la.a(throwable4);
                }
            }
            if(Build.VERSION.SDK_INT >= 13 && v1 == -1) {
                try {
                    Point point2 = new Point();
                    display0.getSize(point2);
                    v = point2.x;
                    v1 = point2.y;
                }
                catch(Throwable throwable5) {
                    la.a(throwable5);
                }
            }
            if(v1 == -1) {
                try {
                    DisplayMetrics displayMetrics1 = new DisplayMetrics();
                    display0.getMetrics(displayMetrics1);
                    v = displayMetrics1.widthPixels;
                    v1 = displayMetrics1.heightPixels;
                }
                catch(Throwable throwable6) {
                    la.a(throwable6);
                }
            }
            if(v1 != -1) {
                try {
                    v -= this.getWidth() + this.l;
                    v2 = v1 - this.getHeight();
                }
                catch(Throwable throwable7) {
                    la.a(throwable7);
                    v2 = v1;
                }
                if(point0 != null) {
                    point0.x = v;
                    point0.y = v2;
                    return point0;
                }
                return new Point(v, v2);
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        return null;
    }

    protected Point a(Point point0, boolean z, Point point1) {
        if(point0.x < this.l) {
            point0.x = this.l;
        }
        if(point0.y < 0) {
            point0.y = 0;
        }
        Point point2 = this.a(point1);
        if(point2 != null) {
            if(z) {
                int v = point2.x <= point2.y ? point2.y : point2.x;
                if(point0.x > v) {
                    point0.x = v;
                }
                if(point0.y > v) {
                    point0.y = v;
                    return point0;
                }
            }
            else {
                if(point0.x > point2.x) {
                    point0.x = point2.x;
                }
                if(point0.y > point2.y) {
                    point0.y = point2.y;
                    return point0;
                }
            }
        }
        return point0;
    }

    protected String a(String s) {
        return "FloatPanel " + this.d + ' ' + s + ": " + this.c + ' ' + this.b;
    }

    protected void a(SharedPreferences sharedPreferences0) {
        String s = this.m == 1 ? "" : "-land";
        this.j = sharedPreferences0.getInt(this.d + s + "-x", this.getDefX());
        this.k = sharedPreferences0.getInt(this.d + s + "-y", this.getDefY());
        this.setLayoutXY(true);
    }

    protected boolean a() {
        return false;
    }

    protected void b() {
        this.setLayoutXY(false);
    }

    protected void c() {
        if(!this.b) {
            return;
        }
        Tools.c(this, this.a);
    }

    public void d() {
        rx.a(new ii(this));
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        try {
            float f = motionEvent0.getRawX();
            float f1 = motionEvent0.getRawY();
            float f2 = f - this.f;
            float f3 = f1 - this.g;
            switch(motionEvent0.getAction()) {
                case 0: {
                    this.f = f;
                    this.g = f1;
                    this.o = true;
                    break;
                }
                case 2: {
                    if(!this.o || Math.abs(f2) > FloatPanel.n || Math.abs(f3) > FloatPanel.n) {
                        if(this.o) {
                            this.b();
                            this.h = this.j;
                            this.i = this.k;
                        }
                        this.o = false;
                        this.a(f2, f3, false);
                        motionEvent0.setAction(3);
                    }
                    break;
                }
                case 1: 
                case 3: {
                    if(!this.o) {
                        this.a(f2, f3, true);
                    }
                }
            }
        }
        catch(NoSuchMethodError noSuchMethodError0) {
            la.a(noSuchMethodError0);
        }
        try {
            return super.dispatchTouchEvent(motionEvent0);
        }
        catch(ClassCastException classCastException0) {
            la.a(classCastException0);
            return false;
        }
    }

    protected void e() {
        if(this.b) {
            try {
                Tools.a(this);
            }
            catch(Throwable throwable0) {
                la.b("Failed hide float icon", throwable0);
            }
        }
        try {
            this.b = true;
            Tools.a(this, this.a);
        }
        catch(Throwable throwable1) {
            la.b("Failed add float icon", throwable1);
        }
    }

    public void f() {
        rx.a(new ij(this));
    }

    protected void g() {
        try {
            Tools.a(this);
        }
        catch(Throwable throwable0) {
            la.b("Failed hide float icon", throwable0);
        }
    }

    protected int getDefX() {
        return 0;
    }

    protected int getDefY() {
        return 0;
    }

    public float getLayoutAlpha() {
        return this.a.alpha;
    }

    public int getMarginX() {
        return this.l;
    }

    protected abstract String getPrefName();

    public void h() {
        this.c = true;
        this.f();
    }

    public boolean i() {
        return this.b;
    }

    private void j() {
        try {
            String s = this.m == 1 ? "" : "-land";
            new qw().a(this.d + s + "-x", this.j, this.getDefX()).a(this.d + s + "-y", this.k, this.getDefY()).commit();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.fix.LinearLayout
    protected void onConfigurationChanged(Configuration configuration0) {
        la.a(("FloatPanel onConfigurationChanged: " + configuration0));
        Configuration configuration1 = d.a(configuration0);
        super.onConfigurationChanged(configuration1);
        MainService.a(configuration1);
        if(configuration1.orientation != this.m) {
            this.j();
            this.m = configuration1.orientation;
            this.a(this.getContext().getSharedPreferences(MainService.a, 0));
            this.c();
        }
    }

    public void setLayoutAlpha(float f) {
        if(this.a.alpha != f) {
            this.a.alpha = f;
            this.c();
            if(!this.a()) {
                new qw().a("opacity", f, 1.0f).commit();
            }
        }
    }

    private void setLayoutXY(boolean z) {
        this.a(z);
        this.a.x = this.j + this.l;
        this.a.y = this.k;
    }

    public void setMarginX(int v) {
        this.l = v;
    }
}

