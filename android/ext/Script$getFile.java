package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getFile extends Script.DebugFunction {
    final Script e;

    Script.getFile(Script script0) {
        this.e = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getFile() -> string";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s;
        if(this.d == null) {
            s = "?";
        }
        else if(this.d.d != null) {
            s = this.d.d;
        }
        else if(this.d.a == null) {
            s = "???";
        }
        else if(this.d.a.w != null) {
            s = this.d.a.w.d_();
        }
        else {
            s = "??";
        }
        if(s.startsWith("@")) {
            s = s.substring(1);
        }
        return LuaValue.m(s);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

