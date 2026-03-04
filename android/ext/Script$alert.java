package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import luaj.LuaValue;
import luaj.ap;

final class Script.alert extends Script.ApiFunction implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private volatile int d;

    Script.alert() {
        this.d = 0;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.alert(string text [, string positive = \'ok\' [, string negative = nil [, string neutral = nil]]]) -> int: 0 = cancel, 1 = positive, 2 = negative, 3 = neutral";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.r(1);
        String s1 = ap0.c(2, qk.a(0x7F07009D));  // string:ok "OK"
        String s2 = ap0.c(3, null);
        String s3 = ap0.c(4, null);
        this.d = 0;
        synchronized(this) {
            rx.a(new Script.alert.1(this, s, s1, s2, s3));
            Script.a(this);
        }
        return LuaValue.d(this.d);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 4;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.d = -v;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this) {
            this.notify();
        }
        MainService.instance.b(false);
    }
}

