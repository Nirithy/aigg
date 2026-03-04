package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import java.lang.ref.WeakReference;

public class qe extends re {
    private static String a;
    private static boolean j;

    static {
        qe.a = "0";
        qe.j = true;
    }

    public qe() {
        super(0x7F070259, 0x7F020040);  // string:help_pointer_search_title "Pointer search"
    }

    private int a() {
        qh qh0 = MainService.instance.ap;
        return qh0 == null || !qh0.n ? 4 : 36;
    }

    @Override  // android.ext.re
    public void a(DialogInterface dialogInterface0, int v) {
    }

    public void a(String s) {
        boolean z = true;
        if(!MainService.instance.k.y()) {
            return;
        }
        MainService mainService0 = MainService.instance;
        int v = this.a();
        if(this.h == null) {
            this.h = new Searcher(4, v);
        }
        this.h.b(s == null);
        Searcher searcher0 = this.h;
        if(s == null) {
            s = this.b;
        }
        searcher0.b(s);
        this.h.a(qk.a(0x7F0701FD));  // string:mask_request "Enter an address to search for"
        this.h.d("0");
        this.h.a(qe.j);
        Searcher searcher1 = this.h;
        if(v == 4) {
            z = false;
        }
        searcher1.a(d.a(v, z), v);
        AlertDialog.Builder alertDialog$Builder0 = i.c().setView(this.h.l()).setNegativeButton(qk.a(0x7F0700A1), null);  // string:cancel "Cancel"
        if(mainService0.aj != 0L && (MainService.a() & v) != 0) {
            alertDialog$Builder0.setPositiveButton(qk.a(0x7F07019F), this).setNeutralButton(qk.a(0x7F0701A2), this);  // string:refine "Refine"
        }
        else {
            alertDialog$Builder0.setPositiveButton(qk.a(0x7F0701A2), this);  // string:new_search "New search"
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        i.a(alertDialog0, this);
        i.a(alertDialog0, this);
        this.i = new WeakReference(alertDialog0);
        i.a(alertDialog0, this.h.o());
    }

    @Override  // android.ext.re
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            int v1 = 16;
            boolean z = false;
            long v2 = ps.a(qe.c(this.h.f()), 16);
            String s = qe.c(this.h.i());
            if(!this.h.j()) {
                v1 = 10;
            }
            long v3 = ps.a(s, v1);
            int v4 = this.h.d();
            String s1 = d.b(v2, v4) + 'h';
            String s2 = d.b(v2 - v3, v4) + 'h';
            if(v3 > 0L) {
                s1 = String.valueOf(s2) + '~' + s1;
            }
            else if(v3 < 0L) {
                s1 = String.valueOf(s1) + '~' + s2;
            }
            long v5 = this.h.d(0);
            long v6 = this.h.d(1);
            if(v == -3 || (MainService.a() & v4) == 0) {
                z = true;
            }
            ra.a(s1, v4, false, 0x20000000, v5, v6, z, this.h.p());
            MainService.instance.a(1);
            Tools.a(this.i);
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, this.h.o());
            return;
        }
        catch(Throwable throwable0) {
            la.c("Exception on start search", throwable0);
        }
        Tools.b(this.i);
    }

    @Override  // android.ext.re
    public void onClick(View view0) {
        if(view0 != null && view0.getTag() instanceof Integer) {
            this.onClick(null, ((int)(((Integer)view0.getTag()))));
            return;
        }
        this.a(null);
    }

    @Override  // android.ext.re
    public void onDismiss(DialogInterface dialogInterface0) {
        if(this.h != null) {
            qe.j = this.h.j();
            qe.a = this.h.i();
            this.b = this.h.f();
        }
        super.onDismiss(dialogInterface0);
    }
}

