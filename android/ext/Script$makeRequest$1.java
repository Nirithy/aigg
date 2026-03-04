package android.ext;

import android.app.AlertDialog;

class Script.makeRequest.1 implements Runnable {
    final Script.makeRequest a;

    Script.makeRequest.1(Script.makeRequest script$makeRequest0) {
        this.a = script$makeRequest0;
        super();
    }

    @Override
    public void run() {
        AlertDialog alertDialog0 = i.c().setCustomTitle(Tools.i(Tools.c(0x7F07021A))).setMessage(qk.a(0x7F0702C1)).setPositiveButton(qk.a(0x7F07009B), this.a).setNegativeButton(qk.a(0x7F07009C), null).create();  // string:script "Script:"
        i.a(alertDialog0, this.a);
        i.c(alertDialog0);
    }
}

