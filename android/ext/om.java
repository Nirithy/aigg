package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class om implements DialogInterface.OnClickListener {
    final ol a;
    private final int b;
    private final Object c;

    om(ol ol0, int v, Object object0) {
        this.a = ol0;
        this.b = v;
        this.c = object0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v > 2 && this.b == 0) {
            Tools.a(0x7F07013C);  // string:nothing_selected "Nothing selected"
            return;
        }
        switch(v) {
            case 0: {
                i.a(i.c().setCustomTitle(Tools.d(0x7F0702CD)).setPositiveButton(qk.a(0x7F07009B), new on(this)).setNegativeButton(qk.a(0x7F07009C), null));  // string:remove_all2 "Remove all"
                return;
            }
            case 1: {
                rx.a().postDelayed(new oo(this, dialogInterface0), 1000L);
                return;
            }
            case 2: {
                this.a.b.a(this.c, null);
                break;
            }
            case 3: {
                break;
            }
            default: {
                return;
            }
        }
        this.a.b.a(this.c);
    }
}

