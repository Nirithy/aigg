package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pf implements DialogInterface.OnClickListener {
    private int a;
    private final List b;

    public pf() {
        this.a = 0;
        this.b = new ArrayList();
    }

    public long a() {
        return this.a <= 0 || this.a > this.b.size() ? 0L : ((pg)this.b.get(this.a - 1)).a;
    }

    public boolean a(long v, CharSequence charSequence0) {
        return this.a(v, charSequence0, 0);
    }

    public boolean a(long v, CharSequence charSequence0, int v1) {
        int v2 = this.b.size();
        if(this.a < v2) {
            for(int v3 = v2 - 1; v3 >= this.a; --v3) {
                this.b.remove(v3);
            }
            v2 = this.a;
        }
        if(v2 >= 100) {
            --this.a;
            this.b.remove(0);
        }
        ++this.a;
        qh qh0 = MainService.instance.ap;
        pg pg0 = new pg(v, charSequence0, (qh0 == null ? null : qh0.c), v1);
        return this.b.add(pg0);
    }

    public void b() {
        int v = this.b.size();
        if(v == 0) {
            Tools.a(0x7F07011B);  // string:history_empty "History is empty"
            return;
        }
        CharSequence[] arr_charSequence = new CharSequence[v];
        Drawable[] arr_drawable = new Drawable[v];
        HashMap hashMap0 = new HashMap();
        for(int v1 = 0; v1 < v; ++v1) {
            pg pg0 = (pg)this.b.get(v1);
            arr_charSequence[v1] = pg0.a();
            if(pg0.b != null) {
                Drawable drawable0 = (Drawable)hashMap0.get(pg0.b);
                if(drawable0 == null) {
                    try {
                        drawable0 = Tools.a(Tools.a(Tools.b(Tools.j(pg0.b)), Tools.b()));
                    }
                    catch(Throwable throwable0) {
                        la.c(("Failed load icon for " + pg0.b), throwable0);
                    }
                    hashMap0.put(pg0.b, drawable0);
                }
                arr_drawable[v1] = drawable0;
            }
        }
        AlertDialog alertDialog0 = i.a(Tools.o()).setCustomTitle(Tools.d(0x7F070100)).setSingleChoiceItems(arr_charSequence, this.a - 1, this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:goto_address "Go to the address:"
        ListView listView0 = alertDialog0.getListView();
        if(listView0 != null) {
            Tools.a(listView0, arr_charSequence, arr_drawable, 0x30, 0x7F090002);  // style:SmallText
        }
        i.c(alertDialog0);
    }

    public void c() {
        if(this.b.size() == 0) {
            Tools.a(0x7F07011B);  // string:history_empty "History is empty"
            return;
        }
        if(this.a < 2) {
            Tools.a(0x7F07024B, 0);  // string:no_previous "No previous entries"
            return;
        }
        this.onClick(null, this.a - 2);
    }

    public void d() {
        int v = this.b.size();
        if(v == 0) {
            Tools.a(0x7F07011B);  // string:history_empty "History is empty"
            return;
        }
        if(this.a >= v) {
            Tools.a(0x7F07024C, 0);  // string:no_next "No next entries"
            return;
        }
        this.onClick(null, this.a);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        pg pg0 = (pg)this.b.get(v);
        if(pg0 != null) {
            this.a = v + 1;
            MainService.instance.a(pg0.a, pg0.c);
        }
        if(dialogInterface0 != null) {
            Tools.a(dialogInterface0);
        }
    }
}

