package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.fix.j;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class ik extends re implements View.OnClickListener {
    private j a;
    private long j;
    private long k;
    private long l;

    public ik() {
        super(0x7F070101, 0x7F02002B);  // string:search_unknown_value "Unknown (fuzzy) search"
        this.j = 0L;
        this.k = -1L;
        this.l = 0L;
    }

    private void a() {
        MainService mainService0 = MainService.instance;
        if(!mainService0.k.y()) {
            return;
        }
        int v = MainService.a();
        if(mainService0.aj == 0L) {
            this.h = new Searcher(1, v);
            this.a = this.h.b(v);
            this.h.a(qk.a(0x7F0700EE));  // string:type_request "Select the type of data to search"
            AlertDialog alertDialog0 = i.c().setView(this.h.l()).setPositiveButton(qk.a(0x7F07008B), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:search "Search"
            i.a(alertDialog0, this);
            i.a(alertDialog0, this);
            this.i = new WeakReference(alertDialog0);
            i.c(alertDialog0);
            return;
        }
        this.h = new Searcher(2, v);
        this.a = this.h.b(v);
        this.h.a(qk.a(0x7F070097));  // string:compare_current_last "How has the value changed?"
        this.h.a(this);
        View view0 = this.h.l();
        ((Button)view0.findViewById(0x7F0B013C)).setOnClickListener(this);  // id:equal_btn
        ((Button)view0.findViewById(0x7F0B013D)).setOnClickListener(this);  // id:not_equal_btn
        ((Button)view0.findViewById(0x7F0B013E)).setOnClickListener(this);  // id:larger_btn
        ((Button)view0.findViewById(0x7F0B013F)).setOnClickListener(this);  // id:smaller_btn
        AlertDialog alertDialog1 = i.c().setView(view0).create();
        i.a(alertDialog1, this);
        i.a(alertDialog1, this);
        this.i = new WeakReference(alertDialog1);
        i.a(alertDialog1, this.h.o());
    }

    public static boolean a(byte b, int v, long v1, long v2, long v3) {
        MainService mainService0 = MainService.instance;
        if((v & 0x7F) == 0) {
            mainService0.a(b);
            return true;
        }
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(mainService0.aj != 0L) {
            mainService0.a(b);
        }
        mainService0.ak = true;
        mainService0.k.l(b);
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, v & 0x7F, v1, v2, v3);
        MainService.a(v & 0x7F, b);
        return false;
    }

    public static boolean a(byte b, String s, int v, int v1, int v2, long v3, long v4, long v5) {
        int v11;
        int v10;
        long v9;
        long v6 = 0L;
        int v7 = v1 & 0x3C000000;
        MainService mainService0 = MainService.instance;
        int v8 = MainService.a() & 0x7F & (v & 0x7F);
        if(v8 == 0) {
            mainService0.a(b);
            return true;
        }
        boolean z = s.indexOf(0x7E) != -1;
        pv pv0 = new pv();
        if(z) {
            if(v7 != 0x10000000 && v7 != 0x20000000) {
                throw new NumberFormatException(Tools.a(qk.a(0x7F07018C), new Object[]{qk.a(0x7F07018A), d.b().get(v7)}));  // string:does_not_support "\"__s__\" does not support \"__s__\"."
            }
            rc rc0 = ra.a(pv0, s, v8, v7);
            v9 = rc0.a;
            v6 = rc0.b;
            v10 = rc0.c;
            v7 = rc0.d;
        }
        else {
            v9 = d.a(pv0, s, v8);
            v10 = v8 & pv0.c;
        }
        if(Integer.bitCount(v10) > 1) {
            v10 = d.a(v10, v9, pv0.b);
            v11 = v6 == 0L ? v10 : d.a(v10, v6, pv0.b);
        }
        else {
            v11 = v10;
        }
        if(!mainService0.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        mainService0.b(b);
        mainService0.al = false;
        mainService0.k.a(b, v9, v6, (z ? v11 | 0x800000 : v11), v7, v2, v3, v4, v5);
        MainService.a(v11, b);
        return false;
    }

    public static boolean a(int v, long v1, long v2, long v3) {
        boolean z = ik.a(((byte)0), v, v1, v2, v3);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("\ngg.startFuzzy(");
            Script.Consts.a(qm0, qm0.a.b, v);
            qm0.write(", ");
            Script.Consts.a(qm0, v1);
            qm0.write(", ");
            Script.Consts.a(qm0, v2);
            qm0.write(", ");
            qm0.write(Long.toString(v3));
            qm0.write(")\n");
        }
        return z;
    }

    public static boolean a(String s, int v, int v1, int v2, long v3, long v4, long v5) {
        String s1 = ik.c(s);
        boolean z = ik.a(((byte)0), s1, v, v1, v2, v3, v4, v5);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("gg.searchFuzzy(");
            Script.Consts.a(qm0, s1);
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.c, v1);
            qm0.write(", ");
            Script.Consts.a(qm0, qm0.a.b, v);
            qm0.write(", ");
            Script.Consts.a(qm0, v3);
            qm0.write(", ");
            Script.Consts.a(qm0, v4);
            qm0.write(", ");
            qm0.write(Long.toString(v5));
            qm0.write(")\n");
        }
        return z;
    }

    @Override  // android.ext.re
    public void a(DialogInterface dialogInterface0, int v) {
    }

    private void b() {
        View view0 = android.fix.i.a(0x7F040020, null);  // layout:service_fuzzy_equal
        SeekBar seekBar0 = (SeekBar)view0.findViewById(0x7F0B011C);  // id:count_fuzzy_equal_seekbar
        seekBar0.setOnSeekBarChangeListener(new il(this, ((TextView)view0.findViewById(0x7F0B011B))));  // id:count_fuzzy_equal
        i.a(i.c().setCustomTitle(Tools.d(0x7F0700CA)).setMessage(qk.a(0x7F0700C4)).setPositiveButton(qk.a(0x7F07009D), new im(this, seekBar0)).setNegativeButton(qk.a(0x7F0700A1), null).setView(view0));  // string:fuzzy_equal "Value unchanged"
    }

    @Override  // android.ext.re
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            this.onClick(((AlertDialog)dialogInterface0).getButton(-1));
            return;
        }
        if(MainService.instance.aj == 0L) {
            MainService.ai = v;
            ik.a(v, this.j, this.k, this.l);
        }
    }

    @Override  // android.ext.re, android.view.View$OnClickListener
    public void onClick(View view0) {
        int v1;
        MainService mainService0 = MainService.instance;
        if(view0 == null || view0.getTag() instanceof pj) {
            new ik().a();
            return;
        }
        if(view0.getTag() instanceof Integer && mainService0.aj == 0L) {
            try {
                this.j = this.h.d(0);
                this.k = this.h.d(1);
                this.l = this.h.p();
            }
            catch(NumberFormatException numberFormatException0) {
                re.a(numberFormatException0, null);
                return;
            }
            Tools.a(this.i);
            int v = this.h.d();
            if(v == 0) {
                new tu(this.a, "0", qk.a(0x7F0700EE), this);  // string:type_request "Select the type of data to search"
            }
            else {
                ik.a(v, this.j, this.k, this.l);
            }
        }
        switch(view0.getId()) {
            case 0x7F0B013C: {  // id:equal_btn
                if(!Searcher.b && !mainService0.N) {
                    this.b();
                    v1 = 0;
                }
                else {
                    v1 = 0x20000000;
                }
                break;
            }
            case 0x7F0B013D: {  // id:not_equal_btn
                v1 = 0x10000000;
                break;
            }
            case 0x7F0B013E: {  // id:larger_btn
                v1 = 0x4000000;
                break;
            }
            case 0x7F0B013F: {  // id:smaller_btn
                v1 = 0x8000000;
                break;
            }
            default: {
                v1 = 0;
            }
        }
        if(v1 != 0) {
            try {
                int v2 = this.h.d();
                if(v2 == 0 || !Searcher.b) {
                    v2 = MainService.a() & 0x7F;
                }
                ik.a(this.h.f(), v2, v1, 1, this.h.d(0), this.h.d(1), this.h.p());
            }
            catch(NumberFormatException numberFormatException1) {
                re.a(numberFormatException1, this.h.o());
                return;
            }
        }
        Tools.a(this.i);
        Tools.b(this.i);
    }

    @Override  // android.ext.re
    public void onDismiss(DialogInterface dialogInterface0) {
        MainService.ai = this.h.d();
        super.onDismiss(dialogInterface0);
    }
}

