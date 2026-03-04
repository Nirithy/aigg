package android.ext;

import android.app.AlertDialog;

class Script.multiChoice.1 implements Runnable {
    final Script.multiChoice a;
    private final String b;
    private final CharSequence[] c;

    Script.multiChoice.1(Script.multiChoice script$multiChoice0, String s, CharSequence[] arr_charSequence) {
        this.a = script$multiChoice0;
        this.b = s;
        this.c = arr_charSequence;
        super();
    }

    @Override
    public void run() {
        AlertDialog alertDialog0 = i.a(Tools.o()).setCustomTitle(Tools.b(Tools.c(0x7F07021A), this.b)).setPositiveButton(qk.a(0x7F07009D), this.a).setNegativeButton(qk.a(0x7F0700A1), this.a).setMultiChoiceItems(this.c, this.a.d, this.a).create();  // string:script "Script:"
        i.a(alertDialog0, this.a);
        i.c(alertDialog0);
        MainService.instance.b(true);
    }
}

