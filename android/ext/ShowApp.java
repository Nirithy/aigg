package android.ext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.fix.ImageView;
import android.fix.TextView;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@SuppressLint({"ClickableViewAccessibility"})
public class ShowApp extends ImageView {
    WindowManager.LayoutParams a;
    WindowManager.LayoutParams b;
    TextView c;
    WindowManager.LayoutParams d;
    volatile boolean e;
    volatile boolean f;
    volatile View g;
    volatile View h;
    volatile View i;
    final Runnable j;
    private static ArrayList k;

    static {
        ShowApp.k = new ArrayList();
    }

    public ShowApp(Context context0) {
        super(context0);
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        if(!this.isInEditMode()) {
            TextView textView0 = new TextView(this.getContext());
            this.c = textView0;
            try {
                textView0.setGravity(17);
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
            }
            textView0.setText("http://gameguardian.net/download");
            textView0.setBackgroundColor(0xFF000000);
            WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
            this.b = windowManager$LayoutParams0;
            windowManager$LayoutParams0.type = 0x7F6;
            windowManager$LayoutParams0.width = -2;
            windowManager$LayoutParams0.height = -2;
            windowManager$LayoutParams0.format = -2;
            windowManager$LayoutParams0.gravity = 51;
            windowManager$LayoutParams0.x = -10000;
            windowManager$LayoutParams0.y = -10000;
            windowManager$LayoutParams0.flags = 8;
            WindowManager.LayoutParams windowManager$LayoutParams1 = new WindowManager.LayoutParams();
            this.a = windowManager$LayoutParams1;
            windowManager$LayoutParams1.type = 0x7F6;
            windowManager$LayoutParams1.width = (int)Tools.a(60.0f);
            windowManager$LayoutParams1.height = (int)Tools.a(20.0f);
            windowManager$LayoutParams1.format = -2;
            windowManager$LayoutParams1.gravity = 51;
            windowManager$LayoutParams1.x = 10000;
            windowManager$LayoutParams1.y = 10000;
            windowManager$LayoutParams1.flags = 0x108;
            WindowManager.LayoutParams windowManager$LayoutParams2 = new WindowManager.LayoutParams();
            this.d = windowManager$LayoutParams2;
            windowManager$LayoutParams2.type = 0x7F6;
            windowManager$LayoutParams2.width = -2;
            windowManager$LayoutParams2.height = -2;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.gravity = 49;
            windowManager$LayoutParams2.x = 0;
            windowManager$LayoutParams2.y = -1000;
            windowManager$LayoutParams2.flags = 24;
            this.setOnTouchListener(new rj(this));
        }
        this.j = new rm(this);
    }

    public ShowApp(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        if(!this.isInEditMode()) {
            TextView textView0 = new TextView(this.getContext());
            this.c = textView0;
            try {
                textView0.setGravity(17);
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
            }
            textView0.setText("http://gameguardian.net/download");
            textView0.setBackgroundColor(0xFF000000);
            WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
            this.b = windowManager$LayoutParams0;
            windowManager$LayoutParams0.type = 0x7F6;
            windowManager$LayoutParams0.width = -2;
            windowManager$LayoutParams0.height = -2;
            windowManager$LayoutParams0.format = -2;
            windowManager$LayoutParams0.gravity = 51;
            windowManager$LayoutParams0.x = -10000;
            windowManager$LayoutParams0.y = -10000;
            windowManager$LayoutParams0.flags = 8;
            WindowManager.LayoutParams windowManager$LayoutParams1 = new WindowManager.LayoutParams();
            this.a = windowManager$LayoutParams1;
            windowManager$LayoutParams1.type = 0x7F6;
            windowManager$LayoutParams1.width = (int)Tools.a(60.0f);
            windowManager$LayoutParams1.height = (int)Tools.a(20.0f);
            windowManager$LayoutParams1.format = -2;
            windowManager$LayoutParams1.gravity = 51;
            windowManager$LayoutParams1.x = 10000;
            windowManager$LayoutParams1.y = 10000;
            windowManager$LayoutParams1.flags = 0x108;
            WindowManager.LayoutParams windowManager$LayoutParams2 = new WindowManager.LayoutParams();
            this.d = windowManager$LayoutParams2;
            windowManager$LayoutParams2.type = 0x7F6;
            windowManager$LayoutParams2.width = -2;
            windowManager$LayoutParams2.height = -2;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.gravity = 49;
            windowManager$LayoutParams2.x = 0;
            windowManager$LayoutParams2.y = -1000;
            windowManager$LayoutParams2.flags = 24;
            this.setOnTouchListener(new rj(this));
        }
        this.j = new rm(this);
    }

