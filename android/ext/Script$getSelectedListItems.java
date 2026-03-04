package android.ext;

import android.c.e;
import luaj.LuaTable;
import luaj.ap;

final class Script.getSelectedListItems extends Script.ApiFunction {
    final Script d;

    Script.getSelectedListItems(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getSelectedListItems() -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        e e0 = MainService.instance.an.b();
        ap ap1 = new LuaTable();
        int v = 1;
        for(int v1 = 0; v1 < e0.b(); ++v1) {
            try {
                if(e0.d(v1)) {
                    qx qx0 = (qx)e0.c(v1);
                    if(qx0 != null) {
                        try {
                            ((LuaTable)ap1).b(v, Script.a(qx0));
                        }
                        catch(IndexOutOfBoundsException unused_ex) {
                        }
                        ++v;
                    }
                }
            }
            catch(IndexOutOfBoundsException unused_ex) {
            }
        }
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

