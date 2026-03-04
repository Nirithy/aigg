package luaj.lib;

import luaj.ap;

final class StringLib.match extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return StringLib.b(ap0, false);
    }
}

