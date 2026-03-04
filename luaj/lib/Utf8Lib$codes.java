package luaj.lib;

import luaj.ap;

final class Utf8Lib.codes extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return new Utf8Lib.CodesAux(ap0.s(1));
    }
}

