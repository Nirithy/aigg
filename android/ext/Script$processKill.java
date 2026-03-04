package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.processKill extends Script.ApiFunction {
    final Script d;
    private int e;
    private long f;

    Script.processKill(Script script0) {
        this.d = script0;
        super();
        this.e = 0;
        this.f = 0L;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.processKill() -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        long v = System.nanoTime();
        if(v / 60000000000L != this.f) {
            this.f = v / 60000000000L;
            this.e = 0;
        }
        int v1 = this.e + 1;
        this.e = v1;
        if(v1 > 4) {
            this.d.a_(3);
        }
        return LuaValue.b(MainService.instance.d(this.d.a()));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

