package android.ext;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.fix.i;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HotPoint extends FloatPanel implements View.OnClickListener, View.OnLongClickListener {
    int e;
    int f;
    ImageView g;
    View h;
    View i;
    TextView j;
    ProgressBar k;
    ProgressBar l;
    TextView m;
    ImageView n;
    ImageView o;
    private final Runnable p;
    private WindowManager.LayoutParams q;
    private boolean r;
    private static volatile HotPoint s;

    static {
        HotPoint.s = null;
    }

    public HotPoint(Context context0) {
        super(context0);
        this.p = new jg(this);
    }

    public HotPoint(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.p = new jg(this);
    }

    @TargetApi(11)
    public HotPoint(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.p = new jg(this);
    }

    @TargetApi(21)
    public HotPoint(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.p = new jg(this);
    }

    @Override  // android.ext.FloatPanel
    protected String a(String s) {
        return super.a(s) + ' ' + this.e + ' ' + this.f;
    }

    public void a(byte b, long v, long v1, int v2, int v3, String s) {
        if(rx.c()) {
            this.b(b, v, v1, v2, v3, s);
            return;
        }
        rx.a(new jj(this, b, v, v1, v2, v3, s));
    }

    @Override  // android.ext.FloatPanel
    protected void a(SharedPreferences sharedPreferences0) {
        super.a(sharedPreferences0);
        this.e = sharedPreferences0.getInt("vanishing-time", -1);
        this.f = Math.max(0, Math.min(12, sharedPreferences0.getInt("icon-size", 0)));
    }

    public void a(Drawable drawable0) {
        rx.a(new jl(this, drawable0));
    }

    void a(boolean z) {
        try {
            rx.a().removeCallbacks(this.p);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        if(z) {
            Tools.a(this.g, 255.0f);
            try {
                rx.a().postDelayed(this.p, ((long)(this.e * 1000)));
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
                Tools.a(this.g, 0.0f);
            }
        }
    }

    void b(byte b, long v, long v1, int v2, int v3, String s) {
        if(b != 0) {
            this.i.setVisibility((b == 1 ? 0 : 8));
        }
        if(v >= 0L && v1 != 0L) {
            this.k.setIndeterminate(false);
            this.k.setMax(((int)v1));
            this.k.setProgress(((int)v));
            this.j.setText(s);
        }
        else {
            this.j.setText(s);
            this.k.setIndeterminate(true);
        }
        if(v2 >= 0) {
            if(v3 <= 1) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setMax(v3);
            this.l.setProgress(v2);
            this.l.setVisibility(0);
        }
    }

    public void b(String s) {
        rx.a(new jm(this, s));
    }

    @Override  // android.ext.FloatPanel
    public void c() {
        super.c();
        if(this.r) {
            Point point0 = new Point(0, 0);
            Point point1 = this.a(new Point(this.a.x, this.a.y), false, point0);
            if(point1.x < 0) {
                point1.x = 0;
            }
            if(point1.x > point0.x + this.getMarginX()) {
                point1.x = point0.x + this.getMarginX();
            }
            WindowManager.LayoutParams windowManager$LayoutParams0 = this.q;
            windowManager$LayoutParams0.x = point1.x + this.getWidth() / 2 - this.m.getWidth() / 2;
            WindowManager.LayoutParams windowManager$LayoutParams1 = this.q;
            windowManager$LayoutParams1.y = point1.y + this.getHeight();
            if(point0.y != 0) {
                int v = this.m.getHeight();
                if(point0.y < point1.y + v) {
                    this.q.y = point1.y - v;
                }
            }
            Tools.c(this.m, this.q);
        }
    }

    @Override  // android.ext.FloatPanel
    protected void e() {
        super.e();
        int v = this.getSizePx();
        Config.b(this.n, v);
        Config.b(this.o, v);
        Config.b(this.g, v);
        this.h.setMinimumWidth(v);
        this.h.setMinimumHeight(v);
        Tools.a(this.j, ((float)v));
        Tools.b(this.j, ((float)(v * 20 / 0x30)));
        Tools.a(this.k, ((float)v));
        Tools.b(this.k, ((float)(v * 14 / 0x30)));
        Tools.a(this.l, ((float)v));
        Tools.b(this.l, ((float)(v * 14 / 0x30)));
        this.j.setTextSize(0, ((float)(v * 18 / 0x30)));
        this.m.setTextSize(0, ((float)(v * 18 / 0x30)));
        if(this.e < 0) {
            Tools.a(this.g, 255.0f);
        }
        else {
            this.a(true);
        }
        this.setSpeedPanelVisibility(true);
        TimeJumpPanel.a(true);
    }

    @Override  // android.ext.FloatPanel
    protected void g() {
        super.g();
        this.a(false);
        this.setSpeedPanelVisibility(false);
        TimeJumpPanel.a(false);
    }

    public static HotPoint getInstance() {
        HotPoint hotPoint0 = HotPoint.s;
        if(hotPoint0 == null) {
            hotPoint0 = (HotPoint)i.a(0x7F040005, null);  // layout:hot_point_view
            hotPoint0.n();
            HotPoint.s = hotPoint0;
        }
        return hotPoint0;
    }

    @Override  // android.ext.FloatPanel
    protected String getPrefName() {
        return "pos";
    }

    public int getSize() {
        return this.f;
    }

    public int getSizePx() {
        return (int)Tools.a(0x30 - this.f * 2);
    }

    public int getVanishingTime() {
        return this.e;
    }

    void j() {
        this.q = new WindowManager.LayoutParams();
        this.q.gravity = 51;
        this.q.type = 0x7F6;
        this.q.format = -2;
        this.q.flags = 0x200;
        this.q.alpha = 1.0f;
        this.q.width = -2;
        this.q.height = -2;
    }

    public void k() {
        this.setVisibilitySpeedhack(8);
    }

    public void l() {
        this.setVisibilitySpeedhack(-1);
    }

    public void m() {
        TimeJumpPanel.a(this.i());
    }

    private void n() {
        rx.a(new jh(this));
    }

    private void o() {
        int v2;
        if(this.h != null) {
            int v = this.getMarginX();
            int v1 = 0;
            for(View view0 = this.h; true; view0 = (View)viewParent0) {
                if(view0 != this && view0 != null) {
                    v1 -= view0.getLeft();
                    ViewParent viewParent0 = view0.getParent();
                    if(viewParent0 instanceof View) {
                        continue;
                    }
                    else {
                        v2 = v1;
                    }
                }
                else {
                    v2 = v1;
                }
                if(v == v2) {
                    break;
                }
                this.setMarginX(v2);
                this.b();
                this.c();
                return;
            }
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.n) {
            MainService.instance.m();
            return;
        }
        if(view0 == this.o) {
            MainService.instance.n();
        }
    }

    @Override  // android.widget.LinearLayout
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.o();
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        MainService.instance.o();
        return true;
    }

    @Override  // android.ext.FloatPanel
    public void setLayoutAlpha(float f) {
        this.q.alpha = f;
        super.setLayoutAlpha(f);
        TimeJumpPanel timeJumpPanel0 = MainService.instance.m;
        if(timeJumpPanel0 != null) {
            timeJumpPanel0.setLayoutAlpha(f);
        }
    }

    public void setSize(int v) {
        int v1 = Math.max(0, Math.min(12, v));
        if(this.f == v1) {
            return;
        }
        new qw().a("icon-size", v1, 0).commit();
        this.f = v1;
    }

    void setSpeedPanelVisibility(boolean z) {
        boolean z1 = this.n.getVisibility() == 0;
        if(this.r) {
            try {
                Tools.a(this.m);
            }
            catch(Throwable throwable0) {
                la.b("Failed hide speed panel", throwable0);
            }
            this.r = false;
        }
        if(z && z1) {
            try {
                this.r = true;
                Tools.a(this.m, this.q);
            }
            catch(Throwable throwable1) {
                la.b("Failed add speed panel", throwable1);
            }
        }
    }

    public void setVanishingTime(int v) {
        if(this.e == v) {
            return;
        }
        new qw().a("vanishing-time", v, -1).commit();
        this.e = v;
    }

    private void setVisibilitySpeedhack(int v) {
        rx.a(new jk(this, v));
    }
}

