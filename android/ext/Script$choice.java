package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.choice extends Script.ApiFunction implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private volatile int d;

    Script.choice() {
        this.d = 0;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.choice(table items [, string selected = nil [, string message = nil]]) -> string || nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        LuaValue luaValue0 = ap0.c(2);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        z z0 = luaTable0.S();
        int v1 = -1;
        for(int v = 0; z0.a(); ++v) {
            LuaValue luaValue1 = z0.c();
            LuaValue luaValue2 = z0.d();
            if(luaValue1.b(luaValue0)) {
                v1 = v;
            }
            arrayList1.add(qk.a(luaValue2.y()));
            arrayList0.add(luaValue1);
        }
        String s = qk.a(ap0.c(3, ""));
        CharSequence[] arr_charSequence = (CharSequence[])arrayList1.toArray(new CharSequence[arrayList1.size()]);
        this.d = -1;
        synchronized(this) {
            rx.a(new Script.choice.1(this, (s.length() <= 0 ? null : "\n" + s), luaValue0, arr_charSequence, v1));
            Script.a(this);
        }
        return this.d >= 0 ? ((LuaValue)arrayList0.get(this.d)) : LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.d = v;
        Tools.a(dialogInterface0);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this) {
            this.notify();
        }
        MainService.instance.b(false);
    }
}

