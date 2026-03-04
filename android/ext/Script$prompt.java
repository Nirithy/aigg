package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;

final class Script.prompt extends Script.ApiFunction implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, View.OnFocusChangeListener {
    volatile ArrayList d;
    final Script e;
    private volatile int f;
    private volatile LuaTable g;

    Script.prompt(Script script0) {
        this.e = script0;
        super();
        this.f = 0;
        this.g = null;
        this.d = null;
    }

    private void a(View view0) {
        view0.setVisibility(8);
        Tools.d(view0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.prompt(table prompts [, table defaults = {} [, table types = {} ]]) -> nil || table with keys from prompts and values from inputs";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        LuaTable luaTable1 = ap0.a(2, null);
        LuaTable luaTable2 = ap0.a(3, null);
        this.f = 0;
        ArrayList arrayList0 = new ArrayList();
        this.d = arrayList0;
        this.g = new LuaTable();
        synchronized(this) {
            rx.a(new Script.prompt.1(this, luaTable0, luaTable1, luaTable2, arrayList0));
            Script.a(this);
        }
        this.d = null;
        ap ap1 = this.g;
        this.g = null;
        return this.f == 0 ? LuaValue.u : ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            this.f = 1;
            ArrayList arrayList0 = this.d;
            LuaTable luaTable0 = this.g;
            if(arrayList0 != null && luaTable0 != null) {
                for(Object object0: arrayList0) {
                    TextView textView0 = (TextView)object0;
                    if(textView0 != null) {
                        LuaValue luaValue0 = (LuaValue)textView0.getTag();
                        if(luaValue0 == null) {
                        }
                        else if(textView0 instanceof EditText) {
                            String s = textView0.getText().toString();
                            int v1 = textView0 instanceof ha ? ((ha)textView0).getDataType() : -1;
                            String s1 = v1 != 1 && v1 != 8 && v1 != 16 ? s : Script.a_(s);
                            luaTable0.c(luaValue0, LuaValue.m(s1));
                            iw.a(s1, v1);
                        }
                        else if(textView0 instanceof CheckBox) {
                            luaTable0.c(luaValue0, LuaValue.b(((CheckBox)textView0).isChecked()));
                        }
                        else if(textView0 instanceof TextView) {
                            String s2 = textView0.getText().toString();
                            luaTable0.c(luaValue0, LuaValue.m(s2));
                            iw.a(s2, 1);
                        }
                    }
                }
            }
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this) {
            this.notify();
        }
        MainService.instance.b(false);
    }

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        boolean z1;
        if((Config.B & 1) != 0 && z) {
            InternalKeyboard internalKeyboard0 = (InternalKeyboard)view0.getRootView().findViewById(0x7F0B002A);  // id:keyboard
            if(internalKeyboard0 != null && view0 instanceof ha) {
                switch(((ha)view0).getDataType()) {
                    case 2: 
                    case 4: {
                        z1 = true;
                        break;
                    }
                    default: {
                        z1 = false;
                    }
                }
                internalKeyboard0.b(view0, z1);
                if(!z1) {
                    Tools.e(view0);
                }
            }
        }
    }
}

