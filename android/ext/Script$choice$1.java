package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import luaj.LuaValue;

class Script.choice.1 implements Runnable {
    final Script.choice a;
    private final String b;
    private final LuaValue c;
    private final CharSequence[] d;
    private final int e;

    Script.choice.1(Script.choice script$choice0, String s, LuaValue luaValue0, CharSequence[] arr_charSequence, int v) {
        this.a = script$choice0;
        this.b = s;
        this.c = luaValue0;
        this.d = arr_charSequence;
        this.e = v;
        super();
    }

    @Override
    public void run() {
        AlertDialog.Builder alertDialog$Builder0 = i.c().setCustomTitle(Tools.b(Tools.c(0x7F07021A), this.b)).setNegativeButton(qk.a(0x7F0700A1), this.a);  // string:script "Script:"
        if(this.c.F()) {
            alertDialog$Builder0.setItems(this.d, this.a);
        }
        else {
            alertDialog$Builder0.setSingleChoiceItems(this.d, this.e, this.a);
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        i.a(alertDialog0, this.a);
        i.c(alertDialog0);
        MainService.instance.b(true);
    }
}

