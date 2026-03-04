package android.ext;

import android.c.a;
import luaj.LuaTable;
import luaj.ap;

final class Script.getSelectedResults extends Script.ApiFunction {
    final Script d;

    Script.getSelectedResults(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getSelectedResults() -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        a a0 = MainService.instance.am;
        ap ap1 = new LuaTable();
        int v = 1;
        for(int v1 = 0; v1 < a0.b(); ++v1) {
            try {
                if(a0.b(v1)) {
                    d d0 = a0.a(v1, null);
                    if(d0 != null) {
                        try {
                            ((LuaTable)ap1).b(v, Script.b(null, d0));
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

