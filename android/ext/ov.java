package android.ext;

import android.content.DialogInterface;
import android.view.View.OnClickListener;

public class ov extends re implements View.OnClickListener {
    public ov() {
        super(0x7F0701FE, 0x7F020035);  // string:help_mask_search_title "Address (mask) search"
    }

    public static boolean a(byte b, String s, long v, int v1, int v2, long v3, long v4, boolean z, long v5) {
        int v6 = v1 & 0x7F;
        MainService mainService0 = MainService.instance;
        if(mainService0.aj != 0L && !z) {
            v6 &= MainService.a() & 0x7F;
        }
        if(v6 == 0) {
            mainService0.a(b);
            return true;
        }
        long[] arr_v = Searcher.a(s, v);
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L && z) {
            mainService0.a(b);
        }
        if(mainService0.aj == 0L) {
            mainService0.ak = false;
            mainService0.k.l(b);
        }
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, arr_v[0], arr_v[1], v6 | v2, v3, v4, v5);
        MainService.a(v6, b);
        return false;
    }

    public static boolean a(String s, long v, int v1, int v2, long v3, long v4, boolean z, long v5) {
        String s1 = ov.c(s);
        boolean z1 = ov.a(((byte)0), s1, v, v1, v2, v3, v4, z, v5);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            if(z) {
                qm0.write("\ngg.clearResults()\n");
            }
            if(!z && MainService.instance.aj != 0L) {
                qm0.write("gg.refineAddress(");
            }
            else {
                qm0.write("gg.searchAddress(");
            }
            Script.Consts.b(qm0, s1);
            qm0.write(", ");
            Script.Consts.a(qm0, v);
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.b, v1);
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.d, v2);
            qm0.write(", ");
            Script.Consts.a(qm0, v3);
            qm0.write(", ");
            Script.Consts.a(qm0, v4);
            qm0.write(", ");
            qm0.write(Long.toString(v5));
            qm0.write(")\n");
        }
        return z1;
    }

    @Override  // android.ext.re
    public void a(DialogInterface dialogInterface0, int v) {
        boolean z = true;
        String s = this.h.f();
        long v1 = this.h.h();
        int v2 = this.h.e();
        long v3 = this.h.d(0);
        long v4 = this.h.d(1);
        if(this.g != -3) {
            z = false;
        }
        ov.a(s, v1, v, v2, v3, v4, z, this.h.p());
    }

    @Override  // android.ext.re
    public void onDismiss(DialogInterface dialogInterface0) {
        this.b = this.h.f();
        this.d = this.h.g();
        MainService.ai = this.h.d();
        this.c = this.h.e();
        super.onDismiss(dialogInterface0);
    }
}