    public ShowApp(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        if(!this.isInEditMode()) {
            TextView textView0 = new TextView(this.getContext());
            this.c = textView0;
            try {
                textView0.setGravity(17);
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
            }
            textView0.setText("http://gameguardian.net/download");
            textView0.setBackgroundColor(0xFF000000);
            WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
            this.b = windowManager$LayoutParams0;
            windowManager$LayoutParams0.type = 0x7F6;
            windowManager$LayoutParams0.width = -2;
            windowManager$LayoutParams0.height = -2;
            windowManager$LayoutParams0.format = -2;
            windowManager$LayoutParams0.gravity = 51;
            windowManager$LayoutParams0.x = -10000;
            windowManager$LayoutParams0.y = -10000;
            windowManager$LayoutParams0.flags = 8;
            WindowManager.LayoutParams windowManager$LayoutParams1 = new WindowManager.LayoutParams();
            this.a = windowManager$LayoutParams1;
            windowManager$LayoutParams1.type = 0x7F6;
            windowManager$LayoutParams1.width = (int)Tools.a(60.0f);
            windowManager$LayoutParams1.height = (int)Tools.a(20.0f);
            windowManager$LayoutParams1.format = -2;
            windowManager$LayoutParams1.gravity = 51;
            windowManager$LayoutParams1.x = 10000;
            windowManager$LayoutParams1.y = 10000;
            windowManager$LayoutParams1.flags = 0x108;
            WindowManager.LayoutParams windowManager$LayoutParams2 = new WindowManager.LayoutParams();
            this.d = windowManager$LayoutParams2;
            windowManager$LayoutParams2.type = 0x7F6;
            windowManager$LayoutParams2.width = -2;
            windowManager$LayoutParams2.height = -2;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.gravity = 49;
            windowManager$LayoutParams2.x = 0;
            windowManager$LayoutParams2.y = -1000;
            windowManager$LayoutParams2.flags = 24;
            this.setOnTouchListener(new rj(this));
        }
        this.j = new rm(this);
    }

    @TargetApi(21)
    public ShowApp(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        if(!this.isInEditMode()) {
            TextView textView0 = new TextView(this.getContext());
            this.c = textView0;
            try {
                textView0.setGravity(17);
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
            }
            textView0.setText("http://gameguardian.net/download");
            textView0.setBackgroundColor(0xFF000000);
            WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
            this.b = windowManager$LayoutParams0;
            windowManager$LayoutParams0.type = 0x7F6;
            windowManager$LayoutParams0.width = -2;
            windowManager$LayoutParams0.height = -2;
            windowManager$LayoutParams0.format = -2;
            windowManager$LayoutParams0.gravity = 51;
            windowManager$LayoutParams0.x = -10000;
            windowManager$LayoutParams0.y = -10000;
            windowManager$LayoutParams0.flags = 8;
            WindowManager.LayoutParams windowManager$LayoutParams1 = new WindowManager.LayoutParams();
            this.a = windowManager$LayoutParams1;
            windowManager$LayoutParams1.type = 0x7F6;
            windowManager$LayoutParams1.width = (int)Tools.a(60.0f);
            windowManager$LayoutParams1.height = (int)Tools.a(20.0f);
            windowManager$LayoutParams1.format = -2;
            windowManager$LayoutParams1.gravity = 51;
            windowManager$LayoutParams1.x = 10000;
            windowManager$LayoutParams1.y = 10000;
            windowManager$LayoutParams1.flags = 0x108;
            WindowManager.LayoutParams windowManager$LayoutParams2 = new WindowManager.LayoutParams();
            this.d = windowManager$LayoutParams2;
            windowManager$LayoutParams2.type = 0x7F6;
            windowManager$LayoutParams2.width = -2;
            windowManager$LayoutParams2.height = -2;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.gravity = 49;
            windowManager$LayoutParams2.x = 0;
            windowManager$LayoutParams2.y = -1000;
            windowManager$LayoutParams2.flags = 24;
            this.setOnTouchListener(new rj(this));
        }
        this.j = new rm(this);
    }

