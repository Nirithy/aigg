package luaj.lib;

import luaj.LuaClosure;
import luaj.ap;

final class DebugLib.upvaluejoin extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaClosure luaClosure0 = ap0.l(1);
        int v = ap0.o(2);
        LuaClosure luaClosure1 = ap0.l(3);
        int v1 = ap0.o(4);
        if(v < 1 || v > luaClosure0.b.length) {
            this.g("index out of range");
        }
        if(v1 < 1 || v1 > luaClosure1.b.length) {
            this.g("index out of range");
        }
        luaClosure0.b[v - 1] = luaClosure1.b[v1 - 1];
        return DebugLib.upvaluejoin.x;
    }
}

