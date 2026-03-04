package android.ext;

import luaj.ap;
import luaj.lib.VarArgFunction;

final class Script.exit extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        throw new Script.OsExit(ap0.d(1, 0));
    }
}

