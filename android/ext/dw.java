package android.ext;

import android.widget.CheckBox;

class dw implements Runnable {
    final dv a;
    private final String b;
    private final CheckBox c;

    dw(dv dv0, String s, CheckBox checkBox0) {
        this.a = dv0;
        this.b = s;
        this.c = checkBox0;
        super();
    }

    @Override
    public void run() {
        du du0 = this.a.a;
        boolean z = this.c.isChecked();
        du0.a(this.b, z);
    }
}

