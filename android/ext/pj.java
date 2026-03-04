package android.ext;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.fix.ToolbarButton;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public abstract class pj implements View.OnClickListener {
    private int a;
    private WeakReference b;
    private int c;
    public static final long[] e;
    protected String f;

    static {
        pj.e = new long[3];
    }

    public pj(int v, int v1) {
        this.a = 0;
        this.b = new WeakReference(null);
        this.c = -1;
        this.f = qk.a(v);
        this.a = v1;
    }

    public pj(String s) {
        this.a = 0;
        this.b = new WeakReference(null);
        this.c = -1;
        this.f = s;
    }

    private static void a() {
        qw qw0 = new qw();
        for(int v = 0; v < 3; ++v) {
            qw0.a("m-" + v, pj.e[v], 0L);
        }
        qw0.commit();
    }

    public ImageView a(boolean z) {
        ImageView imageView0 = new ToolbarButton(Tools.e());
        ((ToolbarButton)imageView0).setIcon(this.a);
        pj pj0 = z ? new pk(this) : this;
        ((ToolbarButton)imageView0).setOnClickListener(pj0);
        ((ToolbarButton)imageView0).setTag(this);
        return imageView0;
    }

    public void a(int v, int v1) {
        this.c = v * 0x40 + v1;
    }

    public void a(View view0) {
        int v = this.c;
        if(v != -1 && v / 0x40 >= 0 && v / 0x40 < 3) {
            long v1 = 1L << v % 0x40;
            if((pj.e[v / 0x40] & v1) == 0L) {
                pj.e[v / 0x40] |= v1;
                pj.a();
            }
        }
        this.onClick(view0);
    }

    public final ImageView c() {
        return this.a(false);
    }

    public Drawable d() {
        if(this.a == 0) {
            return null;
        }
        Drawable drawable0 = (Drawable)this.b.get();
        if(drawable0 == null) {
            drawable0 = Tools.b(this.a);
            this.b = new WeakReference(drawable0);
            return drawable0;
        }
        return drawable0;
    }

    public static String e() {
        SharedPreferences sharedPreferences0 = Tools.s();
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < 3; ++v) {
            long v1 = sharedPreferences0.getLong("m-" + v, 0L);
            sharedPreferences$Editor0.remove("m-" + v);
            if(v1 != 0L) {
                stringBuilder0.append("&m");
                stringBuilder0.append(v);
                stringBuilder0.append('=');
                stringBuilder0.append(Long.toHexString(v1));
            }
        }
        sharedPreferences$Editor0.commit();
        return stringBuilder0.toString();
    }

    @Override  // android.view.View$OnClickListener
    public abstract void onClick(View arg1);

    @Override
    public String toString() {
        return this.f;
    }
}

