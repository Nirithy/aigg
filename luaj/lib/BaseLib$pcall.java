package luaj.lib;

import luaj.LuaClosure;
import luaj.ap;

final class BaseLib.pcall extends VarArgFunction {
    final BaseLib a;

    BaseLib.pcall(BaseLib baseLib0) {
        this.a = baseLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return LuaClosure.a(this.a.a, this, ap0.v(1), ap0.e_(2));
    }
}

