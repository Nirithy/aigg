package android.fix;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.ext.Tools;
import android.ext.la;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.InflateException;
import android.view.LayoutInflater.Factory2;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Filter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class i extends LayoutInflater {
    private Context a;
    private LayoutInflater b;
    private static final int[] c;

    static {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(0);
        arrayList0.add(1);
        if(Build.VERSION.SDK_INT >= 14) {
            arrayList0.add(0x1030128);
        }
        if(Build.VERSION.SDK_INT >= 21) {
            arrayList0.add(0x1030224);
        }
        if(Build.VERSION.SDK_INT >= 11) {
            arrayList0.add(0x103006B);
        }
        arrayList0.add(0x1030005);
        arrayList0.add(0x1030008);
        Field[] arr_field = R.class.getFields();
        for(int v = 0; v < arr_field.length; ++v) {
            Field field0 = arr_field[v];
            int v1 = field0.getModifiers();
            if(Modifier.isStatic(v1) && Modifier.isFinal(v1) && field0.getName().startsWith("Theme") && field0.getType().equals(Integer.TYPE)) {
                try {
                    arrayList0.add(field0.getInt(null));
                }
                catch(IllegalAccessException | IllegalArgumentException unused_ex) {
                }
            }
        }
        i.c = new int[arrayList0.size()];
        int v2 = arrayList0.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            i.c[v3] = (int)(((Integer)arrayList0.get(v3)));
        }
    }

    public i(LayoutInflater layoutInflater0) {
        super(layoutInflater0, layoutInflater0.getContext());
        this.b = layoutInflater0;
        this.a = layoutInflater0.getContext();
    }

    private int a(Context context0) {
        if(context0 == this.a) {
            return 1;
        }
        if(context0 instanceof ContextThemeWrapper) {
            try {
                Object object0 = ContextThemeWrapper.class.getDeclaredMethod("getThemeResId").invoke(context0);
                if(object0 instanceof Integer) {
                    return (int)(((Integer)object0));
                }
            }
            catch(Throwable throwable0) {
                la.c("getThemeResId failed call", throwable0);
            }
        }
        return 0;
    }

    public static i a() {
        return (i)k.a(i.from(Tools.e()));
    }

    public static View a(int v, ViewGroup viewGroup0) {
        return i.a().inflate(v, viewGroup0);
    }

    public static View a(int v, ViewGroup viewGroup0, boolean z) {
        return i.a().inflate(v, viewGroup0, z);
    }

    private View a(int v, XmlPullParser xmlPullParser0, ViewGroup viewGroup0, boolean z) {
        if(this.b == null) {
            return xmlPullParser0 == null ? super.inflate(v, viewGroup0, z) : super.inflate(xmlPullParser0, viewGroup0, z);
        }
        try {
            return this.b(v, xmlPullParser0, viewGroup0, z);
        }
        catch(InflateException inflateException0) {
            if(Build.VERSION.SDK_INT < 14 || !this.a(inflateException0, "tab_indicator_holo") && !this.a(inflateException0, "tab_selected_holo")) {
                throw inflateException0;
            }
            la.c("Try fix", inflateException0);
            return this.b(0x7F040027, null, viewGroup0, z);  // layout:tab_indicator_holo
        }
    }

    private void a(int v) {
        if(v != 0 && this.a(this.b.getContext()) != v) {
            this.b = this.b.cloneInContext(this.b(v));
        }
    }

    private boolean a(Throwable throwable0, String s) {
        if(s == null || throwable0 == null) {
            return false;
        }
        String s1 = throwable0.getMessage();
        return s1 == null || !s1.contains(s) ? this.a(throwable0.getCause(), s) : true;
    }

    private Context b(int v) {
        return v == 1 ? this.a : new ContextThemeWrapper(this.a, v);
    }

    private View b(int v, XmlPullParser xmlPullParser0, ViewGroup viewGroup0, boolean z) {
        LayoutInflater layoutInflater0;
        Throwable throwable0 = null;
        int[] arr_v = i.c;
        int v1 = 0;
        while(v1 < arr_v.length) {
            int v2 = arr_v[v1];
            try {
                layoutInflater0 = this.b;
                this.a(v2);
                return xmlPullParser0 == null ? this.b.inflate(v, viewGroup0, z) : this.b.inflate(xmlPullParser0, viewGroup0, z);
            }
            catch(Exception exception0) {
                if(throwable0 == null) {
                    throwable0 = exception0 instanceof RuntimeException ? ((RuntimeException)exception0) : new RuntimeException(exception0);
                }
                if(!(exception0 instanceof InflateException) && !(exception0 instanceof InvocationTargetException)) {
                    break;
                }
                la.c(("Exception on inflate with theme: " + v2), exception0);
                this.b = layoutInflater0;
                ++v1;
            }
        }
        throw throwable0;
    }

    @Override  // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context0) {
        return new i(this.b.cloneInContext(context0));
    }

    @Override
    public boolean equals(Object object0) {
        return this.b == null ? super.equals(object0) : this.b.equals(object0);
    }

    @Override  // android.view.LayoutInflater
    public Context getContext() {
        return this.b == null ? super.getContext() : this.b.getContext();
    }

    @Override  // android.view.LayoutInflater
    public LayoutInflater.Filter getFilter() {
        return this.b == null ? super.getFilter() : this.b.getFilter();
    }

    @Override
    public int hashCode() {
        return this.b == null ? super.hashCode() : this.b.hashCode();
    }

    @Override  // android.view.LayoutInflater
    public View inflate(int v, ViewGroup viewGroup0) {
        return viewGroup0 == null ? this.inflate(v, null, false) : this.inflate(v, viewGroup0, true);
    }

    @Override  // android.view.LayoutInflater
    public View inflate(int v, ViewGroup viewGroup0, boolean z) {
        return this.a(v, null, viewGroup0, z);
    }

    @Override  // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser0, ViewGroup viewGroup0) {
        return viewGroup0 == null ? this.inflate(xmlPullParser0, null, false) : this.inflate(xmlPullParser0, viewGroup0, true);
    }

    @Override  // android.view.LayoutInflater
    public View inflate(XmlPullParser xmlPullParser0, ViewGroup viewGroup0, boolean z) {
        return this.a(0, xmlPullParser0, viewGroup0, z);
    }

    @Override  // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory layoutInflater$Factory0) {
        if(this.b == null) {
            super.setFactory(layoutInflater$Factory0);
            return;
        }
        this.b.setFactory(layoutInflater$Factory0);
    }

    @Override  // android.view.LayoutInflater
    @TargetApi(11)
    public void setFactory2(LayoutInflater.Factory2 layoutInflater$Factory20) {
        if(this.b == null) {
            super.setFactory2(layoutInflater$Factory20);
            return;
        }
        this.b.setFactory2(layoutInflater$Factory20);
    }

    @Override  // android.view.LayoutInflater
    public void setFilter(LayoutInflater.Filter layoutInflater$Filter0) {
        if(this.b == null) {
            super.setFilter(layoutInflater$Filter0);
            return;
        }
        this.b.setFilter(layoutInflater$Filter0);
    }

    @Override
    public String toString() {
        return this.b == null ? super.toString() : this.b.toString();
    }
}

