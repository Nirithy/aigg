package android.ext;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class i {
    static final Runnable a;
    private static volatile int b;
    private static final List c;
    private static final List d;
    private static ArrayList e;

    static {
        i.a = () -> if(MainService.instance != null) {
            MainService.instance.Z.g();
            if(MainService.instance.X != MainService.instance.W) {
                MainService.instance.Z.h();
            }
        };
        i.b = 0;
        i.c = new ArrayList();
        i.d = new ArrayList();
        i.e = new ArrayList();
    }

    public static AlertDialog.Builder a(Context context0) {
        return new AlertDialog.Builder(context0);
    }

    public static AlertDialog a(AlertDialog alertDialog0, EditText editText0) {
        if(editText0 != null) {
            editText0.setOnEditorActionListener(new EditorActionListener(alertDialog0));
        }
        i.e(alertDialog0);
        rx.a(new m(alertDialog0));
        return alertDialog0;
    }

    // 检测为 Lambda 实现
    static void a() [...]

    public static void a(AlertDialog.Builder alertDialog$Builder0) {
        i.a(alertDialog$Builder0, null);
    }

    public static void a(AlertDialog.Builder alertDialog$Builder0, Context context0) {
        i.a(alertDialog$Builder0, null);
    }

    public static void a(AlertDialog.Builder alertDialog$Builder0, android.ext.EditText editText0) {
        rx.a(new o(alertDialog$Builder0, editText0));
    }

    static void a(AlertDialog alertDialog0) {
        i.a(alertDialog0, null);
        alertDialog0.show();
    }

    public static void a(AlertDialog alertDialog0, DialogInterface.OnDismissListener dialogInterface$OnDismissListener0) {
        int v1;
        p p0 = null;
        for(int v = 0; v < i.d.size(); v = v1 + 1) {
            p p1 = (p)i.d.get(v);
            if(p1 == null) {
                i.d.remove(v);
                v1 = v - 1;
            }
            else {
                AlertDialog alertDialog1 = (AlertDialog)p1.a.get();
                if(alertDialog1 == null) {
                    i.d.remove(v);
                    v1 = v - 1;
                }
                else if(alertDialog1 == alertDialog0) {
                    v1 = v;
                    p0 = p1;
                }
                else {
                    v1 = v;
                }
            }
        }
        if(p0 == null) {
            q q0 = new q(null);
            alertDialog0.setOnDismissListener(q0);
            p0 = new p(alertDialog0, q0);
            i.d.add(p0);
        }
        ((q)p0.b.get()).a(dialogInterface$OnDismissListener0);
    }

    public static void a(AlertDialog alertDialog0, DialogInterface.OnShowListener dialogInterface$OnShowListener0) {
        int v1;
        r r0 = null;
        for(int v = 0; v < i.c.size(); v = v1 + 1) {
            r r1 = (r)i.c.get(v);
            if(r1 == null) {
                i.c.remove(v);
                v1 = v - 1;
            }
            else {
                AlertDialog alertDialog1 = (AlertDialog)r1.a.get();
                if(alertDialog1 == null) {
                    i.c.remove(v);
                    v1 = v - 1;
                }
                else if(alertDialog1 == alertDialog0) {
                    v1 = v;
                    r0 = r1;
                }
                else {
                    v1 = v;
                }
            }
        }
        if(r0 == null) {
            s s0 = new s(null);
            alertDialog0.setOnShowListener(s0);
            r0 = new r(alertDialog0, s0);
            i.c.add(r0);
        }
        ((s)r0.b.get()).a(dialogInterface$OnShowListener0);
    }

    public static void a(AlertDialog alertDialog0, Runnable runnable0, boolean z) {
        i.a(alertDialog0, new k(runnable0));
        if(z) {
            i.a(alertDialog0, new l(runnable0));
        }
        rx.a().postDelayed(runnable0, 3000L);
        la.a((runnable0 + ": 10_"));
        i.c(alertDialog0);
        la.a((runnable0 + ": 20_"));
    }

    static void b() {
        if(MainService.instance != null) {
            --i.b;
            if(i.b <= 0) {
                rx.a().removeCallbacks(i.a);
                MainService.instance.Z.i();
                i.b = 0;
            }
        }
    }

    public static void b(AlertDialog.Builder alertDialog$Builder0) {
        ex.a(new n(alertDialog$Builder0));
    }

    public static void b(AlertDialog alertDialog0) {
        try {
            alertDialog0.show();
        }
        catch(WindowManager.BadTokenException unused_ex) {
            i.c(alertDialog0);
        }
    }

    public static AlertDialog.Builder c() {
        return i.a(Tools.e());
    }

    public static AlertDialog c(AlertDialog alertDialog0) {
        i.a(alertDialog0, null);
        return alertDialog0;
    }

    public static void d() {
        for(Object object0: i.e) {
            AlertDialog alertDialog0 = (AlertDialog)((WeakReference)object0).get();
            if(alertDialog0 != null) {
                try {
                    if(!alertDialog0.isShowing()) {
                        continue;
                    }
                    Tools.a(alertDialog0);
                }
                catch(Throwable throwable0) {
                    la.b(("Failed dismiss dialog: " + alertDialog0), throwable0);
                }
            }
        }
        if(MainService.instance != null) {
            MainService.instance.g();
        }
    }

    public static void d(AlertDialog alertDialog0) {
        if(alertDialog0.getWindow().getAttributes().type < 2000) {
            return;
        }
        ArrayList arrayList0 = i.e;
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            AlertDialog alertDialog1 = (AlertDialog)weakReference0.get();
            if(alertDialog1 != null && alertDialog1 != alertDialog0) {
                arrayList1.add(weakReference0);
            }
        }
        arrayList1.add(new WeakReference(alertDialog0));
        i.e = arrayList1;
        arrayList0.clear();
        arrayList0.trimToSize();
    }

    @TargetApi(11)
    private static void e(AlertDialog alertDialog0) {
        Window window0 = alertDialog0.getWindow();
        if(Build.VERSION.SDK_INT >= 11) {
            window0.setCallback(new uv(window0.getCallback()));
        }
        window0.clearFlags(0x1000000);
    }

    private static boolean e() [...] // 潜在的解密器

    private static void f(AlertDialog alertDialog0) {
        ListView listView0;
        try {
            listView0 = alertDialog0.getListView();
        }
        catch(Throwable throwable0) {
            listView0 = null;
            la.a(throwable0);
        }
        if(listView0 == null) {
            return;
        }
        else {
            try {
                AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = listView0.getOnItemClickListener();
                if(adapterView$OnItemClickListener0 != null && !(adapterView$OnItemClickListener0 instanceof t)) {
                    listView0.setOnItemClickListener(new t(alertDialog0, adapterView$OnItemClickListener0, null));
                    return;
                }
                return;
            }
            catch(Throwable throwable1) {
            }
        }
        la.a(throwable1);
    }
}

