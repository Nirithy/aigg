package android.ext;

import android.c.a;
import android.c.e;
import android.view.View;
import java.util.List;

class oj extends of {
    final MainService d;

    public oj(MainService mainService0) {
        this.d = mainService0;
        super(mainService0, 0x7F0702BE, 0x7F020047);  // string:selected_as_search_result "Selected as search result"
    }

    oj(MainService mainService0, int v, int v1) {
        this.d = mainService0;
        super(mainService0, v, v1);
    }

    @Override  // android.ext.of
    void a(List list0, Object object0) {
        if(list0.size() == 0) {
            this.d.a(0);
            return;
        }
        if(!this.d.S()) {
            throw new NumberFormatException(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
        }
        if(this.d.aj != 0L) {
            this.d.a(0);
        }
        this.d.ak = false;
        this.d.k.l(0);
        this.d.b(0);
        this.d.al = false;
        this.d.k.a(0, list0);
        this.d.o.setCurrentTab(1);
        if(object0 instanceof a || object0 instanceof e) {
            qm qm0 = this.d.h;
            if(qm0 != null) {
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("\nlocal t = ");
                if(object0 instanceof a) {
                    ek.a(qm0, true);
                }
                else {
                    stringBuilder0.append("gg.getListItems()\n");
                }
                stringBuilder0.append("gg.loadResults(t)\n");
                stringBuilder0.append("t = nil\n");
            }
        }
    }

    @Override  // android.ext.of
    public void onClick(View view0) {
        if(this.d.aj == 0L) {
            this.a();
            return;
        }
        i.a(i.c().setMessage(qk.a(0x7F0702BF)).setPositiveButton(qk.a(0x7F07009B), new ok(this)).setNegativeButton(qk.a(0x7F07009C), null));  // string:clear_results_prompt "This will replace the current search results. Continue?"
    }
}

