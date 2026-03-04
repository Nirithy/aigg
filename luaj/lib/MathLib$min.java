package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

class MathLib.min extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        ap ap1 = ap0.v(1);
        int v = ap0.j_();
        int v1 = 2;
        while(v1 <= v) {
            ap ap2 = ap0.v(v1);
            if(!((LuaValue)ap2).p(((LuaValue)ap1))) {
                ap2 = ap1;
            }
            ++v1;
            ap1 = ap2;
        }
        return ap1;
    }
}

