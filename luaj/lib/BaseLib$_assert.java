package luaj.lib;

import luaj.ap;
import luaj.o;

final class BaseLib._assert extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        if(ap0.j_() == 0) {
            BaseLib._assert.a(1, "assert", "value expected");
        }
        if(!ap0.w(1)) {
            throw ap0.j_() == 1 ? new o("assertion failed!") : new o(ap0.c(2));
        }
        return ap0;
    }
}

