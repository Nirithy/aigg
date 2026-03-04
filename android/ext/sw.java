package android.ext;

import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.view.View;

class sw implements View.OnClickListener {
    private final String a;
    private final int b;

    sw(String s, int v) {
        this.a = s;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        AlertDialog alertDialog0 = i.c().setMessage(qk.a(this.a) + '\n' + qk.a(this.b)).setNegativeButton(qk.a(0x7F07009D), null).create();  // string:ok "OK"
        i.c(alertDialog0);
        i.a(alertDialog0, new sx(this, alertDialog0));
    }
}

