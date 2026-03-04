package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.j;
import android.view.View;
import android.widget.EditText;
import java.lang.ref.WeakReference;

public abstract class re extends pj implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    protected String b;
    protected int c;
    protected String d;
    protected int g;
    protected Searcher h;
    protected WeakReference i;

    public re(int v, int v1) {
        super(v, v1);
        this.b = "";
        this.c = 0x20000000;
        this.d = "FFFFFFFFFFFFFFFF";
        this.g = -1;
        this.i = new WeakReference(null);
    }

    public static void a(NumberFormatException numberFormatException0, EditText editText0) {
        la.b("Error", numberFormatException0);
        if(editText0 != null && numberFormatException0 instanceof ak) {
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(numberFormatException0.getMessage()).setPositiveButton(qk.a(0x7F07009B), new rf(editText0, ((ak)numberFormatException0))).setNegativeButton(qk.a(0x7F07009C), null));  // string:error "Error"
            return;
        }
        i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(numberFormatException0.getMessage()).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
    }

    public abstract void a(DialogInterface arg1, int arg2);

    public static String c(String s) [...] // 潜在的解密器

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        switch(v) {
            case -2: {
                break;
            }
            case -3: 
            case -1: {
                this.g = v;
                this.onClick(null);
                break;
            }
            default: {
                try {
                    this.h.a(v);
                    this.a(dialogInterface0, v);
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
        }
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        String s1;
        boolean z = false;
        if(view0 != null && view0.getTag() instanceof Integer) {
            this.g = (int)(((Integer)view0.getTag()));
        }
        if(view0 != null && view0.getTag() instanceof pj) {
            if(!MainService.instance.k.y()) {
                return;
            }
            if(this.h == null) {
                this.h = new Searcher((this instanceof ov ? 3 : 0), 0x7F);
            }
            this.h.a(qk.a((this instanceof ov ? 0x7F0701FD : 0x7F0700ED)));  // string:mask_request "Enter an address to search for"
            this.h.c(this.c);
            this.h.b(this.b);
            if(this instanceof ov) {
                this.h.c(this.d);
                this.h.n().setTag(new kt(1));
            }
            this.h.b(0x7F);
            AlertDialog.Builder alertDialog$Builder0 = i.c().setView(this.h.l()).setNegativeButton(qk.a(0x7F0700A1), null);  // string:cancel "Cancel"
            if(MainService.instance.aj == 0L) {
                alertDialog$Builder0.setPositiveButton(qk.a(0x7F0701A2), this);  // string:new_search "New search"
            }
            else {
                alertDialog$Builder0.setPositiveButton(qk.a(0x7F07019F), this).setNeutralButton(qk.a(0x7F0701A2), this);  // string:refine "Refine"
            }
            this.g = -1;
            AlertDialog alertDialog0 = alertDialog$Builder0.create();
            i.a(alertDialog0, this);
            i.a(alertDialog0, this);
            this.i = new WeakReference(alertDialog0);
            i.a(alertDialog0, this.h.o());
            return;
        }
        int v = this.h.d();
        if(v == 0) {
            if(this instanceof ov) {
                new tu(d.a(0x7F, true), "0", qk.a(0x7F0700EE), this);  // string:type_request "Select the type of data to search"
                return;
            }
            String s = this.h.f();
            try {
                s1 = re.c(s);
            }
            catch(NumberFormatException numberFormatException0) {
                re.a(numberFormatException0, this.h.o());
                return;
            }
            if(s1.indexOf(59) != -1 || s1.indexOf(0x7E) != -1 || s1.indexOf(88) != -1 || s1.indexOf(120) != -1) {
                z = true;
            }
            j j0 = d.a(0x7F, true);
            if(z) {
                s1 = "0";
            }
            new tu(j0, s1, qk.a(0x7F0700EE), this);  // string:type_request "Select the type of data to search"
            return;
        }
        this.onClick(null, v);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        if(this.h != null) {
            this.h.m();
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, -1, this);
        Tools.a(dialogInterface0, -3, -3, this);
        if(this.h != null) {
            this.h.a();
        }
    }
}

