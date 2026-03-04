package android.ext;

import java.util.ArrayList;
import luaj.LuaValue;
import luaj.ap;

final class Script.loadResults extends Script.BusyApiFunction {
    ArrayList e;
    final Script f;

    Script.loadResults(Script script0) {
        this.f = script0;
        super(script0);
        this.e = null;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.loadResults(table results) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        this.f.g = false;
        ArrayList arrayList0 = Script.a(ap0);
        MainService.instance.a(this.f.a());
        if(arrayList0.size() == 0) {
            return LuaValue.v;
        }
        this.e = arrayList0;
        return super.b(ap0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            MainService.instance.k.a(this.f.a(), this.e);
            this.e = null;
            return null;
        }
        catch(Throwable throwable0) {
            this.e = null;
            throw throwable0;
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

