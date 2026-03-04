package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

final class BaseLib.collectgarbage extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s = ap0.c(1, "collect");
        if("collect".equals(s)) {
            System.gc();
            return BaseLib.collectgarbage.y;
        }
        if("count".equals(s)) {
            Runtime runtime0 = Runtime.getRuntime();
            long v = runtime0.totalMemory() - runtime0.freeMemory();
            return BaseLib.collectgarbage.b(BaseLib.collectgarbage.c(((double)v) / 1024.0), BaseLib.collectgarbage.d(v % 0x400L));
        }
        if("step".equals(s)) {
            System.gc();
            return LuaValue.v;
        }
        BaseLib.collectgarbage.a(1, "collectgarbage", "invalid option \'" + s + "\'");
        return BaseLib.collectgarbage.u;
    }
}

