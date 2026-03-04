package android.ext;

import luaj.LuaClosure;

public abstract class Script.DebugFunction extends Script.ApiFunction {
    protected LuaClosure d;

    public Script.DebugFunction() {
        this.d = null;
    }

    public void a(LuaClosure luaClosure0) {
        this.d = luaClosure0;
    }
}

