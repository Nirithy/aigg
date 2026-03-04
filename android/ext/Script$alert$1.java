package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;

class Script.alert.1 implements Runnable {
    final Script.alert a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    Script.alert.1(Script.alert script$alert0, String s, String s1, String s2, String s3) {
        this.a = script$alert0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        super();
    }

    @Override
    public void run() {
        AlertDialog.Builder alertDialog$Builder0 = i.c().setCustomTitle(Tools.i(Tools.c(0x7F07021A))).setMessage(qk.a(this.b)).setPositiveButton(qk.a(this.c), this.a);  // string:script "Script:"
        if(this.d != null) {
            alertDialog$Builder0.setNegativeButton(qk.a(this.d), this.a);
        }
        if(this.e != null) {
            alertDialog$Builder0.setNeutralButton(qk.a(this.e), this.a);
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        i.a(alertDialog0, this.a);
        i.c(alertDialog0);
        MainService.instance.b(true);
    }
}

