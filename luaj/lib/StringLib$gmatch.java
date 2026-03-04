package luaj.lib;

import luaj.ap;

final class StringLib.gmatch extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return new StringLib.GMatchAux(ap0, ap0.s(1), ap0.s(2));
    }
}

