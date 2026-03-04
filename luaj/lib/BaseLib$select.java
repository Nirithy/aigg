package luaj.lib;

import luaj.ap;

final class BaseLib.select extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = ap0.j_();
        if(ap0.g().equals(BaseLib.select.m("#"))) {
            return BaseLib.select.d(v - 1);
        }
        int v1 = ap0.o(1);
        if(v1 == 0 || v1 < -(v - 1)) {
            BaseLib.select.a(1, "index out of range");
        }
        return v1 >= 0 ? ap0.e_(v1 + 1) : ap0.e_(v + v1 + 1);
    }
}

