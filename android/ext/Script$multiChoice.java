package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.multiChoice extends Script.ApiFunction implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnMultiChoiceClickListener {
    volatile boolean[] d;
    private volatile boolean e;

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.multiChoice(table items [, table selection = {} [, string message = nil]]) -> table || nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        LuaTable luaTable1 = ap0.a(2, null);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        z z0 = luaTable0.S();
        while(z0.a()) {
            LuaValue luaValue0 = z0.c();
            LuaValue luaValue1 = z0.d();
            CharSequence charSequence0 = Build.VERSION.SDK_INT < 11 ? Tools.a(qk.a(luaValue1.y()), -1) : qk.a(luaValue1.y());
            arrayList1.add(charSequence0);
            arrayList2.add(Boolean.valueOf(luaTable1 != null && Script.a(luaTable1, luaValue0, false)));
            arrayList0.add(luaValue0);
        }
        this.d = Tools.a(arrayList2);
        this.e = false;
        String s = qk.a(ap0.c(3, ""));
        CharSequence[] arr_charSequence = (CharSequence[])arrayList1.toArray(new CharSequence[arrayList1.size()]);
        synchronized(this) {
            rx.a(new Script.multiChoice.1(this, (s.length() <= 0 ? null : "\n" + s), arr_charSequence));
            Script.a(this);
        }
        if(!this.e) {
            return LuaValue.u;
        }
        LuaTable luaTable2 = new LuaTable();
        for(int v = 0; v < arrayList0.size(); ++v) {
            if(this.d[v]) {
                luaTable2.c(((LuaValue)arrayList0.get(v)), LuaValue.v);
            }
        }
        return luaTable2;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            this.e = true;
        }
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        this.d[v] = z;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this) {
            this.notify();
        }
        MainService.instance.b(false);
    }
}

