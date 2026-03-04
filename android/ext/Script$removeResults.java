package android.ext;

import java.util.ArrayList;
import luaj.LuaValue;
import luaj.ap;

final class Script.removeResults extends Script.ApiFunction {
    final Script d;

    Script.removeResults(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.removeResults(table results) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        this.d.g = false;
        ArrayList arrayList0 = Script.a(ap0);
        MainService.instance.k.b(this.d.a(), arrayList0);
        Object object0 = new Object();
        synchronized(object0) {
            rx.a(new Script.removeResults.1(this, object0));
            Script.a(object0);
            return LuaValue.v;
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