    private void a(View view0, float f) {
        if(view0 == null) {
            return;
        }
        else {
            try {
                if(Build.VERSION.SDK_INT >= 11) {
                    view0.setAlpha(f);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        la.b("Failed set transparency", throwable0);
    }

    public static void a(Window window0) {
        WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
        ArrayList arrayList0 = ShowApp.k;
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            ru ru0 = (ru)object0;
            Window window1 = (Window)ru0.a.get();
            if(window1 != null && window1 != window0) {
                arrayList1.add(ru0);
            }
        }
        arrayList1.add(new ru(new WeakReference(window0), (windowManager$LayoutParams0.flags & 2) != 0, windowManager$LayoutParams0.dimAmount));
        ShowApp.k = arrayList1;
        arrayList0.clear();
        arrayList0.trimToSize();
    }

    public void a() {
        rx.a(new rn(this));
    }

    void a(boolean z) {
        for(Object object0: ShowApp.k) {
            ru ru0 = (ru)object0;
            Window window0 = (Window)ru0.a.get();
            if(window0 != null) {
                try {
                    WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                    float f = z ? 0.0f : 1.0f;
                    windowManager$LayoutParams0.alpha = f;
                    if(ru0.b) {
                        windowManager$LayoutParams0.flags = z ? windowManager$LayoutParams0.flags & -3 : windowManager$LayoutParams0.flags | 2;
                        windowManager$LayoutParams0.dimAmount = z ? 0.0f : ru0.c;
                    }
                    window0.setAttributes(windowManager$LayoutParams0);
                }
                catch(Throwable throwable0) {
                    la.b("Failed set transparency", throwable0);
                }
            }
        }
        if(this.e) {
            this.a(this.c, (z ? 0.0f : 1.0f));
        }
        this.a(this.g, (z ? 0.0f : 1.0f));
        this.a(this.h, (z ? 0.0f : 1.0f));
        this.a(this.i, (z ? 0.0f : 1.0f));
    }

    boolean a(View view0) {
        if(view0 != null) {
            try {
                if(view0 instanceof FloatPanel) {
                    ((FloatPanel)view0).f();
                    return true;
                }
                Tools.a(view0);
                return true;
            }
            catch(Throwable throwable0) {
                la.b(("Failed remove view " + view0), throwable0);
            }
        }
        return false;
    }

    boolean a(View view0, WindowManager.LayoutParams windowManager$LayoutParams0) {
        boolean z;
        if(view0 != null) {
            try {
                if(view0 instanceof FloatPanel) {
                    ((FloatPanel)view0).d();
                }
                else {
                    Tools.a(view0, windowManager$LayoutParams0);
                }
            }
            catch(Throwable throwable0) {
                la.b(("Failed add view " + view0), throwable0);
                return false;
            }
            try {
                z = true;
                if(Build.VERSION.SDK_INT >= 11) {
                    view0.setAlpha(1.0f);
                }
                return true;
            }
            catch(Throwable throwable1) {
                throwable0 = throwable1;
            }
            la.b(("Failed add view " + view0), throwable0);
            return z;
        }
        return false;
    }

    public void b() {
        rx.a(new ro(this));
    }

    void b(View view0) {
        if(view0 != null) {
            if(this.a(view0)) {
                this.g = null;
            }
            if(this.a(this.h)) {
                this.h = null;
            }
        }
    }

    public void b(boolean z) {
        if(z) {
            this.c();
        }
        else {
            rx.a().postDelayed(this.j, 2000L);
        }
        rx.a(new rl(this, z));
    }

    public void c() {
        rx.a(new rp(this));
    }

    public void d() {
        rx.a(new rq(this));
    }

    public void e() {
        rx.a(new rr(this));
    }

    public void f() {
        this.b();
        this.d();
        rx.a(new rs(this));
    }

    public void g() {
        if(this.g != null) {
            this.b();
        }
        if(this.i != null) {
            this.d();
        }
        if(this.f) {
            this.f();
        }
    }

    public void h() {
        if(this.g == null) {
            this.b();
        }
        if(this.i == null) {
            this.d();
        }
        rx.a(new rt(this));
    }

    public void i() {
        this.c();
        rx.a(new rk(this));
    }
}

