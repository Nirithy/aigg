package luaj.lib;

import luaj.ap;

final class StringLib.find extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return StringLib.b(ap0, true);
    }
}

