package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.setVisible extends Script.ApiFunction {
    final Script d;
    private int e;
    private long f;

    Script.setVisible(Script script0) {
        this.d = script0;
        super();
        this.e = 0;
        this.f = 0L;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.setVisible(bool visible) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        boolean z = true;
        MainService mainService0 = MainService.instance;
        if(!ap0.k(1)) {
            if(mainService0.p == null) {
                z = false;
            }
            else {
                mainService0.c(false);
            }
            mainService0.Z.a();
        }
        else if(mainService0.p == null) {
            mainService0.M();
        }
        else {
            z = false;
        }
        if(z) {
            long v = System.nanoTime();
            if(v / 60000000000L != this.f) {
                this.f = v / 60000000000L;
                this.e = 0;
            }
            int v1 = this.e + 1;
            this.e = v1;
            if(v1 > 30) {
                this.d.a_(2);
            }
        }
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

