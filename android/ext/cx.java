package android.ext;

import android.view.View.OnClickListener;
import android.view.View;

class cx implements View.OnClickListener {
    final cw a;

    cx(cw cw0) {
        this.a = cw0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        i.a(i.c().setMessage(qk.a(this.a.a) + '\n' + qk.a(this.a.h)).setNegativeButton(qk.a(0x7F07009D), null));  // string:ok "OK"
    }
}

