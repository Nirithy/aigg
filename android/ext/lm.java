package android.ext;

import android.fix.i;
import android.view.View;
import android.widget.TextView;

class lm implements Runnable {
    final ll a;
    private final StringBuilder b;
    private final String c;

    lm(ll ll0, StringBuilder stringBuilder0, String s) {
        this.a = ll0;
        this.b = stringBuilder0;
        this.c = s;
        super();
    }

    @Override
    public void run() {
        View view0 = i.a(0x7F04000A, null);  // layout:main_new_version
        Tools.a(((TextView)view0.findViewById(0x7F0B003C)), this.b.toString());  // id:changelog
        android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.i(Tools.a(qk.a(0x7F0700A2), new Object[]{this.c}))).setView(view0).setCancelable(false).setPositiveButton(qk.a(0x7F070155), new be(null)).setNegativeButton(qk.a(0x7F07009D), null));  // string:found_new_version "Found new version __s__"
    }
}

